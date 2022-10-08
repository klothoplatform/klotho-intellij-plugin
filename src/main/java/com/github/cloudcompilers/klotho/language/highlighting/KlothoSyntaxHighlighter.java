package com.github.cloudcompilers.klotho.language.highlighting;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

import com.github.cloudcompilers.klotho.language.parsing.KlothoLexerAdapter;
import com.github.cloudcompilers.klotho.language.psi.KlothoTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class KlothoSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey(
                    "KLOTHO_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey ANNOTATION =
            createTextAttributesKey("KLOTHO_ANNOTATION", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("KLOTHO_STRING", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey PLAIN_NUMBER =
            createTextAttributesKey("KLOTHO_PLAIN_NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey HEX_NUMBER =
            createTextAttributesKey("KLOTHO_HEX_NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey OCT_NUMBER =
            createTextAttributesKey("KLOTHO_OCT_NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey BIN_NUMBER =
            createTextAttributesKey("KLOTHO_BIN_NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey BOOLEAN =
            createTextAttributesKey("KLOTHO_BOOLEAN", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey ID =
            createTextAttributesKey("KLOTHO_ID", DefaultLanguageHighlighterColors.IDENTIFIER);

    public static final TextAttributesKey HEADER_ID = createTextAttributesKey("HEADER_ID", ID);

    public static final TextAttributesKey CAPABILITY =
            createTextAttributesKey(
                    "KLOTHO_CAPABILITY", DefaultLanguageHighlighterColors.CLASS_NAME);

    public static final TextAttributesKey TOML_COMMENT =
            createTextAttributesKey(
                    "KLOTHO_TOML_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

    public static final TextAttributesKey STAR =
            createTextAttributesKey("KLOTHO_STAR", DefaultLanguageHighlighterColors.BLOCK_COMMENT);

    public static final TextAttributesKey BRACES =
            createTextAttributesKey("KLOTHO_BRACES", DefaultLanguageHighlighterColors.BRACES);

    public static final TextAttributesKey BRACKETS =
            createTextAttributesKey("KLOTHO_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);

    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("KLOTHO_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] BAD_CHAR_KEYS =
            new TextAttributesKey[] {BAD_CHARACTER};

    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[] {SEPARATOR};

    private static final TextAttributesKey[] ID_KEYS = new TextAttributesKey[] {ID};

    private static final TextAttributesKey[] HEADER_ID_KEYS = new TextAttributesKey[] {HEADER_ID};

    private static final TextAttributesKey[] CAPABILITY_KEYS = new TextAttributesKey[] {CAPABILITY};

    private static final TextAttributesKey[] ANNOTATION_KEYS = new TextAttributesKey[] {ANNOTATION};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[] {STRING};

    private static final TextAttributesKey[] PLAIN_NUMBER_KEYS =
            new TextAttributesKey[] {PLAIN_NUMBER};

    private static final TextAttributesKey[] OCT_NUMBER_KEYS =
            new TextAttributesKey[] {OCT_NUMBER, PLAIN_NUMBER};

    private static final TextAttributesKey[] HEX_NUMBER_KEYS =
            new TextAttributesKey[] {HEX_NUMBER, PLAIN_NUMBER};

    private static final TextAttributesKey[] BIN_NUMBER_KEYS =
            new TextAttributesKey[] {BIN_NUMBER, PLAIN_NUMBER};

    private static final TextAttributesKey[] BOOLEAN_KEYS = new TextAttributesKey[] {BOOLEAN};

    private static final TextAttributesKey[] COMMENT_BLOCK_KEYS = new TextAttributesKey[] {STAR};

    private static final TextAttributesKey[] TOML_COMMENT_KEYS =
            new TextAttributesKey[] {TOML_COMMENT};

    private static final TextAttributesKey[] BRACES_KEYS = new TextAttributesKey[] {BRACES};

    private static final TextAttributesKey[] BRACKETS_KEYS = new TextAttributesKey[] {BRACKETS};

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull @Override
    public Lexer getHighlightingLexer() {
        return new KlothoLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (KlothoTypes.SEPARATOR.equals(tokenType)) {
            return SEPARATOR_KEYS;
        } else if (KlothoTypes.ANNOTATION.equals(tokenType)) {
            return ANNOTATION_KEYS;
        } else if (KlothoTypes.CAPABILITY.equals(tokenType)) {
            return CAPABILITY_KEYS;
        } else if (KlothoTypes.ID.equals(tokenType)) {
            return ID_KEYS;
        } else if (KlothoTypes.HEADER_ID.equals(tokenType)) {
            return HEADER_ID_KEYS;
        } else if (KlothoTypes.STRING.equals(tokenType)
                || KlothoTypes.MULTILINE_STRING.equals(tokenType)) {
            return STRING_KEYS;
        } else if (List.of(
                        KlothoTypes.JSDOC_COMMENT_START,
                        KlothoTypes.MULTILINE_COMMENT_START,
                        KlothoTypes.MULTILINE_COMMENT_END,
                        KlothoTypes.STAR,
                        KlothoTypes.MULTILINE_LINE_SEPARATOR,
                        KlothoTypes.C_LINE_COMMENT,
                        KlothoTypes.PY_COMMENT)
                .contains(tokenType)) {
            return COMMENT_BLOCK_KEYS;
        } else if (KlothoTypes.RAW_COMMENT.equals(tokenType)
                || KlothoTypes.TOML_COMMENT.equals(tokenType)) {
            return TOML_COMMENT_KEYS;
        } else if (KlothoTypes.OCT_PREFIX.equals(tokenType)
                || KlothoTypes.DIG0_7.equals(tokenType)) {
            return OCT_NUMBER_KEYS;
        } else if (KlothoTypes.BIN_PREFIX.equals(tokenType)
                || KlothoTypes.DIG0_1.equals(tokenType)) {
            return BIN_NUMBER_KEYS;
        } else if (KlothoTypes.HEX_PREFIX.equals(tokenType)
                || KlothoTypes.HEX_DIG.equals(tokenType)) {
            return HEX_NUMBER_KEYS;
        } else if (KlothoTypes.PLAIN_NUMBER.equals(tokenType)) {
            return PLAIN_NUMBER_KEYS;
        } else if (KlothoTypes.BOOLEAN.equals(tokenType)) {
            return BOOLEAN_KEYS;
        } else if (KlothoTypes.LEFT_BRACE.equals(tokenType)
                || KlothoTypes.RIGHT_BRACE.equals(tokenType)) {
            return BRACES_KEYS;
        } else if (KlothoTypes.LEFT_BRACKET.equals(tokenType)
                || KlothoTypes.RIGHT_BRACKET.equals(tokenType)) {
            return BRACKETS_KEYS;
        } else if (TokenType.BAD_CHARACTER.equals(tokenType)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }
}
