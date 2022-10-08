package com.github.cloudcompilers.klotho.language.injection;

import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiLanguageInjectionHost;

/**
 * Captures details of an injection location to be added to a {@link MultiHostRegistrar} at some
 * point in the future.
 */
class InjectionLocation {
    String prefix;
    String suffix;
    PsiLanguageInjectionHost host;
    TextRange range;

    InjectionLocation(
            String prefix, String suffix, PsiLanguageInjectionHost host, TextRange range) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.host = host;
        this.range = range;
    }
}
