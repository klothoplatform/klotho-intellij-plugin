// This is a generated file. Not intended for manual editing.
package com.github.cloudcompilers.klotho.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.cloudcompilers.klotho.language.psi.KlothoTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.cloudcompilers.klotho.language.psi.*;

public class KlothoArrayImpl extends ASTWrapperPsiElement implements KlothoArray {

  public KlothoArrayImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KlothoVisitor visitor) {
    visitor.visitArray(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KlothoVisitor) accept((KlothoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<KlothoArray> getArrayList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KlothoArray.class);
  }

  @Override
  @NotNull
  public List<KlothoInlineTable> getInlineTableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KlothoInlineTable.class);
  }

  @Override
  @NotNull
  public List<KlothoNumber> getNumberList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KlothoNumber.class);
  }

}
