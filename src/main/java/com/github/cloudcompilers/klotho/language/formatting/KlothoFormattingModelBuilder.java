package com.github.cloudcompilers.klotho.language.formatting;

import com.github.cloudcompilers.klotho.language.KlothoLanguage;
import com.github.cloudcompilers.klotho.language.psi.KlothoTypes;
import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;

/** SAMPLE:: do not enable this a proper implementation */
public class KlothoFormattingModelBuilder implements FormattingModelBuilder {

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, KlothoLanguage.INSTANCE)
                .around(KlothoTypes.EQ)
                .spaceIf(
                        settings.getCommonSettings(KlothoLanguage.INSTANCE.getID())
                                .SPACE_AROUND_ASSIGNMENT_OPERATORS)
                .before(KlothoTypes.ID)
                .none();
    }

    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
        return FormattingModelProvider.createFormattingModelForPsiFile(
                formattingContext.getContainingFile(),
                new KlothoBlock(
                        formattingContext.getNode(),
                        Wrap.createWrap(WrapType.NONE, false),
                        Alignment.createAlignment(true),
                        createSpaceBuilder(codeStyleSettings)),
                codeStyleSettings);
    }
}
