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

public class KlothoInlineTableImpl extends ASTWrapperPsiElement implements KlothoInlineTable {

  public KlothoInlineTableImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KlothoVisitor visitor) {
    visitor.visitInlineTable(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KlothoVisitor) accept((KlothoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<KlothoAssignmentExpr> getAssignmentExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KlothoAssignmentExpr.class);
  }

}
