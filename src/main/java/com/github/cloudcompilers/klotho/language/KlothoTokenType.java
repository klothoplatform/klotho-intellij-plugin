package com.github.cloudcompilers.klotho.language;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class KlothoTokenType extends IElementType {

  public KlothoTokenType(@NotNull @NonNls String debugName) {
    super(debugName, KlothoLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return super.toString();
  }

}
