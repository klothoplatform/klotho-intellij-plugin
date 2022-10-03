package com.github.cloudcompilers.klotho.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.cloudcompilers.klotho.language.psi.KlothoTypes.*;

// manual imports
import java.util.Stack;

%%

%{
  public _KlothoLexer() {
    this((java.io.Reader)null);
  }

  private Stack<Integer> stack = new Stack<Integer>();

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
%}

%public
%class _KlothoLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=[^\S\R\r\n]+

SPACE=[ \t\n\x0B\f\r]+
STRING=('(([^'][^']|[^'\\])|\\.)*'|\"(([^\"][^\"]|[^\"\\])|\\.)*\")
MULTILINE_STRING=('''|\"\"\")(.*?\r?\n?)*('''|\"\"\")
PLAIN_NUMBER=(\+?|-?)((\d+\.?\d*)|(\.\d+))
TOML_COMMENT=(#.*)
CAPABILITY=[:letter:][a-zA-Z_0-9]* // could also be hardcored list of capabilities
JSDOC_COMMENT_START="/"\*\*\s?
MULTILINE_COMMENT_START="/*"
C_LINE_COMMENT=\s*\/\/
PY_COMMENT=#
// identifier variants
ID=[:letter:][a-zA-Z_0-9\-.]*
CAPABILITY=[:letter:][a-zA-Z_0-9]* // could also be hardcored list of capabilities
SECTION_HEADER=[:letter:][a-zA-Z_0-9]*
BOOLEAN=(true|false)

DIG0_7=[0-7]+
DIG0_1=[0-1]+
HEX_DIG=[A-Fa-f\d]+

// states
%state multiline_comment line_comment raw annotation_decl line_content inline_table assignment array
%xstate capability_name bin_number oct_number hex_number

%%

<YYINITIAL> {
  {JSDOC_COMMENT_START}          { yypushState(multiline_comment); return JSDOC_COMMENT_START; }
  {MULTILINE_COMMENT_START}      { yypushState(multiline_comment); return MULTILINE_COMMENT_START; }
  {C_LINE_COMMENT}               { yypushState(line_comment); return C_LINE_COMMENT; }
  {PY_COMMENT}                   { yypushState(line_comment); return PY_COMMENT; }
}

<multiline_comment> {
  "*/"                           { yyresetState(YYINITIAL); return MULTILINE_COMMENT_END; }
  "*"                            { yypushState(line_content); return STAR;}
  {TOML_COMMENT}                 { return TOML_COMMENT; }
}

<line_content> {
  {EOL}                          { yypopState(); return EOL; }
}

<line_comment> {
 {EOL}                           { yyresetState(YYINITIAL); return WHITE_SPACE;}
 {TOML_COMMENT}                 { return TOML_COMMENT; }
}

<multiline_comment, line_comment, line_content> {
  "}"                            { return RIGHT_BRACE;}
  "="                            { yypushState(assignment); return EQ; }
  "["                            { return LEFT_BRACKET; } // section header start
  "]"                            { return RIGHT_BRACKET; } // section header end
  {TOML_COMMENT}                 { return TOML_COMMENT; }
  {ID}                           { return ID; }
  "@klotho"                      { yypushState(annotation_decl); return ANNOTATION; }
}

<annotation_decl> {
    "::"                         { yypushState(capability_name); return SEPARATOR; }
    "{"                          { yypopState(); return LEFT_BRACE; }
  }

// special handling for capability names since they match the same pattern as other identifiers
<capability_name> {
  {CAPABILITY}                    { yypopState(); return CAPABILITY; }
}

<assignment> {
    "{"                            { yypushState(inline_table); return LEFT_BRACE; }
    "}"                            { return RIGHT_BRACE; } // end of annotation
    {EOL}                          { yypopState(); switch (yystate()){ case line_comment:{ yyresetState(YYINITIAL); break;} case line_content:{yypopState(); break;}} return WHITE_SPACE; }
    {STRING}                       { yypopState(); return STRING; }
    {PLAIN_NUMBER}                 { yypopState(); return PLAIN_NUMBER; }
    {BOOLEAN}                      { yypopState(); return BOOLEAN; }
    {MULTILINE_STRING}             { return MULTILINE_STRING; } // probably not working right now
    "0x"                           { yybegin(hex_number); return HEX_PREFIX; }
    "0o"                           { yybegin(oct_number); return OCT_PREFIX; }
    "0b"                           { yybegin(bin_number); return BIN_PREFIX; }

    <array, inline_table> {
        "["                            { yypushState(array); return LEFT_BRACKET; } // array start
    }
}

<array> {
   "]"                            { yypopState(); return RIGHT_BRACKET; } // array end
}

<inline_table> {
  {ID}                           { return ID; }
   "="                           { return EQ; }
   "}"                           { yypopState(); yypopState(); return RIGHT_BRACE;} // end of expression
}

<array, inline_table> {
  "0x"                           { yypushState(hex_number); return HEX_PREFIX; }
  "0o"                           { yypushState(oct_number); return OCT_PREFIX; }
  "0b"                           { yypushState(bin_number); return BIN_PREFIX; }
  {STRING}                       { return STRING; }
  {PLAIN_NUMBER}                        { return PLAIN_NUMBER; }
  {BOOLEAN}                      { return BOOLEAN; }
  {MULTILINE_STRING}             { return MULTILINE_STRING; }  // probably not working right now
   ","                           { return COMMA; }
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
{EOL}                          { return WHITE_SPACE; }
{WHITE_SPACE}                  { return WHITE_SPACE; }

// fallback if nothing matches
[^] { return BAD_CHARACTER; }
