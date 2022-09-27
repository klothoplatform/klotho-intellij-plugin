package com.github.cloudcompilers.klotho.language.parsing;

import com.github.cloudcompilers.klotho.language.KlothoLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class KlothoElementType extends IElementType {

  public KlothoElementType(@NotNull @NonNls String debugName) {
    super(debugName, KlothoLanguage.INSTANCE);
  }

}
