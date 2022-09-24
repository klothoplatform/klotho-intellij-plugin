package com.github.cloudcompilers.klotho.language;

import com.intellij.lang.Language;

public class KlothoLanguage extends Language {

  public static final KlothoLanguage INSTANCE = new KlothoLanguage();

  private KlothoLanguage() {
    super("Klotho");
  }

}
