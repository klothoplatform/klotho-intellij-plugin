package com.github.cloudcompilers.klotho.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.cloudcompilers.klotho.language.psi.KlothoTypes.*;

import java.util.Stack;


%%

%{
  public _KlothoLexer() {
    this((java.io.Reader)null);
  }

  private Stack<Integer> stack = new Stack<Integer>();
  private boolean inAnnotation = false;
  private Character currentQuoteType = null;

  public void yypushState(int newState) {
    stack.push(yystate());
    yybegin(newState);
  }

  public void yypopState() {
    yybegin(stack.pop());
  }

  public void yyresetState(int newState) {
      stack.clear();
      yybegin(newState);
  }

  public char yycurrentChar() {
      return yycharat(zzCurrentPos-zzStartRead);
  }

  public char yyrelativeChar(int offset) {
      return yycharat(zzCurrentPos-zzStartRead+offset);
  }

%}

%public
%class _KlothoLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=[\R\r\n]
WHITE_SPACE=[ \t]+
//PLAINTEXT=[^\r\n]

STRING=('(([^'\r\n][^'\r\n]|[^'\\\r\n])|\\.)*'|\"(([^\"\r\n][^\"\r\n]|[^\"\\\r\n])|\\.)*\")
TRIPLE_QUOTE='''|\"\"\"
MULTILINE_STRING_CONTENT=[^\r\n'\\\"]+
MULTILINE_LINE_SEPARATOR=([\r\n]|\r\n)+(\s*(#|\/\/|\*)?)

PLAIN_NUMBER=(\+?|-?)((\d+\.?\d*)|(\.\d+))
TOML_COMMENT=(#.*)
JSDOC_COMMENT_START="/\*\*"
MULTILINE_COMMENT_START="/*"
C_LINE_COMMENT=\/\/
PY_COMMENT=#
// identifier variants
ID=[:letter:][a-zA-Z_0-9\-.]*
HEADER_ID=[:letter:][a-zA-Z_0-9\-.]*
CAPABILITY=[:letter:][a-zA-Z_0-9]* // could also be hardcored list of capabilities
BOOLEAN=(true|false)

DIG0_7=[0-7]+
DIG0_1=[0-1]+
HEX_DIG=[A-Fa-f\d]+

OFFSET_DATE_TIME=\d{4}-\d{2}-\d{2}[T ]\d{2}:\d{2}:\d{2}(\.\d+)?(Z|-\d{2}:\d{2})
LOCAL_DATE_TIME=\d{4}-\d{2}-\d{2}[T ]\d{2}:\d{2}:\d{2}(\.\d+)?
LOCAL_DATE=\d{4}-\d{2}-\d{2}
LOCAL_TIME=\d{2}:\d{2}:\d{2}(\.\d+)?

// states
%state multiline_comment line_comment raw annotation_decl line_content inline_table assignment array header
%xstate capability_name bin_number oct_number hex_number multiline_string

%%

<YYINITIAL> {
  {JSDOC_COMMENT_START}          { yypushState(multiline_comment); return JSDOC_COMMENT_START; }
  {MULTILINE_COMMENT_START}      { yypushState(multiline_comment); return MULTILINE_COMMENT_START; }
  {C_LINE_COMMENT}               { yypushState(line_comment); return C_LINE_COMMENT; }
  {PY_COMMENT}                   { yypushState(line_comment); return PY_COMMENT; }

}

<multiline_comment> {
  "*/"                           { yyresetState(YYINITIAL); return MULTILINE_COMMENT_END; }
  "*"                            { if (inAnnotation) { yypushState(line_content); } return STAR;}
  {TOML_COMMENT}                 { return TOML_COMMENT; }
}

<line_content> {
  {EOL}                          { yypopState(); return EOL; }
}

<line_comment> {
 {EOL}                           { yyresetState(YYINITIAL); return EOL;}
 {TOML_COMMENT}                  { return TOML_COMMENT; }
}



<multiline_comment, line_comment, line_content> {
  "}"                            { boolean wasInAnnotation = inAnnotation; inAnnotation = false; return wasInAnnotation ? RIGHT_BRACE : PLAINTEXT;}
  "="                            { if (inAnnotation) { yypushState(assignment); return EQ; } return PLAINTEXT; }
  "["                            { if (inAnnotation) { yypushState(header); return LEFT_BRACKET; } return PLAINTEXT; } // section header start
  {TOML_COMMENT}                 { return inAnnotation ? TOML_COMMENT : PLAINTEXT; }
  {ID}                           { return inAnnotation ? ID : PLAINTEXT; }
  "@klotho"                      { yypushState(annotation_decl); return ANNOTATION; }
}

<header> {
  {HEADER_ID}                    { return HEADER_ID; }
  "]"                            { yypopState(); return RIGHT_BRACKET; } // section header end
}

<annotation_decl> {
    "::"                         { yypushState(capability_name); return SEPARATOR; }
    "{"                          { yypopState(); inAnnotation = true; return LEFT_BRACE; }
  }

// special handling for capability names since they match the same pattern as other identifiers
<capability_name> {
  {CAPABILITY}                    { yypopState(); return CAPABILITY; }
}

<assignment> {
    "{"                            { yypushState(inline_table); return LEFT_BRACE; }
    "}"                            { inAnnotation = false; return RIGHT_BRACE; } // end of annotation
    {EOL}                          { yypopState(); switch (yystate()){ case line_comment:{ yyresetState(YYINITIAL); break;} case line_content:{yypopState(); break;}} return EOL; }
    {STRING}                       { yypopState(); return STRING; }
    {PLAIN_NUMBER}                 { yypopState(); return PLAIN_NUMBER; }
    {BOOLEAN}                      { yypopState(); return BOOLEAN; }
    {TRIPLE_QUOTE}                 { currentQuoteType = yycurrentChar(); yybegin(multiline_string); return TRIPLE_QUOTE; }
    "0x"                           { yybegin(hex_number); return HEX_PREFIX; }
    "0o"                           { yybegin(oct_number); return OCT_PREFIX; }
    "0b"                           { yybegin(bin_number); return BIN_PREFIX; }
    {OFFSET_DATE_TIME}             { yypopState(); return OFFSET_DATE_TIME; }
    {LOCAL_DATE_TIME}              { yypopState(); return LOCAL_DATE_TIME; }
    {LOCAL_DATE}                   { yypopState(); return LOCAL_DATE; }
    {LOCAL_TIME}                   { yypopState(); return LOCAL_TIME; }

    <array, inline_table> {
        "["                            { yypushState(array); return LEFT_BRACKET; } // array start
    }
}

<multiline_string> {
  {TRIPLE_QUOTE}                   { if (currentQuoteType.equals(yycurrentChar())) { yypopState(); return TRIPLE_QUOTE; } return MULTILINE_STRING_CONTENT; }
  {MULTILINE_LINE_SEPARATOR}       { return MULTILINE_LINE_SEPARATOR; }
  {MULTILINE_STRING_CONTENT}       { return MULTILINE_STRING_CONTENT; }
  "\\\""                           { return MULTILINE_STRING_CONTENT; }
  "\\'"                            { return MULTILINE_STRING_CONTENT; }
  "\""                             { return MULTILINE_STRING_CONTENT; }
  "\\"                             { return MULTILINE_STRING_CONTENT; }
  "'"                              { return MULTILINE_STRING_CONTENT; }
}

<array> {
   "]"                           { yypopState(); return RIGHT_BRACKET; } // array end
}

<inline_table> {
  {ID}                           { return ID; }
   "="                           { return EQ; }
   "}"                           { yypopState(); yypopState(); return RIGHT_BRACE; } // end of expression
}

<array, inline_table> {
  "0x"                           { yypushState(hex_number); return HEX_PREFIX; }
  "0o"                           { yypushState(oct_number); return OCT_PREFIX; }
  "0b"                           { yypushState(bin_number); return BIN_PREFIX; }
  {STRING}                       { return STRING; }
  {PLAIN_NUMBER}                 { return PLAIN_NUMBER; }
  {BOOLEAN}                      { return BOOLEAN; }
  {OFFSET_DATE_TIME}             { return OFFSET_DATE_TIME; }
  {LOCAL_DATE_TIME}              { return LOCAL_DATE_TIME; }
  {LOCAL_DATE}                   { return LOCAL_DATE; }
  {LOCAL_TIME}                   { return LOCAL_TIME; }
   ","                           { return COMMA; }
  {TRIPLE_QUOTE}                 { currentQuoteType = yycurrentChar(); yypushState(multiline_string); return TRIPLE_QUOTE; }
}

<hex_number> {
  {HEX_DIG}                      { yypopState(); return HEX_DIG; }
}

<oct_number> {
  {DIG0_7}                      { yypopState(); return DIG0_7; }
}

<bin_number> {
  {DIG0_1}                      { yypopState(); return DIG0_1; }
}



// matches all states
{EOL}                          { return EOL; }
{WHITE_SPACE}                  { return WHITE_SPACE; }
// fallback if nothing matches
[^] { return inAnnotation ? BAD_CHARACTER : PLAINTEXT; }
