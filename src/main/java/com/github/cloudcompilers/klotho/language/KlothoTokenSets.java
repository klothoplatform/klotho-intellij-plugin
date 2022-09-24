package com.github.cloudcompilers.klotho.language;

import com.github.cloudcompilers.klotho.language.psi.KlothoTypes;
import com.intellij.psi.tree.TokenSet;

public interface KlothoTokenSets {

//  TokenSet COMMENT_BLOCK = TokenSet.create(KlothoTypes.JSDOC_COMMENT_BLOCK);

  TokenSet COMMENTS = TokenSet.create(KlothoTypes.TOML_COMMENT);

}
