// This is a generated file. Not intended for manual editing.
package com.github.cloudcompilers.klotho.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KlothoAssignmentExpr extends PsiElement {

  @Nullable
  KlothoArray getArray();

  @NotNull
  KlothoKey getKey();

  @Nullable
  PsiElement getMultilineString();

  @Nullable
  PsiElement getNumber();

  @Nullable
  PsiElement getString();

}
