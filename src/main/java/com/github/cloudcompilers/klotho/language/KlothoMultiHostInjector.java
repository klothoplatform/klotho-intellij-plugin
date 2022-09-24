package com.github.cloudcompilers.klotho.language;

import com.intellij.lang.injection.MultiHostInjector;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.lang.javascript.psi.jsdoc.JSDocComment;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.tree.PsiCommentImpl;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public final class KlothoMultiHostInjector implements MultiHostInjector {


    @Override
    public void getLanguagesToInject(@NotNull MultiHostRegistrar registrar,
                                     @NotNull PsiElement context) {

        if (context instanceof PsiComment) {
            registrar.startInjecting(KlothoLanguage.INSTANCE);
            registrar.addPlace(null, null, (PsiLanguageInjectionHost) context, TextRange.create(0, context.getTextLength()));
            registrar.doneInjecting();
        }
    }


    @Override
    public @NotNull List<? extends Class<? extends PsiElement>> elementsToInjectIn() {
        return List.of(JSDocComment.class, PsiComment.class);
    }

    private List<PsiElement> findComments(PsiElement element) {
        PsiFile file = element.getContainingFile();
        return Arrays.stream(file.getChildren()).filter(e -> e instanceof JSDocComment).collect(Collectors.toList());
    }
}
