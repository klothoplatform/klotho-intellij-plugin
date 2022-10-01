package com.github.cloudcompilers.klotho.language.injection;

import com.intellij.lang.Language;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.lang.injection.general.Injection;
import com.intellij.lang.javascript.JSTokenTypes;
import com.intellij.lang.javascript.JavascriptLanguage;
import com.intellij.lang.javascript.psi.jsdoc.JSDocComment;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class JSInjectionPerformer extends LineCommentInjectionPerformerBase {
    @Override
    public boolean isPrimary() {
        return true;
    }

    @Override
    protected Language getLanguage() {
        return JavascriptLanguage.INSTANCE;
    }

    @Override
    protected IElementType getLineCommentType() {
        return JSTokenTypes.END_OF_LINE_COMMENT;
    }

    @Override
    protected List<InjectionLocation> performMultilineInjection(@NotNull MultiHostRegistrar registrar, @NotNull Injection injection, @NotNull PsiElement context) {
        if ((context instanceof JSDocComment
                || JSTokenTypes.C_STYLE_COMMENT.equals(((PsiComment) context).getTokenType()))
                && context.getText().contains("@klotho::")) {
            return List.of(new InjectionLocation(null, null, (PsiLanguageInjectionHost) context, TextRange.create(0, context.getTextLength())));
        }

        return Collections.emptyList();
    }
}
