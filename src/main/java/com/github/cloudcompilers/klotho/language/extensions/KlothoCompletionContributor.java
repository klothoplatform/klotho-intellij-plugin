package com.github.cloudcompilers.klotho.language.extensions;

import com.github.cloudcompilers.klotho.language.psi.KlothoTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class KlothoCompletionContributor extends CompletionContributor {

  public KlothoCompletionContributor() {
    extend(CompletionType.BASIC, PlatformPatterns.psiElement(KlothoTypes.CAPABILITY),
            new CompletionProvider<>() {
              public void addCompletions(@NotNull CompletionParameters parameters,
                                         @NotNull ProcessingContext context,
                                         @NotNull CompletionResultSet resultSet) {
                resultSet.addElement(LookupElementBuilder.create("embed_assets"));
                resultSet.addElement(LookupElementBuilder.create("exec_unit"));
                resultSet.addElement(LookupElementBuilder.create("expose"));
                resultSet.addElement(LookupElementBuilder.create("persist"));
                resultSet.addElement(LookupElementBuilder.create("pubsub"));
              }
            }
    );
  }

}
