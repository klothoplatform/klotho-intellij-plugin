package com.github.cloudcompilers.klotho.language.parsing;

import com.github.cloudcompilers.klotho.language.psi.KlothoTypes;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;

public interface KlothoTokenSets {

  TokenSet COMMENTS = TokenSet.create(KlothoTypes.TOML_COMMENT, KlothoTypes.RAW_COMMENT);

  TokenSet WHITE_SPACE = TokenSet.create(TokenType.WHITE_SPACE);

}
