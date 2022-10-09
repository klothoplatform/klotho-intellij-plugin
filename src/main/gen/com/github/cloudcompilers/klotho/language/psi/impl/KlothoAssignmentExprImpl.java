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

public class KlothoAssignmentExprImpl extends ASTWrapperPsiElement implements KlothoAssignmentExpr {

  public KlothoAssignmentExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KlothoVisitor visitor) {
    visitor.visitAssignmentExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KlothoVisitor) accept((KlothoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KlothoArray getArray() {
    return findChildByClass(KlothoArray.class);
  }

  @Override
  @Nullable
  public KlothoInlineTable getInlineTable() {
    return findChildByClass(KlothoInlineTable.class);
  }

  @Override
  @NotNull
  public KlothoKey getKey() {
    return findNotNullChildByClass(KlothoKey.class);
  }

  @Override
  @Nullable
  public KlothoMultilineString getMultilineString() {
    return findChildByClass(KlothoMultilineString.class);
  }

  @Override
  @Nullable
  public KlothoNumber getNumber() {
    return findChildByClass(KlothoNumber.class);
  }

  @Override
  @Nullable
  public PsiElement getBoolean() {
    return findChildByType(BOOLEAN);
  }

  @Override
  @Nullable
  public PsiElement getLocalDate() {
    return findChildByType(LOCAL_DATE);
  }

  @Override
  @Nullable
  public PsiElement getLocalDateTime() {
    return findChildByType(LOCAL_DATE_TIME);
  }

  @Override
  @Nullable
  public PsiElement getLocalTime() {
    return findChildByType(LOCAL_TIME);
  }

  @Override
  @Nullable
  public PsiElement getOffsetDateTime() {
    return findChildByType(OFFSET_DATE_TIME);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

}
