package com.github.cloudcompilers.klotho.language;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class KlothoElementType extends IElementType {

  public KlothoElementType(@NotNull @NonNls String debugName) {
    super(debugName, KlothoLanguage.INSTANCE);
  }

}
