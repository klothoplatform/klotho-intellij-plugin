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
  // star_prefix '{' annotation_content star_prefix '}'
  public static boolean annotation_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_body")) return false;
    if (!nextTokenIs(b, "<annotation body>", LEFT_BRACE, STAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION_BODY, "<annotation body>");
    r = star_prefix(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && annotation_content(b, l + 1);
    r = r && star_prefix(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [statement *]
  public static boolean annotation_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_content")) return false;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION_CONTENT, "<annotation content>");
    annotation_content_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // statement *
  private static boolean annotation_content_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_content_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "annotation_content_0", c)) break;
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
  // assignment_expr | section_header | array
  static boolean any_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_expr")) return false;
    if (!nextTokenIs(b, "", ID, LEFT_BRACKET)) return false;
    boolean r;
    r = assignment_expr(b, l + 1);
    if (!r) r = section_header(b, l + 1);
    if (!r) r = array(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '[' ([(value ( [star_prefix] ',' [star_prefix] )) * [star_prefix] [value] !','] )  ']'
  public static boolean array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && array_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, ARRAY, r);
    return r;
  }

  // [(value ( [star_prefix] ',' [star_prefix] )) * [star_prefix] [value] !',']
  private static boolean array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1")) return false;
    array_1_0(b, l + 1);
    return true;
  }

  // (value ( [star_prefix] ',' [star_prefix] )) * [star_prefix] [value] !','
  private static boolean array_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_1_0_0(b, l + 1);
    r = r && array_1_0_1(b, l + 1);
    r = r && array_1_0_2(b, l + 1);
    r = r && array_1_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (value ( [star_prefix] ',' [star_prefix] )) *
  private static boolean array_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_1_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_1_0_0", c)) break;
    }
    return true;
  }

  // value ( [star_prefix] ',' [star_prefix] )
  private static boolean array_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value(b, l + 1);
    r = r && array_1_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [star_prefix] ',' [star_prefix]
  private static boolean array_1_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_1_0_0_0_1_0(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && array_1_0_0_0_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [star_prefix]
  private static boolean array_1_0_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_0_0_1_0")) return false;
    star_prefix(b, l + 1);
    return true;
  }

  // [star_prefix]
  private static boolean array_1_0_0_0_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_0_0_1_2")) return false;
    star_prefix(b, l + 1);
    return true;
  }

  // [star_prefix]
  private static boolean array_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_1")) return false;
    star_prefix(b, l + 1);
    return true;
  }

  // [value]
  private static boolean array_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_2")) return false;
    value(b, l + 1);
    return true;
  }

  // !','
  private static boolean array_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, ",");
    exit_section_(b, l, m, r, false, null);
    return r;
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
  // ID
  public static boolean header_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header_id")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, HEADER_ID, r);
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
  // '[' header_id ']'
  public static boolean section_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_header")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && header_id(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, SECTION_HEADER, r);
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
  // star_prefix (((assignment_expr | section_header) TOML_COMMENT) | TOML_COMMENT | any_expr)
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = star_prefix(b, l + 1);
    r = r && statement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((assignment_expr | section_header) TOML_COMMENT) | TOML_COMMENT | any_expr
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_1_0(b, l + 1);
    if (!r) r = consumeToken(b, TOML_COMMENT);
    if (!r) r = any_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (assignment_expr | section_header) TOML_COMMENT
  private static boolean statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_1_0_0(b, l + 1);
    r = r && consumeToken(b, TOML_COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // assignment_expr | section_header
  private static boolean statement_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1_0_0")) return false;
    boolean r;
    r = assignment_expr(b, l + 1);
    if (!r) r = section_header(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // string | number | MULTILINE_STRING
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, MULTILINE_STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
