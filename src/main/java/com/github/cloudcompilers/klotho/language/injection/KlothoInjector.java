package com.github.cloudcompilers.klotho.language.injection;

import com.github.cloudcompilers.klotho.language.KlothoLanguage;
import com.intellij.lang.injection.general.Injection;
import com.intellij.lang.injection.general.LanguageInjectionContributor;
import com.intellij.lang.injection.general.SimpleInjection;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KlothoInjector implements LanguageInjectionContributor {

@Override
public @Nullable Injection getInjection(@NotNull PsiElement context) {
    if (shouldInjectKlotho(context)) {
        return new SimpleInjection(
                KlothoLanguage.INSTANCE, "hello", "there", null
        );
    }
    return null;
}

    private boolean shouldInjectKlotho(PsiElement context) {
        return context instanceof PsiComment && context.getText().contains("@klotho");
    }
}
