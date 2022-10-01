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
  // BIN_PREFIX DIG0_1
  public static boolean BinNumber(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "BinNumber")) return false;
    if (!nextTokenIs(builder_, BIN_PREFIX)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, BIN_NUMBER, null);
    result_ = consumeTokens(builder_, 1, BIN_PREFIX, DIG0_1);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // HEX_PREFIX HEX_DIG
  public static boolean HexNumber(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "HexNumber")) return false;
    if (!nextTokenIs(builder_, HEX_PREFIX)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, HEX_NUMBER, null);
    result_ = consumeTokens(builder_, 1, HEX_PREFIX, HEX_DIG);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '{' [assignment_expr] (',' assignment_expr) * '}'
  public static boolean InlineTable(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "InlineTable")) return false;
    if (!nextTokenIs(builder_, LEFT_BRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, INLINE_TABLE, null);
    result_ = consumeToken(builder_, LEFT_BRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, InlineTable_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, InlineTable_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RIGHT_BRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // [assignment_expr]
  private static boolean InlineTable_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "InlineTable_1")) return false;
    assignment_expr(builder_, level_ + 1);
    return true;
  }

  // (',' assignment_expr) *
  private static boolean InlineTable_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "InlineTable_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!InlineTable_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "InlineTable_2", pos_)) break;
    }
    return true;
  }

  // ',' assignment_expr
  private static boolean InlineTable_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "InlineTable_2_0")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, COMMA);
    pinned_ = result_; // pin = 1
    result_ = result_ && assignment_expr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '#' + | '//' +
  static boolean LineCommentPrefix(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LineCommentPrefix")) return false;
    if (!nextTokenIs(builder_, "", C_LINE_COMMENT, PY_COMMENT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = LineCommentPrefix_0(builder_, level_ + 1);
    if (!result_) result_ = LineCommentPrefix_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '#' +
  private static boolean LineCommentPrefix_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LineCommentPrefix_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, PY_COMMENT);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, PY_COMMENT)) break;
      if (!empty_element_parsed_guard_(builder_, "LineCommentPrefix_0", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '//' +
  private static boolean LineCommentPrefix_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LineCommentPrefix_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, C_LINE_COMMENT);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, C_LINE_COMMENT)) break;
      if (!empty_element_parsed_guard_(builder_, "LineCommentPrefix_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // PlainNumber | HexNumber | BinNumber | OctNumber
  public static boolean Number(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Number")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NUMBER, "<number>");
    result_ = PlainNumber(builder_, level_ + 1);
    if (!result_) result_ = HexNumber(builder_, level_ + 1);
    if (!result_) result_ = BinNumber(builder_, level_ + 1);
    if (!result_) result_ = OctNumber(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // OCT_PREFIX DIG0_7
  public static boolean OctNumber(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "OctNumber")) return false;
    if (!nextTokenIs(builder_, OCT_PREFIX)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OCT_NUMBER, null);
    result_ = consumeTokens(builder_, 1, OCT_PREFIX, DIG0_7);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // ['-' | '+'] DIGIT + ['.' DIGIT *]
  public static boolean PlainNumber(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PlainNumber")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, PLAIN_NUMBER, "<plain number>");
    result_ = PlainNumber_0(builder_, level_ + 1);
    result_ = result_ && PlainNumber_1(builder_, level_ + 1);
    pinned_ = result_; // pin = 2
    result_ = result_ && PlainNumber_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ['-' | '+']
  private static boolean PlainNumber_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PlainNumber_0")) return false;
    PlainNumber_0_0(builder_, level_ + 1);
    return true;
  }

  // '-' | '+'
  private static boolean PlainNumber_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PlainNumber_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SUB);
    if (!result_) result_ = consumeToken(builder_, ADD);
    return result_;
  }

  // DIGIT +
  private static boolean PlainNumber_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PlainNumber_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DIGIT);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, DIGIT)) break;
      if (!empty_element_parsed_guard_(builder_, "PlainNumber_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ['.' DIGIT *]
  private static boolean PlainNumber_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PlainNumber_2")) return false;
    PlainNumber_2_0(builder_, level_ + 1);
    return true;
  }

  // '.' DIGIT *
  private static boolean PlainNumber_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PlainNumber_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, PERIOD);
    result_ = result_ && PlainNumber_2_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // DIGIT *
  private static boolean PlainNumber_2_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PlainNumber_2_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, DIGIT)) break;
      if (!empty_element_parsed_guard_(builder_, "PlainNumber_2_0_1", pos_)) break;
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
  // '@klotho' '::' capability [annotation_body]
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

  // [annotation_body]
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
  // CAPABILITY | ID
  static boolean capability(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "capability")) return false;
    if (!nextTokenIs(builder_, "", CAPABILITY, ID)) return false;
    boolean result_;
    result_ = consumeToken(builder_, CAPABILITY);
    if (!result_) result_ = consumeToken(builder_, ID);
    return result_;
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
  // LineCommentPrefix annotation_expr
  public static boolean line_comment(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "line_comment")) return false;
    if (!nextTokenIs(builder_, "<line comment>", C_LINE_COMMENT, PY_COMMENT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LINE_COMMENT, "<line comment>");
    result_ = LineCommentPrefix(builder_, level_ + 1);
    result_ = result_ && annotation_expr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
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
  // ('*' + | LineCommentPrefix) *
  static boolean star_prefix(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "star_prefix")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!star_prefix_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "star_prefix", pos_)) break;
    }
    return true;
  }

  // '*' + | LineCommentPrefix
  private static boolean star_prefix_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "star_prefix_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = star_prefix_0_0(builder_, level_ + 1);
    if (!result_) result_ = LineCommentPrefix(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '*' +
  private static boolean star_prefix_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "star_prefix_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, STAR);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, STAR)) break;
      if (!empty_element_parsed_guard_(builder_, "star_prefix_0_0", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // star_prefix ((any_expr TOML_COMMENT) | TOML_COMMENT | any_expr) [EOL]
  public static boolean statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, STATEMENT, "<statement>");
    result_ = star_prefix(builder_, level_ + 1);
    result_ = result_ && statement_1(builder_, level_ + 1);
    result_ = result_ && statement_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (any_expr TOML_COMMENT) | TOML_COMMENT | any_expr
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

  // any_expr TOML_COMMENT
  private static boolean statement_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = any_expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, TOML_COMMENT);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // [EOL]
  private static boolean statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_2")) return false;
    consumeToken(builder_, EOL);
    return true;
  }

  /* ********************************************************** */
  // simple_value | array | InlineTable
  static boolean value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "value")) return false;
    boolean result_;
    result_ = simple_value(builder_, level_ + 1);
    if (!result_) result_ = array(builder_, level_ + 1);
    if (!result_) result_ = InlineTable(builder_, level_ + 1);
    return result_;
  }

}
