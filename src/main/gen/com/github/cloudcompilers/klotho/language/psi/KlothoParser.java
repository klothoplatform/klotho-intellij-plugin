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

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return root(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // ['-' | '+'] digit + ['.' digit *]
  public static boolean Number(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Number")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NUMBER, "<number>");
    result_ = Number_0(builder_, level_ + 1);
    result_ = result_ && Number_1(builder_, level_ + 1);
    pinned_ = result_; // pin = 2
    result_ = result_ && Number_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ['-' | '+']
  private static boolean Number_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Number_0")) return false;
    Number_0_0(builder_, level_ + 1);
    return true;
  }

  // '-' | '+'
  private static boolean Number_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Number_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SUB);
    if (!result_) result_ = consumeToken(builder_, ADD);
    return result_;
  }

  // digit +
  private static boolean Number_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Number_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DIGIT);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, DIGIT)) break;
      if (!empty_element_parsed_guard_(builder_, "Number_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ['.' digit *]
  private static boolean Number_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Number_2")) return false;
    Number_2_0(builder_, level_ + 1);
    return true;
  }

  // '.' digit *
  private static boolean Number_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Number_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, PERIOD);
    result_ = result_ && Number_2_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // digit *
  private static boolean Number_2_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Number_2_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, DIGIT)) break;
      if (!empty_element_parsed_guard_(builder_, "Number_2_0_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // star_prefix '{' annotation_content star_prefix '}'
  public static boolean annotation_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_body")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ANNOTATION_BODY, "<annotation body>");
    result_ = star_prefix(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LEFT_BRACE);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, annotation_content(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, star_prefix(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RIGHT_BRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // [statement *]
  public static boolean annotation_content(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_content")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ANNOTATION_CONTENT, "<annotation content>");
    annotation_content_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // statement *
  private static boolean annotation_content_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_content_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!statement(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "annotation_content_0", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '@klotho' '::' capability [ annotation_body ]
  public static boolean annotation_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_expr")) return false;
    if (!nextTokenIs(builder_, ANNOTATION)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ANNOTATION_EXPR, null);
    result_ = consumeTokens(builder_, 0, ANNOTATION, SEPARATOR);
    result_ = result_ && capability(builder_, level_ + 1);
    pinned_ = result_; // pin = 3
    result_ = result_ && annotation_expr_3(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // [ annotation_body ]
  private static boolean annotation_expr_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_expr_3")) return false;
    annotation_body(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // assignment_expr | section_header
  static boolean any_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "any_expr")) return false;
    if (!nextTokenIs(builder_, "", ID, LEFT_BRACKET)) return false;
    boolean result_;
    result_ = assignment_expr(builder_, level_ + 1);
    if (!result_) result_ = section_header(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // '[' ([(value ( [star_prefix] ',' [star_prefix] )) * [star_prefix] [value] !','] )  ']'
  public static boolean array(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array")) return false;
    if (!nextTokenIs(builder_, LEFT_BRACKET)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ARRAY, null);
    result_ = consumeToken(builder_, LEFT_BRACKET);
    result_ = result_ && array_1(builder_, level_ + 1);
    pinned_ = result_; // pin = 2
    result_ = result_ && consumeToken(builder_, RIGHT_BRACKET);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // [(value ( [star_prefix] ',' [star_prefix] )) * [star_prefix] [value] !',']
  private static boolean array_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_1")) return false;
    array_1_0(builder_, level_ + 1);
    return true;
  }

  // (value ( [star_prefix] ',' [star_prefix] )) * [star_prefix] [value] !','
  private static boolean array_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = array_1_0_0(builder_, level_ + 1);
    result_ = result_ && array_1_0_1(builder_, level_ + 1);
    result_ = result_ && array_1_0_2(builder_, level_ + 1);
    result_ = result_ && array_1_0_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (value ( [star_prefix] ',' [star_prefix] )) *
  private static boolean array_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_1_0_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!array_1_0_0_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "array_1_0_0", pos_)) break;
    }
    return true;
  }

  // value ( [star_prefix] ',' [star_prefix] )
  private static boolean array_1_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_1_0_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = value(builder_, level_ + 1);
    result_ = result_ && array_1_0_0_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // [star_prefix] ',' [star_prefix]
  private static boolean array_1_0_0_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_1_0_0_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = array_1_0_0_0_1_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COMMA);
    result_ = result_ && array_1_0_0_0_1_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // [star_prefix]
  private static boolean array_1_0_0_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_1_0_0_0_1_0")) return false;
    star_prefix(builder_, level_ + 1);
    return true;
  }

  // [star_prefix]
  private static boolean array_1_0_0_0_1_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_1_0_0_0_1_2")) return false;
    star_prefix(builder_, level_ + 1);
    return true;
  }

  // [star_prefix]
  private static boolean array_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_1_0_1")) return false;
    star_prefix(builder_, level_ + 1);
    return true;
  }

  // [value]
  private static boolean array_1_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_1_0_2")) return false;
    value(builder_, level_ + 1);
    return true;
  }

  // !','
  private static boolean array_1_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_1_0_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !consumeToken(builder_, COMMA);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // key '=' value
  public static boolean assignment_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assignment_expr")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ASSIGNMENT_EXPR, null);
    result_ = key(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, EQ);
    pinned_ = result_; // pin = 2
    result_ = result_ && value(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // MULTILINE_COMMENT_START (star_prefix annotation_expr) + MULTILINE_COMMENT_END
  public static boolean c_style_comment_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "c_style_comment_block")) return false;
    if (!nextTokenIs(builder_, MULTILINE_COMMENT_START)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, MULTILINE_COMMENT_START);
    result_ = result_ && c_style_comment_block_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, MULTILINE_COMMENT_END);
    exit_section_(builder_, marker_, C_STYLE_COMMENT_BLOCK, result_);
    return result_;
  }

  // (star_prefix annotation_expr) +
  private static boolean c_style_comment_block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "c_style_comment_block_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = c_style_comment_block_1_0(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!c_style_comment_block_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "c_style_comment_block_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // star_prefix annotation_expr
  private static boolean c_style_comment_block_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "c_style_comment_block_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = star_prefix(builder_, level_ + 1);
    result_ = result_ && annotation_expr(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // CAPABILITY
  static boolean capability(PsiBuilder builder_, int level_) {
    return consumeToken(builder_, CAPABILITY);
  }

  /* ********************************************************** */
  // ID
  public static boolean header_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "header_id")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ID);
    exit_section_(builder_, marker_, HEADER_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // JSDOC_COMMENT_START (star_prefix annotation_expr) + MULTILINE_COMMENT_END
  public static boolean jsdoc_comment_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "jsdoc_comment_block")) return false;
    if (!nextTokenIs(builder_, JSDOC_COMMENT_START)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, JSDOC_COMMENT_START);
    result_ = result_ && jsdoc_comment_block_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, MULTILINE_COMMENT_END);
    exit_section_(builder_, marker_, JSDOC_COMMENT_BLOCK, result_);
    return result_;
  }

  // (star_prefix annotation_expr) +
  private static boolean jsdoc_comment_block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "jsdoc_comment_block_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = jsdoc_comment_block_1_0(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!jsdoc_comment_block_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "jsdoc_comment_block_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // star_prefix annotation_expr
  private static boolean jsdoc_comment_block_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "jsdoc_comment_block_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = star_prefix(builder_, level_ + 1);
    result_ = result_ && annotation_expr(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ID
  public static boolean key(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "key")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ID);
    exit_section_(builder_, marker_, KEY, result_);
    return result_;
  }

  /* ********************************************************** */
  // ('#' |'//') | star_prefix ('@klotho' '::' capability) | '{' | statement | '}'
  static boolean line_comment(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "line_comment")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = line_comment_0(builder_, level_ + 1);
    if (!result_) result_ = line_comment_1(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, LEFT_BRACE);
    if (!result_) result_ = statement(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, RIGHT_BRACE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '#' |'//'
  private static boolean line_comment_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "line_comment_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, PY_COMMENT);
    if (!result_) result_ = consumeToken(builder_, C_LINE_COMMENT);
    return result_;
  }

  // star_prefix ('@klotho' '::' capability)
  private static boolean line_comment_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "line_comment_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = star_prefix(builder_, level_ + 1);
    result_ = result_ && line_comment_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '@klotho' '::' capability
  private static boolean line_comment_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "line_comment_1_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, ANNOTATION, SEPARATOR);
    result_ = result_ && capability(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (jsdoc_comment_block | c_style_comment_block | line_comment) +
  static boolean root(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "root")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = root_0(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!root_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "root", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // jsdoc_comment_block | c_style_comment_block | line_comment
  private static boolean root_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "root_0")) return false;
    boolean result_;
    result_ = jsdoc_comment_block(builder_, level_ + 1);
    if (!result_) result_ = c_style_comment_block(builder_, level_ + 1);
    if (!result_) result_ = line_comment(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // '[' header_id ']'
  public static boolean section_header(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "section_header")) return false;
    if (!nextTokenIs(builder_, LEFT_BRACKET)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SECTION_HEADER, null);
    result_ = consumeToken(builder_, LEFT_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, header_id(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RIGHT_BRACKET) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // Number | string | MULTILINE_STRING | BOOLEAN
  static boolean simple_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "simple_value")) return false;
    boolean result_;
    result_ = Number(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, MULTILINE_STRING);
    if (!result_) result_ = consumeToken(builder_, BOOLEAN);
    return result_;
  }

  /* ********************************************************** */
  // ('*' | '//' ) *
  static boolean star_prefix(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "star_prefix")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!star_prefix_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "star_prefix", pos_)) break;
    }
    return true;
  }

  // '*' | '//'
  private static boolean star_prefix_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "star_prefix_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, STAR);
    if (!result_) result_ = consumeToken(builder_, C_LINE_COMMENT);
    return result_;
  }

  /* ********************************************************** */
  // star_prefix (((assignment_expr | section_header) TOML_COMMENT) | TOML_COMMENT | any_expr)
  public static boolean statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, STATEMENT, "<statement>");
    result_ = star_prefix(builder_, level_ + 1);
    result_ = result_ && statement_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ((assignment_expr | section_header) TOML_COMMENT) | TOML_COMMENT | any_expr
  private static boolean statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = statement_1_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, TOML_COMMENT);
    if (!result_) result_ = any_expr(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (assignment_expr | section_header) TOML_COMMENT
  private static boolean statement_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = statement_1_0_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, TOML_COMMENT);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // assignment_expr | section_header
  private static boolean statement_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_1_0_0")) return false;
    boolean result_;
    result_ = assignment_expr(builder_, level_ + 1);
    if (!result_) result_ = section_header(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // simple_value | array
  static boolean value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "value")) return false;
    boolean result_;
    result_ = simple_value(builder_, level_ + 1);
    if (!result_) result_ = array(builder_, level_ + 1);
    return result_;
  }

}
