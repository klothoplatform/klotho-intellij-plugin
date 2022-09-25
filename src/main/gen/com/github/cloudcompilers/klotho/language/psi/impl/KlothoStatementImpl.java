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

public class KlothoStatementImpl extends ASTWrapperPsiElement implements KlothoStatement {

  public KlothoStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KlothoVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KlothoVisitor) accept((KlothoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KlothoAssignmentExpr getAssignmentExpr() {
    return findChildByClass(KlothoAssignmentExpr.class);
  }

  @Override
  @Nullable
  public KlothoSectionHeader getSectionHeader() {
    return findChildByClass(KlothoSectionHeader.class);
  }

  @Override
  @Nullable
  public PsiElement getTomlComment() {
    return findChildByType(TOML_COMMENT);
  }

}
