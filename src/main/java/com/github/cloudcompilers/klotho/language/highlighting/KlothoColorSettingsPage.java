package com.github.cloudcompilers.klotho.language.highlighting;

import com.github.cloudcompilers.klotho.language.KlothoIcons;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class KlothoColorSettingsPage implements ColorSettingsPage {

  private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
          new AttributesDescriptor("Annotation", KlothoSyntaxHighlighter.ANNOTATION),
          new AttributesDescriptor("Comment prefix", KlothoSyntaxHighlighter.STAR),
          new AttributesDescriptor("Separator", KlothoSyntaxHighlighter.SEPARATOR),
          new AttributesDescriptor("Identifier", KlothoSyntaxHighlighter.ID),
          new AttributesDescriptor("Capability", KlothoSyntaxHighlighter.CAPABILITY),
          new AttributesDescriptor("String", KlothoSyntaxHighlighter.STRING),
          new AttributesDescriptor("Number", KlothoSyntaxHighlighter.PLAIN_NUMBER),
          new AttributesDescriptor("Embedded comment", KlothoSyntaxHighlighter.TOML_COMMENT),
          new AttributesDescriptor("Bad value", KlothoSyntaxHighlighter.BAD_CHARACTER)
  };

  @Nullable
  @Override
  public Icon getIcon() {
    return KlothoIcons.FILE;
  }

  @NotNull
  @Override
  public SyntaxHighlighter getHighlighter() {
    return new KlothoSyntaxHighlighter();
  }

  @NotNull
  @Override
  public String getDemoText() {
    return "/**\n" +
            " * @klotho::exec_unit {\n" +
            " * # 1234dasd aasdasd asd {}asa \"123\"\n" +
            "  }\n" +
            " */\n" +
            "\n" +
            "/*\n" +
            " * @klotho::exec_unit {\n" +
            " * # 1234dasd aasdasd asd {}asa \"123\"\n" +
            " *   id = \"he#llo\" # 123\"\n" +
            " *   other = 1.0\n" +
            " *   other = 1.\n" +
            " *   other = 1\n" +
            " * # 1234dasd aasd{'\"}asd asd {}asa\n" +
            " *\n" +
            " * }\n" +
            " */\n" +
            " \n" +
            " /* @klotho::exec_unit {\n" +
            "  *   id = \"he#llo\" # 123\"\n" +
            "  * }\n" +
            "  */\n" +
            "  \n" +
            "/* \n" +
            " * * @klotho::exec_unit {\n" +
            " *   id = \"he#llo\" # 123\"\n" +
            " * }\n" +
            "*/";
  }

  @Nullable
  @Override
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

  @NotNull
  @Override
  public String getDisplayName() {
    return "Klotho";
  }

}
