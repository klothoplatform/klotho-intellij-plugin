package com.github.cloudcompilers.klotho.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.cloudcompilers.klotho.language.psi.KlothoTypes.*;

%%

%{
  public _KlothoLexer() {
    this((java.io.Reader)null);
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
TOML_COMMENT=(#.*\n)
ID=[:letter:][a-zA-Z_0-9]*
CAPABILITY=[:letter:][a-zA-Z_0-9]* // could also be hardcored list of capabilities
JSDOC_COMMENT_START="/"\*\*\r?\n
MULTILINE_COMMENT_START="/"\*(\r?\n|(\r\n)?)

// identifier variants
ID=[:letter:][a-zA-Z_0-9]*
CAPABILITY=[:letter:][a-zA-Z_0-9]* // could also be hardcored list of capabilities
SECTION_HEADER=[:letter:][a-zA-Z_0-9]* // could also be hardcored list of capabilities

// states
%xstate capability_name normal


%%
<YYINITIAL, normal> {
  {WHITE_SPACE}                  { return WHITE_SPACE; }

  "{"                            { return LEFT_BRACE; }
  "}"                            { return RIGHT_BRACE; }
  "="                            { return EQ; }
  "["                            { return LEFT_BRACKET; }
  "]"                            { return RIGHT_BRACKET; }
  "*"                            { return STAR; }
  "."                            { return PERIOD; }
  "@klotho"                      { return ANNOTATION; }
  "::"                           { yybegin(capability_name); return SEPARATOR; }
  "*/"                           { return MULTILINE_COMMENT_END; }

  {SPACE}                        { return SPACE; }
  {STRING}                       { return STRING; }
  {MULTILINE_STRING}             { return MULTILINE_STRING; }
  {NUMBER}                       { return NUMBER; }
  {TOML_COMMENT}                 { return TOML_COMMENT; }
  {JSDOC_COMMENT_START}          { return JSDOC_COMMENT_START; }
  {MULTILINE_COMMENT_START}      { return MULTILINE_COMMENT_START; }

}

<normal> {
  {ID}                           { return ID; }
}

<capability_name> {
  {CAPABILITY}                           { yybegin(normal); return CAPABILITY; }
}

[^] { return BAD_CHARACTER; }
