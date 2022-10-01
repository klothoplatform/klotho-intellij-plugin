package com.github.cloudcompilers.klotho.language.injection;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiLanguageInjectionHost;

class InjectionLocation {
    String prefix;
    String suffix;
    PsiLanguageInjectionHost host;
    TextRange range;

    public InjectionLocation(String prefix, String suffix, PsiLanguageInjectionHost host, TextRange range) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.host = host;
        this.range = range;
    }
}
