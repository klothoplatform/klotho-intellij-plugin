// This is a generated file. Not intended for manual editing.
package com.github.cloudcompilers.klotho.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.cloudcompilers.klotho.language.parsing.KlothoElementType;
import com.github.cloudcompilers.klotho.language.parsing.KlothoTokenType;
import com.github.cloudcompilers.klotho.language.psi.impl.*;

public interface KlothoTypes {

  IElementType ANNOTATION_BODY = new KlothoElementType("ANNOTATION_BODY");
  IElementType ANNOTATION_CONTENT = new KlothoElementType("ANNOTATION_CONTENT");
  IElementType ANNOTATION_EXPR = new KlothoElementType("ANNOTATION_EXPR");
  IElementType ARRAY = new KlothoElementType("ARRAY");
  IElementType ASSIGNMENT_EXPR = new KlothoElementType("ASSIGNMENT_EXPR");
  IElementType BIN_NUMBER = new KlothoElementType("BIN_NUMBER");
  IElementType C_STYLE_COMMENT_BLOCK = new KlothoElementType("C_STYLE_COMMENT_BLOCK");
  IElementType HEADER_ID = new KlothoElementType("HEADER_ID");
  IElementType HEX_NUMBER = new KlothoElementType("HEX_NUMBER");
  IElementType INLINE_TABLE = new KlothoElementType("INLINE_TABLE");
  IElementType JSDOC_COMMENT_BLOCK = new KlothoElementType("JSDOC_COMMENT_BLOCK");
  IElementType KEY = new KlothoElementType("KEY");
  IElementType NUMBER = new KlothoElementType("NUMBER");
  IElementType OCT_NUMBER = new KlothoElementType("OCT_NUMBER");
  IElementType PLAIN_NUMBER = new KlothoElementType("PLAIN_NUMBER");
  IElementType SECTION_HEADER = new KlothoElementType("SECTION_HEADER");
  IElementType STATEMENT = new KlothoElementType("STATEMENT");

  IElementType ADD = new KlothoTokenType("+");
  IElementType ANNOTATION = new KlothoTokenType("@klotho");
  IElementType BIN_PREFIX = new KlothoTokenType("0b");
  IElementType BOOLEAN = new KlothoTokenType("BOOLEAN");
  IElementType CAPABILITY = new KlothoTokenType("CAPABILITY");
  IElementType COMMA = new KlothoTokenType(",");
  IElementType C_LINE_COMMENT = new KlothoTokenType("//");
  IElementType DIG0_1 = new KlothoTokenType("DIG0_1");
  IElementType DIG0_7 = new KlothoTokenType("DIG0_7");
  IElementType DIGIT = new KlothoTokenType("DIGIT");
  IElementType EQ = new KlothoTokenType("=");
  IElementType HEX_DIG = new KlothoTokenType("HEX_DIG");
  IElementType HEX_PREFIX = new KlothoTokenType("0x");
  IElementType ID = new KlothoTokenType("ID");
  IElementType JSDOC_COMMENT_START = new KlothoTokenType("JSDOC_COMMENT_START");
  IElementType LEFT_BRACE = new KlothoTokenType("{");
  IElementType LEFT_BRACKET = new KlothoTokenType("[");
  IElementType MULTILINE_COMMENT_END = new KlothoTokenType("*/");
  IElementType MULTILINE_COMMENT_START = new KlothoTokenType("/*");
  IElementType MULTILINE_STRING = new KlothoTokenType("MULTILINE_STRING");
  IElementType OCT_PREFIX = new KlothoTokenType("0o");
  IElementType PERIOD = new KlothoTokenType(".");
  IElementType PY_COMMENT = new KlothoTokenType("#");
  IElementType RIGHT_BRACE = new KlothoTokenType("}");
  IElementType RIGHT_BRACKET = new KlothoTokenType("]");
  IElementType SEPARATOR = new KlothoTokenType("::");
  IElementType STAR = new KlothoTokenType("*");
  IElementType STRING = new KlothoTokenType("string");
  IElementType SUB = new KlothoTokenType("-");
  IElementType TOML_COMMENT = new KlothoTokenType("TOML_COMMENT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANNOTATION_BODY) {
        return new KlothoAnnotationBodyImpl(node);
      }
      else if (type == ANNOTATION_CONTENT) {
        return new KlothoAnnotationContentImpl(node);
      }
      else if (type == ANNOTATION_EXPR) {
        return new KlothoAnnotationExprImpl(node);
      }
      else if (type == ARRAY) {
        return new KlothoArrayImpl(node);
      }
      else if (type == ASSIGNMENT_EXPR) {
        return new KlothoAssignmentExprImpl(node);
      }
      else if (type == BIN_NUMBER) {
        return new KlothoBinNumberImpl(node);
      }
      else if (type == C_STYLE_COMMENT_BLOCK) {
        return new KlothoCStyleCommentBlockImpl(node);
      }
      else if (type == HEADER_ID) {
        return new KlothoHeaderIdImpl(node);
      }
      else if (type == HEX_NUMBER) {
        return new KlothoHexNumberImpl(node);
      }
      else if (type == INLINE_TABLE) {
        return new KlothoInlineTableImpl(node);
      }
      else if (type == JSDOC_COMMENT_BLOCK) {
        return new KlothoJsdocCommentBlockImpl(node);
      }
      else if (type == KEY) {
        return new KlothoKeyImpl(node);
      }
      else if (type == NUMBER) {
        return new KlothoNumberImpl(node);
      }
      else if (type == OCT_NUMBER) {
        return new KlothoOctNumberImpl(node);
      }
      else if (type == PLAIN_NUMBER) {
        return new KlothoPlainNumberImpl(node);
      }
      else if (type == SECTION_HEADER) {
        return new KlothoSectionHeaderImpl(node);
      }
      else if (type == STATEMENT) {
        return new KlothoStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
