package com.github.cloudcompilers.klotho.language.parsing;

import com.github.cloudcompilers.klotho.language.KlothoIcons;
import com.github.cloudcompilers.klotho.language.KlothoLanguage;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class KlothoFileType extends LanguageFileType {

  public static final KlothoFileType INSTANCE = new KlothoFileType();

  private KlothoFileType() {
    super(KlothoLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "Klotho File";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "Klotho language file";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "klotho";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return KlothoIcons.FILE;
  }

}
