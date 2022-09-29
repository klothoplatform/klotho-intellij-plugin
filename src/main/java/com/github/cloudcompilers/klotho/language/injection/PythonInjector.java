package com.github.cloudcompilers.klotho.language.injection;

import com.intellij.lang.javascript.JSTokenTypes;
import com.intellij.lang.javascript.JavascriptLanguage;
import com.intellij.lang.javascript.psi.jsdoc.JSDocComment;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.jetbrains.python.PyElementTypes;
import com.jetbrains.python.PyTokenTypes;
import com.jetbrains.python.PythonLanguage;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;


public final class PythonInjector extends KlothoMultiHostInjectorBase {

    @Override
    protected List<InjectionLocation> getLocationsToInject(@NotNull PsiComment context) {

        if (context.getLanguage() != PythonLanguage.INSTANCE) {
            return Collections.emptyList();
        }

        if (PyTokenTypes.END_OF_LINE_COMMENT == context.getTokenType()) {
            return List.of(new InjectionLocation(null, null, (PsiLanguageInjectionHost) context, TextRange.create(0, context.getTextLength())));
        }
        return Collections.emptyList();
    }

    @Override
    public @NotNull List<? extends Class<? extends PsiElement>> elementsToInjectIn() {
        return List.of(PsiComment.class);
    }
}
