package com.github.cloudcompilers.klotho.language.annotation;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/** SAMPLE :: do not enable this annotator without a proper implementation */
public class KlothoAnnotator implements Annotator {

    // Define strings for the Klotho language prefix - used for annotations, line markers, etc.
    public static final String KLOTHO_PREFIX_STR = "@klotho";
    public static final String KLOTHO_SEPARATOR_STR = "::";

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        //    PsiElement e = element;
        //    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
        //            .needsUpdateOnTyping(true)
        //            .range(TextRange.from(0, element.getTextLength()))
        //            .textAttributes(KlothoSyntaxHighlighter.ID)
        //            .create();
    }
}
