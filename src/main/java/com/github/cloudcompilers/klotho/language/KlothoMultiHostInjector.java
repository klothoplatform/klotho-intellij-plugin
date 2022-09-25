package com.github.cloudcompilers.klotho.language;

import com.intellij.lang.injection.MultiHostInjector;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.lang.javascript.JSTokenTypes;
import com.intellij.lang.javascript.psi.jsdoc.JSDocComment;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public final class KlothoMultiHostInjector implements MultiHostInjector {

    private static final TokenSet singleLineTypes = TokenSet.create(
            JSTokenTypes.END_OF_LINE_COMMENT,
            JavaTokenType.END_OF_LINE_COMMENT
    );
    @Override
    public void getLanguagesToInject(@NotNull MultiHostRegistrar registrar,
                                     @NotNull PsiElement context) {

        if (!(context instanceof PsiComment)) {
            return;
        }

        if (singleLineTypes.contains(((PsiComment) context).getTokenType()) && shouldInjectSingle((PsiComment) context)) {
            registrar.startInjecting(KlothoLanguage.INSTANCE);
            registrar.addPlace(null, null, (PsiLanguageInjectionHost) context, TextRange.create(findStartOffset(context), context.getTextLength()));
            registrar.doneInjecting();
        }

        if (context instanceof JSDocComment
                || JSTokenTypes.C_STYLE_COMMENT.equals(((PsiComment) context).getTokenType())) {
            if (context.getText().contains("@klotho::")) {
                registrar.startInjecting(KlothoLanguage.INSTANCE);
                registrar.addPlace(null, null, (PsiLanguageInjectionHost) context, TextRange.create(findStartOffset(context), context.getTextLength()));
                registrar.doneInjecting();
            }
        }
    }

    private boolean shouldInjectSingle(PsiComment context) {
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

    private PsiElement prevUnbrokenNonWhitespaceSibling(PsiElement context) {
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

    private List<PsiElement> findComments(PsiElement element) {
        PsiFile file = element.getContainingFile();
        return Arrays.stream(file.getChildren()).filter(e -> e instanceof JSDocComment).collect(Collectors.toList());
    }

    private static boolean isClassPresent(String name) {
        try {
            return Class.forName(name) != null;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

}
