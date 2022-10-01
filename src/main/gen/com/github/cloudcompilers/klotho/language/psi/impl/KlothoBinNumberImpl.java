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

public class KlothoBinNumberImpl extends ASTWrapperPsiElement implements KlothoBinNumber {

  public KlothoBinNumberImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KlothoVisitor visitor) {
    visitor.visitBinNumber(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KlothoVisitor) accept((KlothoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getDig01() {
    return findChildByType(DIG0_1);
  }

}
