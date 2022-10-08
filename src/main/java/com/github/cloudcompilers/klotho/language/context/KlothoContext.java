package com.github.cloudcompilers.klotho.language.context;

import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import org.jetbrains.annotations.NotNull;

public class KlothoContext extends TemplateContextType {

    protected KlothoContext() {
        super("KLOTHO", "Klotho");
    }

    @Override
    public boolean isInContext(@NotNull TemplateActionContext templateActionContext) {
        return templateActionContext.getFile().getName().endsWith(".klotho");
    }
}
