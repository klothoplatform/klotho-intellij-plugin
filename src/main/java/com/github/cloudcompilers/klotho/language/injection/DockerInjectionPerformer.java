package com.github.cloudcompilers.klotho.language.injection;

import com.intellij.docker.dockerFile.DockerLanguage;
import com.intellij.docker.dockerFile.lexer.DockerTokenTypeSets;
import com.intellij.lang.Language;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.lang.injection.general.Injection;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class DockerInjectionPerformer extends LineCommentInjectionPerformerBase {
    @Override
    public boolean isPrimary() {
        return true;
    }

    @Override
    protected Language getLanguage() {
        return DockerLanguage.INSTANCE;
    }

    @Override
    protected IElementType getLineCommentType() {
        return DockerTokenTypeSets.SINGLE_LINE_COMMENT;
    }

    @Override
    protected List<InjectionLocation> performMultilineInjection(
            @NotNull MultiHostRegistrar registrar,
            @NotNull Injection injection,
            @NotNull PsiElement context) {
        return Collections.emptyList();
    }
}
