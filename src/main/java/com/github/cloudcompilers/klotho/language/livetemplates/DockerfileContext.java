package com.github.cloudcompilers.klotho.language.livetemplates;

import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.docker.dockerFile.DockerLanguage;
import org.jetbrains.annotations.NotNull;

public class DockerfileContext extends TemplateContextType {

    protected DockerfileContext() {
        super("KLOTHO_DOCKERFILE", "Dockerfile (Provided by Klotho)");
    }

    @Override
    public boolean isInContext(@NotNull TemplateActionContext templateActionContext) {
        return templateActionContext.getFile().getLanguage().is(DockerLanguage.INSTANCE);
    }
}
