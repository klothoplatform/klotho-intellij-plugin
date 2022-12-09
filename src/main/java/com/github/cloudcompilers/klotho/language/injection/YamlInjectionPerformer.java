package com.github.cloudcompilers.klotho.language.injection;

import com.intellij.lang.Language;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.lang.injection.general.Injection;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.yaml.YAMLLanguage;
import org.jetbrains.yaml.YAMLTokenTypes;

public class YamlInjectionPerformer extends YamljectionPerformerBase {
    @Override
    public boolean isPrimary() {
        return true;
    }

    @Override
    protected Language getLanguage() {
        return YAMLLanguage.INSTANCE;
    }

    @Override
    protected IElementType getLineCommentType() {
        return YAMLTokenTypes.COMMENT;
    }

    @Override
    protected List<InjectionLocation> performMultilineInjection(
            @NotNull MultiHostRegistrar registrar,
            @NotNull Injection injection,
            @NotNull PsiElement context) {
        return Collections.emptyList();
    }
}
