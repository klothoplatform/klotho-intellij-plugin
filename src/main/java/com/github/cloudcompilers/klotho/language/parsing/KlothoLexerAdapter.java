package com.github.cloudcompilers.klotho.language.parsing;

import com.github.cloudcompilers.klotho.language._KlothoLexer;
import com.intellij.lexer.FlexAdapter;

public class KlothoLexerAdapter extends FlexAdapter {

    public KlothoLexerAdapter() {
        super(new _KlothoLexer(null));
    }
}
