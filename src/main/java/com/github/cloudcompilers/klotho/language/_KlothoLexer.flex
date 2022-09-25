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

  public void yyswapState(int newState) {
      stack.pop();
      stack.push(newState);
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
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
STRING=('(([^'][^']|[^'\\])|\\.)*'|\"(([^\"][^\"]|[^\"\\])|\\.)*\")
MULTILINE_STRING=('''|\"\"\")(.*?\r?\n?)*('''|\"\"\")
NUMBER=[0-9]+\.?[0-9]*
TOML_COMMENT=(#.*)
ID=[:letter:][a-zA-Z_0-9]*
CAPABILITY=[:letter:][a-zA-Z_0-9]* // could also be hardcored list of capabilities
JSDOC_COMMENT_START="/"\*\*\s?
MULTILINE_COMMENT_START="/*"
C_LINE_COMMENT=\s*\/\/
PY_COMMENT=#

// identifier variants
ID=[:letter:][a-zA-Z_0-9]*
CAPABILITY=[:letter:][a-zA-Z_0-9]* // could also be hardcored list of capabilities
SECTION_HEADER=[:letter:][a-zA-Z_0-9]*

// states
%state multiline_comment line_comment raw annotation_decl line_content
%xstate capability_name


%%

// matches all states
{WHITE_SPACE}                  { return WHITE_SPACE; }

<YYINITIAL> {
  {JSDOC_COMMENT_START}          { yypushState(multiline_comment); return JSDOC_COMMENT_START; }
  {MULTILINE_COMMENT_START}      { yypushState(multiline_comment); return MULTILINE_COMMENT_START; }
  {C_LINE_COMMENT}               { yypushState(line_comment); return C_LINE_COMMENT; }
  {PY_COMMENT}                   { yypushState(line_comment); return PY_COMMENT; }
}

<multiline_comment> {
  "*/"                           { yypushState(YYINITIAL); return MULTILINE_COMMENT_END; }
  "*"                            { yypushState(line_content); return STAR;}
}

<line_content> {
  "*"                            { return STAR;}
}

<multiline_comment, line_comment, line_content> {
  "="                            { return EQ; }
  "["                            { return LEFT_BRACKET; }
  "]"                            { return RIGHT_BRACKET; }
  "."                            { return PERIOD; }
  ","                            { return COMMA; }
  {STRING}                       { return STRING; }
  {MULTILINE_STRING}             { return MULTILINE_STRING; }
  {NUMBER}                       { return NUMBER; }
  {TOML_COMMENT}                 { return TOML_COMMENT; }
  {ID}                           { return ID; }
  "@klotho"                      { yypushState(annotation_decl); return ANNOTATION; }
  <annotation_decl> {
    "::"                           { yypushState(capability_name); return SEPARATOR; }
    "{"                            { yypopState(); return LEFT_BRACE; }
  }
  "}"                            { if (yystate() == line_content) yypopState(); return RIGHT_BRACE; }
}

// special handling for capability names since they match the same pattern as other identifiers
<capability_name> {
  {CAPABILITY}                  { yypopState(); return CAPABILITY; }
}

// fallback if nothing matches
[^] { return BAD_CHARACTER; }
