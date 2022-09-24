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

public class KlothoCStyleCommentBlockImpl extends ASTWrapperPsiElement implements KlothoCStyleCommentBlock {

  public KlothoCStyleCommentBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KlothoVisitor visitor) {
    visitor.visitCStyleCommentBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KlothoVisitor) accept((KlothoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<KlothoAnnotationExpr> getAnnotationExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KlothoAnnotationExpr.class);
  }

  @Override
  @NotNull
  public List<KlothoStarPrefix> getStarPrefixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KlothoStarPrefix.class);
  }

  @Override
  @Nullable
  public PsiElement getMultilineCommentStart() {
    return findChildByType(MULTILINE_COMMENT_START);
  }

}
