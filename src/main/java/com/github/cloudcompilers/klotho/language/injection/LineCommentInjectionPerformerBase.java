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
import com.intellij.psi.tree.IElementType;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public abstract class LineCommentInjectionPerformerBase implements LanguageInjectionPerformer {

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

    private List<PsiElement> nextSiblingsUnbrokenByEmptyLines(PsiElement context) {
        PsiElement next = context.getNextSibling();
        List<PsiElement> siblings = new ArrayList<>();
        while (next instanceof PsiWhiteSpace
                || (next instanceof PsiComment
                        && ((PsiComment) next).getTokenType() == getLineCommentType())) {
            if (next.getText().chars().filter(ch -> ch == '\n').count() >= 2
                    || next.getText().contains("@klotho::")) {
                break;
            }
            if (next instanceof PsiWhiteSpace) {
                next = next.getNextSibling();
                continue;
            }

            siblings.add(next);
            next = next.getNextSibling();
        }
        return siblings;
    }
}
