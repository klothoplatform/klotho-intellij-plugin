package com.github.cloudcompilers.klotho.language.injection;

import com.intellij.lang.Language;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.lang.injection.general.Injection;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.jetbrains.python.PyTokenTypes;
import com.jetbrains.python.PythonLanguage;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class PyInjectionPerformer extends LineCommentInjectionPerformerBase {
    @Override
    public boolean isPrimary() {
        return true;
    }

    @Override
    protected Language getLanguage() {
        return PythonLanguage.INSTANCE;
    }

    @Override
    protected IElementType getLineCommentType() {
        return PyTokenTypes.END_OF_LINE_COMMENT;
    }

    @Override
    protected List<InjectionLocation> performMultilineInjection(@NotNull MultiHostRegistrar registrar, @NotNull Injection injection, @NotNull PsiElement context) {
        return Collections.emptyList();
    }
}
