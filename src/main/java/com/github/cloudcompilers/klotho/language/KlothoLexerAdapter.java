package com.github.cloudcompilers.klotho.language;

import com.intellij.lexer.FlexAdapter;

public class KlothoLexerAdapter extends FlexAdapter {

  public KlothoLexerAdapter() {
    super(new _KlothoLexer(null));
  }

}
