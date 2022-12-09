package com.github.cloudcompilers.klotho.language.injection;

import com.github.cloudcompilers.klotho.language.KlothoLanguage;
import com.intellij.lang.Language;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.lang.injection.general.Injection;
import com.intellij.lang.injection.general.LanguageInjectionPerformer;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import java.util.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.yaml.YAMLTokenTypes;
import org.jetbrains.yaml.psi.YAMLCompoundValue;
import org.jetbrains.yaml.psi.YAMLDocument;

public abstract class YamljectionPerformerBase implements LanguageInjectionPerformer {

    protected abstract Language getLanguage();

    protected abstract IElementType getLineCommentType();

    @Override
    public boolean performInjection(
            @NotNull MultiHostRegistrar registrar,
            @NotNull Injection injection,
            @NotNull PsiElement context) {
        List<InjectionLocation> locations = new ArrayList<>();
        locations.addAll(performMultilineInjection(registrar, injection, context));
        locations.addAll(performSingleLineInjection(registrar, injection, context));

        if (locations.isEmpty()) {
            return false;
        }

        registrar.startInjecting(KlothoLanguage.INSTANCE);
        locations.forEach((l) -> registrar.addPlace(l.prefix, l.suffix, l.host, l.range));
        registrar.doneInjecting();

        return true;
    }

    protected abstract List<InjectionLocation> performMultilineInjection(
            @NotNull MultiHostRegistrar registrar,
            @NotNull Injection injection,
            @NotNull PsiElement context);

    protected List<InjectionLocation> performSingleLineInjection(
            @NotNull MultiHostRegistrar registrar,
            @NotNull Injection injection,
            @NotNull PsiElement context) {
        List<InjectionLocation> injectionLocations = new ArrayList<>();
        if (injection.getInjectedLanguage() == KlothoLanguage.INSTANCE
                && context instanceof PsiComment
                && ((PsiComment) context).getTokenType() == getLineCommentType()
                && context.getText().contains("@klotho")
                && context.getLanguage() == getLanguage()) {

            PsiElement prev = context.getPrevSibling();
            while (prev != null && !"\n".equals(prev.getText())) {
                if (!prev.getText().strip().equals("")) {
                    return Collections.emptyList();
                }
                prev = prev.getPrevSibling();
            }

            injectionLocations.add(
                    new InjectionLocation(
                            null,
                            "\n",
                            (PsiLanguageInjectionHost) context,
                            TextRange.create(0, context.getTextLength())));

            List<PsiElement> siblings = nextSiblingsUnbrokenByEmptyLines(context);
            siblings.forEach(
                    e ->
                            injectionLocations.add(
                                    new InjectionLocation(
                                            null,
                                            "\n",
                                            (PsiLanguageInjectionHost) e,
                                            TextRange.create(0, e.getTextLength()))));
        }
        return injectionLocations;
    }

    private static final List<IElementType> whitespaceTypes =
            List.of(YAMLTokenTypes.EOL, YAMLTokenTypes.WHITESPACE, YAMLTokenTypes.INDENT);

    private List<PsiElement> nextSiblingsUnbrokenByEmptyLines(PsiElement context) {
        PsiElement next = context.getNextSibling();
        YAMLDocument doc = null;
        List<PsiElement> siblings = new ArrayList<>();
        int eolCount = 0;
        while (next != null
                        && (next instanceof PsiWhiteSpace
                                || (next instanceof LeafPsiElement
                                        && whitespaceTypes.contains(
                                                ((LeafPsiElement) next).getElementType()))
                                || (next instanceof PsiComment
                                        && ((PsiComment) next).getTokenType()
                                                == getLineCommentType()))
                || next instanceof YAMLDocument
                || next instanceof YAMLCompoundValue) {

            if (next instanceof YAMLDocument || next instanceof YAMLCompoundValue) {
                next = next.getFirstChild();
                continue;
            }

            if ("\n".equals(next.getText())) {
                eolCount++;
            }

            if (eolCount == 2 || next.getText().contains("@klotho::")) {
                break;
            }

            if (next instanceof PsiWhiteSpace
                    || whitespaceTypes.contains(((LeafPsiElement) next).getElementType())) {
                next = next.getNextSibling();
                continue;
            }

            siblings.add(next);
            eolCount = 0;

            while (next != null && next.getNextSibling() == null) {
                next = next.getParent();
            }
            if (next != null) {
                next = next.getNextSibling();
            }
        }
        return siblings;
    }
}
