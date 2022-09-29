package com.github.cloudcompilers.klotho.language.injection;

import com.github.cloudcompilers.klotho.language.KlothoLanguage;
import com.intellij.lang.injection.MultiHostInjector;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.lang.javascript.JSTokenTypes;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class KlothoMultiHostInjectorBase implements MultiHostInjector {

    @Override
    public void getLanguagesToInject(@NotNull MultiHostRegistrar registrar,
                                     @NotNull PsiElement context) {

        if (!(context instanceof PsiComment)) {
            return;
        }

        List<InjectionLocation> locations = getLocationsToInject((PsiComment) context);
        if (locations.isEmpty()) {
            return;
        }
        registrar.startInjecting(KlothoLanguage.INSTANCE);
        locations.forEach((l) -> registrar.addPlace(l.prefix, l.suffix, l.host, l.range));
        registrar.doneInjecting();
    }

    protected abstract List<InjectionLocation> getLocationsToInject(@NotNull PsiComment context);

    protected boolean shouldInjectSingle(PsiComment context) {
        if (context.getText().contains("@klotho::")) {
            return true;
        }

        PsiElement prevSibling = prevUnbrokenNonWhitespaceSibling(context);
        while (prevSibling instanceof PsiComment && context.getTokenType().equals(((PsiComment) prevSibling).getTokenType())) {
            if(prevSibling.getText().contains("@klotho::")) {
                return true;
            } else {
                prevSibling = prevUnbrokenNonWhitespaceSibling(prevSibling);
            }
        }
        return false;
    }

    protected PsiElement prevUnbrokenNonWhitespaceSibling(PsiElement context) {
        PsiElement prev = context.getPrevSibling();
        int newLineCount = 0;
        while (prev instanceof PsiWhiteSpace) {
            if (prev.getText().contains("\n")) {
                newLineCount += prev.getText().chars().filter(ch -> ch == '\n').count(); // give up if there's an empty line between context and the next non-empty line
            }
            if (newLineCount > 1) {
                return prev;
            }
            prev = prev.getPrevSibling();
        }
        return prev;
    }

    Pattern pyComment = Pattern.compile("(^\\s*#)");

    private int findStartOffset(PsiElement context) {
        String text = context.getText();
        Matcher matcher = pyComment.matcher(text);
        return matcher.find() ? matcher.group(0).length() : 0;
    }

    @Override
    public @NotNull List<? extends Class<? extends PsiElement>> elementsToInjectIn() {
        return List.of(PsiComment.class);
    }

    protected static class InjectionLocation {
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
}
