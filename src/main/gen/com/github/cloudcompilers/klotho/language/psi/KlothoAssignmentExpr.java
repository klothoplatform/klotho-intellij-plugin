// This is a generated file. Not intended for manual editing.
package com.github.cloudcompilers.klotho.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KlothoAssignmentExpr extends PsiElement {

  @Nullable
  KlothoArray getArray();

  @Nullable
  KlothoInlineTable getInlineTable();

  @NotNull
  KlothoKey getKey();

  @Nullable
  KlothoMultilineString getMultilineString();

  @Nullable
  KlothoNumber getNumber();

  @Nullable
  PsiElement getBoolean();

  @Nullable
  PsiElement getString();

}
