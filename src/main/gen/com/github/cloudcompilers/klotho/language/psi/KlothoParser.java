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
    return Root(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // StarPrefix '{' [EOL] AnnotationContent [EOL] StarPrefix '}' [EOL]
  public static boolean AnnotationBody(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "AnnotationBody")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ANNOTATION_BODY, "<annotation body>");
    result_ = StarPrefix(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LEFT_BRACE);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, AnnotationBody_2(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, AnnotationContent(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, AnnotationBody_4(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, StarPrefix(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, RIGHT_BRACE)) && result_;
    result_ = pinned_ && AnnotationBody_7(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // [EOL]
  private static boolean AnnotationBody_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "AnnotationBody_2")) return false;
    consumeToken(builder_, EOL);
    return true;
  }

  // [EOL]
  private static boolean AnnotationBody_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "AnnotationBody_4")) return false;
    consumeToken(builder_, EOL);
    return true;
  }

  // [EOL]
  private static boolean AnnotationBody_7(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "AnnotationBody_7")) return false;
    consumeToken(builder_, EOL);
    return true;
  }

  /* ********************************************************** */
  // [Statement *]
  static boolean AnnotationContent(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "AnnotationContent")) return false;
    AnnotationContent_0(builder_, level_ + 1);
    return true;
  }

  // Statement *
  private static boolean AnnotationContent_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "AnnotationContent_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!Statement(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "AnnotationContent_0", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '@klotho' '::' Capability [ AnnotationBody ]
  public static boolean AnnotationExpr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "AnnotationExpr")) return false;
    if (!nextTokenIs(builder_, ANNOTATION)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ANNOTATION_EXPR, null);
    result_ = consumeTokens(builder_, 0, ANNOTATION, SEPARATOR);
    result_ = result_ && Capability(builder_, level_ + 1);
    pinned_ = result_; // pin = 3
    result_ = result_ && AnnotationExpr_3(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // [ AnnotationBody ]
  private static boolean AnnotationExpr_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "AnnotationExpr_3")) return false;
    AnnotationBody(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // AssignmentExpr | SectionHeader
  static boolean AnyExpr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "AnyExpr")) return false;
    if (!nextTokenIs(builder_, "", ID, LEFT_BRACKET)) return false;
    boolean result_;
    result_ = AssignmentExpr(builder_, level_ + 1);
    if (!result_) result_ = SectionHeader(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // '[' ([(Value ( [StarPrefix] ',' [StarPrefix] )) * [StarPrefix] [Value] !','] )  ']'
  public static boolean Array(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Array")) return false;
    if (!nextTokenIs(builder_, LEFT_BRACKET)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ARRAY, null);
    result_ = consumeToken(builder_, LEFT_BRACKET);
    result_ = result_ && Array_1(builder_, level_ + 1);
    pinned_ = result_; // pin = 2
    result_ = result_ && consumeToken(builder_, RIGHT_BRACKET);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // [(Value ( [StarPrefix] ',' [StarPrefix] )) * [StarPrefix] [Value] !',']
  private static boolean Array_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Array_1")) return false;
    Array_1_0(builder_, level_ + 1);
    return true;
  }

  // (Value ( [StarPrefix] ',' [StarPrefix] )) * [StarPrefix] [Value] !','
  private static boolean Array_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Array_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Array_1_0_0(builder_, level_ + 1);
    result_ = result_ && Array_1_0_1(builder_, level_ + 1);
    result_ = result_ && Array_1_0_2(builder_, level_ + 1);
    result_ = result_ && Array_1_0_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (Value ( [StarPrefix] ',' [StarPrefix] )) *
  private static boolean Array_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Array_1_0_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!Array_1_0_0_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "Array_1_0_0", pos_)) break;
    }
    return true;
  }

  // Value ( [StarPrefix] ',' [StarPrefix] )
  private static boolean Array_1_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Array_1_0_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Value(builder_, level_ + 1);
    result_ = result_ && Array_1_0_0_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // [StarPrefix] ',' [StarPrefix]
  private static boolean Array_1_0_0_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Array_1_0_0_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Array_1_0_0_0_1_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COMMA);
    result_ = result_ && Array_1_0_0_0_1_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // [StarPrefix]
  private static boolean Array_1_0_0_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Array_1_0_0_0_1_0")) return false;
    StarPrefix(builder_, level_ + 1);
    return true;
  }

  // [StarPrefix]
  private static boolean Array_1_0_0_0_1_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Array_1_0_0_0_1_2")) return false;
    StarPrefix(builder_, level_ + 1);
    return true;
  }

  // [StarPrefix]
  private static boolean Array_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Array_1_0_1")) return false;
    StarPrefix(builder_, level_ + 1);
    return true;
  }

  // [Value]
  private static boolean Array_1_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Array_1_0_2")) return false;
    Value(builder_, level_ + 1);
    return true;
  }

  // !','
  private static boolean Array_1_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Array_1_0_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !consumeToken(builder_, COMMA);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // Key '=' Value
  public static boolean AssignmentExpr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "AssignmentExpr")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ASSIGNMENT_EXPR, null);
    result_ = Key(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, EQ);
    pinned_ = result_; // pin = 2
    result_ = result_ && Value(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
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
  // MULTILINE_COMMENT_START (StarPrefix AnnotationExpr) + MULTILINE_COMMENT_END
  public static boolean CStyleCommentBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "CStyleCommentBlock")) return false;
    if (!nextTokenIs(builder_, MULTILINE_COMMENT_START)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, MULTILINE_COMMENT_START);
    result_ = result_ && CStyleCommentBlock_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, MULTILINE_COMMENT_END);
    exit_section_(builder_, marker_, C_STYLE_COMMENT_BLOCK, result_);
    return result_;
  }

  // (StarPrefix AnnotationExpr) +
  private static boolean CStyleCommentBlock_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "CStyleCommentBlock_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = CStyleCommentBlock_1_0(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!CStyleCommentBlock_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "CStyleCommentBlock_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // StarPrefix AnnotationExpr
  private static boolean CStyleCommentBlock_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "CStyleCommentBlock_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = StarPrefix(builder_, level_ + 1);
    result_ = result_ && AnnotationExpr(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // CAPABILITY | ID
  static boolean Capability(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Capability")) return false;
    if (!nextTokenIs(builder_, "", CAPABILITY, ID)) return false;
    boolean result_;
    result_ = consumeToken(builder_, CAPABILITY);
    if (!result_) result_ = consumeToken(builder_, ID);
    return result_;
  }

  /* ********************************************************** */
  // ID
  public static boolean HeaderId(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "HeaderId")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ID);
    exit_section_(builder_, marker_, HEADER_ID, result_);
    return result_;
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
  // '{' [AssignmentExpr] (',' AssignmentExpr) * '}'
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

  // [AssignmentExpr]
  private static boolean InlineTable_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "InlineTable_1")) return false;
    AssignmentExpr(builder_, level_ + 1);
    return true;
  }

  // (',' AssignmentExpr) *
  private static boolean InlineTable_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "InlineTable_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!InlineTable_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "InlineTable_2", pos_)) break;
    }
    return true;
  }

  // ',' AssignmentExpr
  private static boolean InlineTable_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "InlineTable_2_0")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, COMMA);
    pinned_ = result_; // pin = 1
    result_ = result_ && AssignmentExpr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // JSDOC_COMMENT_START (StarPrefix AnnotationExpr) + MULTILINE_COMMENT_END
  public static boolean JSDocCommentBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "JSDocCommentBlock")) return false;
    if (!nextTokenIs(builder_, JSDOC_COMMENT_START)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, JSDOC_COMMENT_START);
    result_ = result_ && JSDocCommentBlock_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, MULTILINE_COMMENT_END);
    exit_section_(builder_, marker_, JS_DOC_COMMENT_BLOCK, result_);
    return result_;
  }

  // (StarPrefix AnnotationExpr) +
  private static boolean JSDocCommentBlock_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "JSDocCommentBlock_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = JSDocCommentBlock_1_0(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!JSDocCommentBlock_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "JSDocCommentBlock_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // StarPrefix AnnotationExpr
  private static boolean JSDocCommentBlock_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "JSDocCommentBlock_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = StarPrefix(builder_, level_ + 1);
    result_ = result_ && AnnotationExpr(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ID
  public static boolean Key(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Key")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ID);
    exit_section_(builder_, marker_, KEY, result_);
    return result_;
  }

  /* ********************************************************** */
  // LineCommentPrefix AnnotationExpr
  public static boolean LineComment(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LineComment")) return false;
    if (!nextTokenIs(builder_, "<line comment>", C_LINE_COMMENT, PY_COMMENT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LINE_COMMENT, "<line comment>");
    result_ = LineCommentPrefix(builder_, level_ + 1);
    result_ = result_ && AnnotationExpr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
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
  // (JSDocCommentBlock | CStyleCommentBlock | LineComment) +
  static boolean Root(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Root")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Root_0(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!Root_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "Root", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // JSDocCommentBlock | CStyleCommentBlock | LineComment
  private static boolean Root_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Root_0")) return false;
    boolean result_;
    result_ = JSDocCommentBlock(builder_, level_ + 1);
    if (!result_) result_ = CStyleCommentBlock(builder_, level_ + 1);
    if (!result_) result_ = LineComment(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // '[' HeaderId ']'
  public static boolean SectionHeader(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SectionHeader")) return false;
    if (!nextTokenIs(builder_, LEFT_BRACKET)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SECTION_HEADER, null);
    result_ = consumeToken(builder_, LEFT_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, HeaderId(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RIGHT_BRACKET) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // Number | string | MULTILINE_STRING | BOOLEAN
  static boolean SimpleValue(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SimpleValue")) return false;
    boolean result_;
    result_ = Number(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, MULTILINE_STRING);
    if (!result_) result_ = consumeToken(builder_, BOOLEAN);
    return result_;
  }

  /* ********************************************************** */
  // ('*' + | LineCommentPrefix) *
  static boolean StarPrefix(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "StarPrefix")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!StarPrefix_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "StarPrefix", pos_)) break;
    }
    return true;
  }

  // '*' + | LineCommentPrefix
  private static boolean StarPrefix_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "StarPrefix_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = StarPrefix_0_0(builder_, level_ + 1);
    if (!result_) result_ = LineCommentPrefix(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '*' +
  private static boolean StarPrefix_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "StarPrefix_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, STAR);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, STAR)) break;
      if (!empty_element_parsed_guard_(builder_, "StarPrefix_0_0", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // StarPrefix ((AnyExpr [TOML_COMMENT]) | TOML_COMMENT)  [EOL]
  public static boolean Statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, STATEMENT, "<statement>");
    result_ = StarPrefix(builder_, level_ + 1);
    result_ = result_ && Statement_1(builder_, level_ + 1);
    result_ = result_ && Statement_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (AnyExpr [TOML_COMMENT]) | TOML_COMMENT
  private static boolean Statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Statement_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Statement_1_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, TOML_COMMENT);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // AnyExpr [TOML_COMMENT]
  private static boolean Statement_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Statement_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = AnyExpr(builder_, level_ + 1);
    result_ = result_ && Statement_1_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // [TOML_COMMENT]
  private static boolean Statement_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Statement_1_0_1")) return false;
    consumeToken(builder_, TOML_COMMENT);
    return true;
  }

  // [EOL]
  private static boolean Statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Statement_2")) return false;
    consumeToken(builder_, EOL);
    return true;
  }

  /* ********************************************************** */
  // SimpleValue | Array | InlineTable
  static boolean Value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Value")) return false;
    boolean result_;
    result_ = SimpleValue(builder_, level_ + 1);
    if (!result_) result_ = Array(builder_, level_ + 1);
    if (!result_) result_ = InlineTable(builder_, level_ + 1);
    return result_;
  }

}
