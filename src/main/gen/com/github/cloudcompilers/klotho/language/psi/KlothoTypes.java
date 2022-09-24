// This is a generated file. Not intended for manual editing.
package com.github.cloudcompilers.klotho.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.cloudcompilers.klotho.language.KlothoElementType;
import com.github.cloudcompilers.klotho.language.KlothoTokenType;
import com.github.cloudcompilers.klotho.language.psi.impl.*;

public interface KlothoTypes {

  IElementType ANNOTATION_BODY = new KlothoElementType("ANNOTATION_BODY");
  IElementType ANNOTATION_EXPR = new KlothoElementType("ANNOTATION_EXPR");
  IElementType ASSIGNMENT_EXPR = new KlothoElementType("ASSIGNMENT_EXPR");
  IElementType CAPABILITY = new KlothoElementType("CAPABILITY");
  IElementType C_STYLE_COMMENT_BLOCK = new KlothoElementType("C_STYLE_COMMENT_BLOCK");
  IElementType EXPR = new KlothoElementType("EXPR");
  IElementType JSDOC_COMMENT_BLOCK = new KlothoElementType("JSDOC_COMMENT_BLOCK");
  IElementType KEY = new KlothoElementType("KEY");
  IElementType STAR_PREFIX = new KlothoElementType("STAR_PREFIX");
  IElementType VALUE = new KlothoElementType("VALUE");

  IElementType ANNOTATION = new KlothoTokenType("@klotho");
  IElementType EQ = new KlothoTokenType("=");
  IElementType ID = new KlothoTokenType("ID");
  IElementType JSDOC_COMMENT_START = new KlothoTokenType("JSDOC_COMMENT_START");
  IElementType LEFT_BRACE = new KlothoTokenType("{");
  IElementType LEFT_BRACKET = new KlothoTokenType("[");
  IElementType MULTILINE_COMMENT_END = new KlothoTokenType("*/");
  IElementType MULTILINE_COMMENT_START = new KlothoTokenType("MULTILINE_COMMENT_START");
  IElementType NUMBER = new KlothoTokenType("number");
  IElementType PERIOD = new KlothoTokenType(".");
  IElementType RIGHT_BRACE = new KlothoTokenType("}");
  IElementType RIGHT_BRACKET = new KlothoTokenType("]");
  IElementType SEPARATOR = new KlothoTokenType("::");
  IElementType STAR = new KlothoTokenType("*");
  IElementType STRING = new KlothoTokenType("string");
  IElementType TOML_COMMENT = new KlothoTokenType("TOML_COMMENT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANNOTATION_BODY) {
        return new KlothoAnnotationBodyImpl(node);
      }
      else if (type == ANNOTATION_EXPR) {
        return new KlothoAnnotationExprImpl(node);
      }
      else if (type == ASSIGNMENT_EXPR) {
        return new KlothoAssignmentExprImpl(node);
      }
      else if (type == CAPABILITY) {
        return new KlothoCapabilityImpl(node);
      }
      else if (type == C_STYLE_COMMENT_BLOCK) {
        return new KlothoCStyleCommentBlockImpl(node);
      }
      else if (type == EXPR) {
        return new KlothoExprImpl(node);
      }
      else if (type == JSDOC_COMMENT_BLOCK) {
        return new KlothoJsdocCommentBlockImpl(node);
      }
      else if (type == KEY) {
        return new KlothoKeyImpl(node);
      }
      else if (type == STAR_PREFIX) {
        return new KlothoStarPrefixImpl(node);
      }
      else if (type == VALUE) {
        return new KlothoValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
