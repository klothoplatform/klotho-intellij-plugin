package com.github.cloudcompilers.klotho.language;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.Nullable;

/**
 * This only works in .klotho files. Injected languages don't seem to have the ability override the host's commenter for injected blocks.
 */
public class KlothoCommenter implements Commenter {
    @Override
    public @Nullable String getLineCommentPrefix() {
        return "#";
    }

    @Override
    public @Nullable String getBlockCommentPrefix() {
        return null;
    }

    @Override
    public @Nullable String getBlockCommentSuffix() {
        return null;
    }

    @Override
    public @Nullable String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Override
    public @Nullable String getCommentedBlockCommentSuffix() {
        return null;
    }

    @Override
    public boolean blockCommentRequiresFullLineSelection() {
        return false;
    }
}
