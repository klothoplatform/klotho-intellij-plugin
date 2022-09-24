// This is a generated file. Not intended for manual editing.
package com.github.cloudcompilers.klotho.language.psi;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.cloudcompilers.klotho.language.psi.KlothoTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class KlothoParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // star_prefix '{' [expr *] star_prefix '}'
  public static boolean annotation_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_body")) return false;
    if (!nextTokenIs(b, "<annotation body>", LEFT_BRACE, STAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION_BODY, "<annotation body>");
    r = star_prefix(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && annotation_body_2(b, l + 1);
    r = r && star_prefix(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [expr *]
  private static boolean annotation_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_body_2")) return false;
    annotation_body_2_0(b, l + 1);
    return true;
  }

  // expr *
  private static boolean annotation_body_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_body_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "annotation_body_2_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ANNOTATION '::' capability [ annotation_body ]
  public static boolean annotation_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_expr")) return false;
    if (!nextTokenIs(b, ANNOTATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ANNOTATION, SEPARATOR);
    r = r && capability(b, l + 1);
    r = r && annotation_expr_3(b, l + 1);
    exit_section_(b, m, ANNOTATION_EXPR, r);
    return r;
  }

  // [ annotation_body ]
  private static boolean annotation_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_expr_3")) return false;
    annotation_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // key '=' value
  public static boolean assignment_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_expr")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && value(b, l + 1);
    exit_section_(b, m, ASSIGNMENT_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // [MULTILINE_COMMENT_START] (star_prefix annotation_expr) * [MULTILINE_COMMENT_END]
  public static boolean c_style_comment_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "c_style_comment_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, C_STYLE_COMMENT_BLOCK, "<c style comment block>");
    r = c_style_comment_block_0(b, l + 1);
    r = r && c_style_comment_block_1(b, l + 1);
    r = r && c_style_comment_block_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [MULTILINE_COMMENT_START]
  private static boolean c_style_comment_block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "c_style_comment_block_0")) return false;
    consumeToken(b, MULTILINE_COMMENT_START);
    return true;
  }

  // (star_prefix annotation_expr) *
  private static boolean c_style_comment_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "c_style_comment_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!c_style_comment_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "c_style_comment_block_1", c)) break;
    }
    return true;
  }

  // star_prefix annotation_expr
  private static boolean c_style_comment_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "c_style_comment_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = star_prefix(b, l + 1);
    r = r && annotation_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [MULTILINE_COMMENT_END]
  private static boolean c_style_comment_block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "c_style_comment_block_2")) return false;
    consumeToken(b, MULTILINE_COMMENT_END);
    return true;
  }

  /* ********************************************************** */
  // ID
  public static boolean capability(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capability")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, CAPABILITY, r);
    return r;
  }

  /* ********************************************************** */
  // star_prefix ((assignment_expr TOML_COMMENT) | TOML_COMMENT | assignment_expr)
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = star_prefix(b, l + 1);
    r = r && expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (assignment_expr TOML_COMMENT) | TOML_COMMENT | assignment_expr
  private static boolean expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr_1_0(b, l + 1);
    if (!r) r = consumeToken(b, TOML_COMMENT);
    if (!r) r = assignment_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // assignment_expr TOML_COMMENT
  private static boolean expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignment_expr(b, l + 1);
    r = r && consumeToken(b, TOML_COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // JSDOC_COMMENT_START (star_prefix annotation_expr) * MULTILINE_COMMENT_END
  public static boolean jsdoc_comment_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jsdoc_comment_block")) return false;
    if (!nextTokenIs(b, JSDOC_COMMENT_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, JSDOC_COMMENT_START);
    r = r && jsdoc_comment_block_1(b, l + 1);
    r = r && consumeToken(b, MULTILINE_COMMENT_END);
    exit_section_(b, m, JSDOC_COMMENT_BLOCK, r);
    return r;
  }

  // (star_prefix annotation_expr) *
  private static boolean jsdoc_comment_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jsdoc_comment_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!jsdoc_comment_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "jsdoc_comment_block_1", c)) break;
    }
    return true;
  }

  // star_prefix annotation_expr
  private static boolean jsdoc_comment_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jsdoc_comment_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = star_prefix(b, l + 1);
    r = r && annotation_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, KEY, r);
    return r;
  }

  /* ********************************************************** */
  // jsdoc_comment_block | c_style_comment_block
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    boolean r;
    r = jsdoc_comment_block(b, l + 1);
    if (!r) r = c_style_comment_block(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ['*' *]
  public static boolean star_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "star_prefix")) return false;
    Marker m = enter_section_(b, l, _NONE_, STAR_PREFIX, "<star prefix>");
    star_prefix_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // '*' *
  private static boolean star_prefix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "star_prefix_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, STAR)) break;
      if (!empty_element_parsed_guard_(b, "star_prefix_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // string | number
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    if (!nextTokenIs(b, "<value>", NUMBER, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
