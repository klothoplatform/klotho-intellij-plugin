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
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION_BODY, "<annotation body>");
    r = star_prefix(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    p = r; // pin = 2
    r = r && report_error_(b, annotation_content(b, l + 1));
    r = p && report_error_(b, star_prefix(b, l + 1)) && r;
    r = p && consumeToken(b, RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // '@klotho' '::' capability [ annotation_body ]
  public static boolean annotation_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_expr")) return false;
    if (!nextTokenIs(b, ANNOTATION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION_EXPR, null);
    r = consumeTokens(b, 0, ANNOTATION, SEPARATOR);
    r = r && capability(b, l + 1);
    p = r; // pin = 3
    r = r && annotation_expr_3(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [ annotation_body ]
  private static boolean annotation_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_expr_3")) return false;
    annotation_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // assignment_expr | section_header
  static boolean any_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_expr")) return false;
    if (!nextTokenIs(b, "", ID, LEFT_BRACKET)) return false;
    boolean r;
    r = assignment_expr(b, l + 1);
    if (!r) r = section_header(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // star_prefix ('@klotho' '::' capability) | '{' | statement | '}'
  static boolean anything_goes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anything_goes")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = anything_goes_0(b, l + 1);
    if (!r) r = consumeToken(b, LEFT_BRACE);
    if (!r) r = statement(b, l + 1);
    if (!r) r = consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // star_prefix ('@klotho' '::' capability)
  private static boolean anything_goes_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anything_goes_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = star_prefix(b, l + 1);
    r = r && anything_goes_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '@klotho' '::' capability
  private static boolean anything_goes_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anything_goes_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ANNOTATION, SEPARATOR);
    r = r && capability(b, l + 1);
    exit_section_(b, m, null, r);
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
    r = r && consumeToken(b, COMMA);
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
    r = !consumeToken(b, COMMA);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // key '=' value
  public static boolean assignment_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_expr")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT_EXPR, null);
    r = key(b, l + 1);
    r = r && consumeToken(b, EQ);
    p = r; // pin = 2
    r = r && value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MULTILINE_COMMENT_START (star_prefix annotation_expr) + MULTILINE_COMMENT_END
  public static boolean c_style_comment_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "c_style_comment_block")) return false;
    if (!nextTokenIs(b, MULTILINE_COMMENT_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MULTILINE_COMMENT_START);
    r = r && c_style_comment_block_1(b, l + 1);
    r = r && consumeToken(b, MULTILINE_COMMENT_END);
    exit_section_(b, m, C_STYLE_COMMENT_BLOCK, r);
    return r;
  }

  // (star_prefix annotation_expr) +
  private static boolean c_style_comment_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "c_style_comment_block_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = c_style_comment_block_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!c_style_comment_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "c_style_comment_block_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
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

  /* ********************************************************** */
  // CAPABILITY | ID
  static boolean capability(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capability")) return false;
    if (!nextTokenIs(b, "", CAPABILITY, ID)) return false;
    boolean r;
    r = consumeToken(b, CAPABILITY);
    if (!r) r = consumeToken(b, ID);
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
  // JSDOC_COMMENT_START (star_prefix annotation_expr) + MULTILINE_COMMENT_END
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

  // (star_prefix annotation_expr) +
  private static boolean jsdoc_comment_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jsdoc_comment_block_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = jsdoc_comment_block_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!jsdoc_comment_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "jsdoc_comment_block_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
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
  // ('*'  annotation_expr +) | ('//'  annotation_expr +)
  public static boolean line_comment_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_comment_block")) return false;
    if (!nextTokenIs(b, "<line comment block>", C_LINE_COMMENT, STAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LINE_COMMENT_BLOCK, "<line comment block>");
    r = line_comment_block_0(b, l + 1);
    if (!r) r = line_comment_block_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '*'  annotation_expr +
  private static boolean line_comment_block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_comment_block_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STAR);
    r = r && line_comment_block_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // annotation_expr +
  private static boolean line_comment_block_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_comment_block_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = annotation_expr(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!annotation_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "line_comment_block_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // '//'  annotation_expr +
  private static boolean line_comment_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_comment_block_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, C_LINE_COMMENT);
    r = r && line_comment_block_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // annotation_expr +
  private static boolean line_comment_block_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_comment_block_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = annotation_expr(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!annotation_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "line_comment_block_1_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (jsdoc_comment_block | c_style_comment_block | anything_goes) +
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = root_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!root_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // jsdoc_comment_block | c_style_comment_block | anything_goes
  private static boolean root_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0")) return false;
    boolean r;
    r = jsdoc_comment_block(b, l + 1);
    if (!r) r = c_style_comment_block(b, l + 1);
    if (!r) r = anything_goes(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '[' header_id ']'
  public static boolean section_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_header")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SECTION_HEADER, null);
    r = consumeToken(b, LEFT_BRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, header_id(b, l + 1));
    r = p && consumeToken(b, RIGHT_BRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // number | string | MULTILINE_STRING
  static boolean simple_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_value")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINE_STRING);
    return r;
  }

  /* ********************************************************** */
  // ('*' | '//' ) *
  static boolean star_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "star_prefix")) return false;
    while (true) {
      int c = current_position_(b);
      if (!star_prefix_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "star_prefix", c)) break;
    }
    return true;
  }

  // '*' | '//'
  private static boolean star_prefix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "star_prefix_0")) return false;
    boolean r;
    r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, C_LINE_COMMENT);
    return r;
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
  // simple_value | array
  static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    r = simple_value(b, l + 1);
    if (!r) r = array(b, l + 1);
    return r;
  }

}
