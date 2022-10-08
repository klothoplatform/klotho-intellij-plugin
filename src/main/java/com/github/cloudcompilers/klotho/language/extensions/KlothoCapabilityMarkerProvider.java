package com.github.cloudcompilers.klotho.language.extensions;

import com.github.cloudcompilers.klotho.language.KlothoIcons;
import com.github.cloudcompilers.klotho.language.psi.KlothoTypes;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class KlothoCapabilityMarkerProvider extends RelatedItemLineMarkerProvider {

    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element,
                                            @NotNull Collection<? super RelatedItemLineMarkerInfo<?>> result) {
        // This must be a capability with an annotation expression as a parent
        if (!(element instanceof ASTNode && ((ASTNode) element).getElementType() == KlothoTypes.CAPABILITY)) {
            return;
        }


        // TODO: mention the capability ID once we have property support for annotation directives
        NavigationGutterIconBuilder<PsiElement> builder =
                NavigationGutterIconBuilder.create(KlothoIcons.GUTTER)
                        .setTargets(element)
                        .setTooltipText(element.getText() + " capability");

        result.add(builder.createLineMarkerInfo(element));

    }

}
