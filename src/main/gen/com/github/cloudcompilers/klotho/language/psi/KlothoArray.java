// This is a generated file. Not intended for manual editing.
package com.github.cloudcompilers.klotho.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KlothoArray extends PsiElement {

  @NotNull
  List<KlothoStarPrefix> getStarPrefixList();

  @NotNull
  List<KlothoValue> getValueList();

}
