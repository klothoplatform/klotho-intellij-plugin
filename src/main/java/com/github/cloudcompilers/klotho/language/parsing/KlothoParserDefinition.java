package com.github.cloudcompilers.klotho.language.parsing;

import com.github.cloudcompilers.klotho.language.KlothoFile;
import com.github.cloudcompilers.klotho.language.KlothoLanguage;
import com.github.cloudcompilers.klotho.language.psi.KlothoParser;
import com.github.cloudcompilers.klotho.language.psi.KlothoTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class KlothoParserDefinition implements ParserDefinition {

  public static final IFileElementType FILE = new IFileElementType(KlothoLanguage.INSTANCE);

  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    return new KlothoLexerAdapter();
  }

  @NotNull
  @Override
  public TokenSet getCommentTokens() {
    return KlothoTokenSets.COMMENTS;
  }

  @NotNull
  @Override
  public TokenSet getStringLiteralElements() {
    return TokenSet.create(KlothoTypes.STRING);
  }

    @Override
    public @NotNull TokenSet getWhitespaceTokens() {
        return KlothoTokenSets.WHITE_SPACE;
    }

    @NotNull
  @Override
  public PsiParser createParser(final Project project) {
    return new KlothoParser();
  }

  @NotNull
  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  @NotNull
  @Override
  public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
    return new KlothoFile(viewProvider);
  }

  @NotNull
  @Override
  public PsiElement createElement(ASTNode node) {
    return KlothoTypes.Factory.createElement(node);
  }

}
