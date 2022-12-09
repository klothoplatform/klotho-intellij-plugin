package com.github.cloudcompilers.klotho.language.injection;

import com.goide.GoLanguage;
import com.goide.GoParserDefinition;
import com.intellij.lang.Language;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.lang.injection.general.Injection;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.tree.IElementType;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class GoInjectionPerformer extends LineCommentInjectionPerformerBase {
    @Override
    public boolean isPrimary() {
        return true;
    }

    @Override
    protected Language getLanguage() {
        return GoLanguage.INSTANCE;
    }

    @Override
    protected IElementType getLineCommentType() {
        return GoParserDefinition.Lazy.LINE_COMMENT;
    }

    @Override
    protected List<InjectionLocation> performMultilineInjection(
            @NotNull MultiHostRegistrar registrar,
            @NotNull Injection injection,
            @NotNull PsiElement context) {

        if (GoParserDefinition.Lazy.MULTILINE_COMMENT.equals(((PsiComment) context).getTokenType())
                && context.getText().contains("@klotho::")) {
            return List.of(
                    new InjectionLocation(
                            null,
                            null,
                            (PsiLanguageInjectionHost) context,
                            TextRange.create(0, context.getTextLength())));
        }

        return Collections.emptyList();
    }
}
