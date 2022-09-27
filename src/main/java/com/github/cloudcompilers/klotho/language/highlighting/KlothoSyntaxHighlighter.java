package com.github.cloudcompilers.klotho.language.highlighting;

import com.github.cloudcompilers.klotho.language.KlothoLexerAdapter;
import com.github.cloudcompilers.klotho.language.psi.KlothoTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class KlothoSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("KLOTHO_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey ANNOTATION =
            createTextAttributesKey("KLOTHO_ANNOTATION", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("KLOTHO_STRING", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("KLOTHO_NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey BOOLEAN =
            createTextAttributesKey("KLOTHO_BOOLEAN", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey ID =
            createTextAttributesKey("KLOTHO_ID", DefaultLanguageHighlighterColors.IDENTIFIER);

    public static final TextAttributesKey CAPABILITY =
            createTextAttributesKey("KLOTHO_CAPABILITY", DefaultLanguageHighlighterColors.CLASS_NAME);

    public static final TextAttributesKey TOML_COMMENT =
            createTextAttributesKey("KLOTHO_TOML_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

    public static final TextAttributesKey STAR =
            createTextAttributesKey("KLOTHO_STAR", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("KLOTHO_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};

    private static final TextAttributesKey[] ID_KEYS = new TextAttributesKey[]{ID};

    private static final TextAttributesKey[] CAPABILITY_KEYS = new TextAttributesKey[]{CAPABILITY};

    private static final TextAttributesKey[] ANNOTATION_KEYS = new TextAttributesKey[]{ANNOTATION};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};

    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};

    private static final TextAttributesKey[] BOOLEAN_KEYS = new TextAttributesKey[]{BOOLEAN};
    private static final TextAttributesKey[] COMMENT_BLOCK_KEYS = new TextAttributesKey[]{STAR};

    private static final TextAttributesKey[] TOML_COMMENT_KEYS = new TextAttributesKey[]{TOML_COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new KlothoLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(KlothoTypes.SEPARATOR)) {
            return SEPARATOR_KEYS;
        }
        if (tokenType.equals(KlothoTypes.ANNOTATION)) {
            return ANNOTATION_KEYS;
        }
        if (tokenType.equals(KlothoTypes.CAPABILITY)) {
            return CAPABILITY_KEYS;
        }
        if (tokenType.equals(KlothoTypes.ID)) {
            return ID_KEYS;
        }
        if (tokenType.equals(KlothoTypes.STRING)) {
            return STRING_KEYS;
        }
        if (List.of(
                KlothoTypes.JSDOC_COMMENT_START,
                KlothoTypes.MULTILINE_COMMENT_START,
                KlothoTypes.MULTILINE_COMMENT_END,
                KlothoTypes.STAR
        ).contains(tokenType)) {
            return COMMENT_BLOCK_KEYS;
        }
        if (tokenType.equals(KlothoTypes.TOML_COMMENT)) {
            return TOML_COMMENT_KEYS;
        }
        if (tokenType.equals(KlothoTypes.NUMBER)) {
            return NUMBER_KEYS;
        }
        if (tokenType.equals(KlothoTypes.BOOLEAN)) {
            return BOOLEAN_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

}
