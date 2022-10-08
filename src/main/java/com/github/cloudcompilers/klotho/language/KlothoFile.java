package com.github.cloudcompilers.klotho.language;

import com.github.cloudcompilers.klotho.language.parsing.KlothoFileType;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class KlothoFile extends PsiFileBase {

    public KlothoFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, KlothoLanguage.INSTANCE);
    }

    @NotNull @Override
    public FileType getFileType() {
        return KlothoFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Klotho File";
    }
}
