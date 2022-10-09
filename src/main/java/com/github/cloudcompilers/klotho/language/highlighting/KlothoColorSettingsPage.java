package com.github.cloudcompilers.klotho.language.highlighting;

import com.github.cloudcompilers.klotho.language.KlothoIcons;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import java.util.Map;
import javax.swing.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class KlothoColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS =
            new AttributesDescriptor[] {
                new AttributesDescriptor("Annotation", KlothoSyntaxHighlighter.ANNOTATION),
                new AttributesDescriptor("Comment prefix", KlothoSyntaxHighlighter.STAR),
                new AttributesDescriptor(
                        "Date and time literals", KlothoSyntaxHighlighter.DATE_TIME_LITERAL),
                new AttributesDescriptor("Separator", KlothoSyntaxHighlighter.SEPARATOR),
                new AttributesDescriptor("Identifier", KlothoSyntaxHighlighter.ID),
                new AttributesDescriptor("Section header", KlothoSyntaxHighlighter.HEADER_ID),
                new AttributesDescriptor("Capability", KlothoSyntaxHighlighter.CAPABILITY),
                new AttributesDescriptor("String", KlothoSyntaxHighlighter.STRING),
                new AttributesDescriptor("Number", KlothoSyntaxHighlighter.PLAIN_NUMBER),
                new AttributesDescriptor("Embedded comment", KlothoSyntaxHighlighter.TOML_COMMENT),
                new AttributesDescriptor("Braces", KlothoSyntaxHighlighter.BRACES),
                new AttributesDescriptor("Brackets", KlothoSyntaxHighlighter.BRACKETS),
                new AttributesDescriptor("Bad value", KlothoSyntaxHighlighter.BAD_CHARACTER)
            };

    @Nullable @Override
    public Icon getIcon() {
        return KlothoIcons.FILE;
    }

    @NotNull @Override
    public SyntaxHighlighter getHighlighter() {
        return new KlothoSyntaxHighlighter();
    }

    @NotNull @Override
    public String getDemoText() {
        return "/**\n"
                + " * @klotho::expose {\n"
                + " *   id = 1\n"
                + " *   x = \"2\" # comment\n"
                + " *   [ zasd ]\n"
                + " *   x = 1\n"
                + " *   # comment\n"
                + " *   x = [ -1, +1., 1.0, .12, 2, \"3\", [], [\"123\", +1],]\n"
                + " *   z = { x = 1, y = 2, a = [] }\n"
                + " *   z.2_xy-z = 1\n"
                + " *   string = \"string\"\n"
                + " *   multiline = \"\"\"multiline\n"
                + " *    string content\n"
                + " *   \"\"\"\n"
                + " * } #comment\n"
                + " */\n"
                + "\n"
                + "/* @klotho::expose {\n"
                + " *   id = 1\n"
                + " *   x = \"2\" # comment\n"
                + " *   [ zasd ]\n"
                + " *   x = 1\n"
                + " *   # comment\n"
                + " *   x = [ 1, 2, \"3\", [], [\"123\", 1],]\n"
                + " *   z = { x = 1, y = 2, a = [] }\n"
                + " *   z.2_xy-z = 1\n"
                + " * }\n"
                + " */\n"
                + "\n"
                + "// @klotho::expose {\n"
                + "//   id = 1\n"
                + "//   x = \"2\" # comment\n"
                + "//   [ zasd ]\n"
                + "//   x = 1\n"
                + "//   # comment\n"
                + "//   x = [ 1, 2, \"3\", [], [\"123\", 1],]\n"
                + "//   z = { x = 1, y = 2, a = [] }\n"
                + "//   z.2_xy-z = 1\n"
                + "// } # comment\n"
                + "\n"
                + "# @klotho::expose {\n"
                + "#   id = 1\n"
                + "#   x = \"2\" # comment\n"
                + "#   [ zasd ]\n"
                + "#   x = 1\n"
                + "#   # comment\n"
                + "#   x = [ 1, 2, \"3\", [], [\"123\", 1],]\n"
                + "#   z = { x = 1, y = 2, a = [] }\n"
                + "#   z.2_xy-z = 1\n"
                + "# } # comment";
    }

    @Nullable @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull @Override
    public String getDisplayName() {
        return "Klotho";
    }
}
