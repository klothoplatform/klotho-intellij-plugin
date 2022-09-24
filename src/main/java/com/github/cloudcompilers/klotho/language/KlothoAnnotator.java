//package com.github.cloudcompilers.klotho.language;
//
//import com.github.cloudcompilers.klotho.language.highlighting.KlothoSyntaxHighlighter;
//import com.github.cloudcompilers.klotho.language.psi.KlothoProperty;
//import com.intellij.codeInspection.ProblemHighlightType;
//import com.intellij.lang.annotation.AnnotationHolder;
//import com.intellij.lang.annotation.Annotator;
//import com.intellij.lang.annotation.HighlightSeverity;
//import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
//import com.intellij.openapi.util.TextRange;
//import com.intellij.psi.PsiComment;
//import com.intellij.psi.PsiElement;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.List;
//
//public class KlothoAnnotator implements Annotator {
//
//  // Define strings for the Klotho language prefix - used for annotations, line markers, etc.
//  public static final String KLOTHO_PREFIX_STR = "@klotho";
//  public static final String KLOTHO_SEPARATOR_STR = "::";
//
//  @Override
//  public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
//    // Ensure the Psi Element is an expression
//    if (!(element instanceof PsiComment)) {
//      return;
//    }
//
//    // Ensure the Psi element contains a string that starts with the prefix and separator
//      PsiComment literalExpression = (PsiComment) element;
//    String value = literalExpression.getText();
//    if ((value == null) || !value.contains(KLOTHO_PREFIX_STR + KLOTHO_SEPARATOR_STR)) {
//      return;
//    }
//
//    // Define the text ranges (start is inclusive, end is exclusive)
//    // "klotho:key"
//    //  01234567890
//    TextRange prefixRange = TextRange.from(element.getTextRange().getStartOffset() + value.indexOf(KLOTHO_PREFIX_STR) - 1, KLOTHO_PREFIX_STR.length() + 1);
//    TextRange separatorRange = TextRange.from(prefixRange.getEndOffset(), KLOTHO_SEPARATOR_STR.length());
//    TextRange keyRange = new TextRange(separatorRange.getEndOffset(), element.getTextRange().getEndOffset() - 1);
//
//    // highlight "@klotho" prefix and "::" separator
//    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
//            .range(prefixRange).textAttributes(DefaultLanguageHighlighterColors.KEYWORD).create();
//    holder.newAnnotation(HighlightSeverity.INFORMATION,"found annotation")
//            .range(separatorRange).textAttributes(KlothoSyntaxHighlighter.SEPARATOR).create();
//
//
//    // Get the list of properties for given key
//    String key = value.substring(KLOTHO_PREFIX_STR.length() + KLOTHO_SEPARATOR_STR.length());
//    List<KlothoProperty> properties = KlothoUtil.findProperties(element.getProject(), key);
//    if (properties.isEmpty()) {
//      holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved property")
//              .range(keyRange)
//              .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
//              // ** Tutorial step 18.3 - Add a quick fix for the string containing possible properties
////              .withFix(new KlothoCreatePropertyQuickFix(key))
//              .create();
//    } else {
//      // Found at least one property, force the text attributes to Klotho syntax value character
//      holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
//              .range(keyRange).textAttributes(KlothoSyntaxHighlighter.VALUE).create();
//    }
//  }
//
//}
