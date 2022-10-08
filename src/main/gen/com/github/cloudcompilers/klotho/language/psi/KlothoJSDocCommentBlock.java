// This is a generated file. Not intended for manual editing.
package com.github.cloudcompilers.klotho.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KlothoJSDocCommentBlock extends PsiElement {

  @NotNull
  List<KlothoAnnotationExpr> getAnnotationExprList();

  @NotNull
  List<KlothoRawComment> getRawCommentList();

  @NotNull
  PsiElement getJsdocCommentStart();

}
