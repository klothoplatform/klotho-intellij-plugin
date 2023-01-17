package com.github.cloudcompilers.klotho.language.livetemplates;

import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.yaml.YAMLLanguage;

public class YamlContext extends TemplateContextType {

    protected YamlContext() {
        super("KLOTHO_YAML", "YAML (Provided by Klotho)");
    }

    @Override
    public boolean isInContext(@NotNull TemplateActionContext templateActionContext) {
        return templateActionContext.getFile().getLanguage().is(YAMLLanguage.INSTANCE);
    }
}
