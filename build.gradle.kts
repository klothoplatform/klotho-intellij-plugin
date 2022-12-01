import org.jetbrains.changelog.markdownToHTML

fun properties(key: String) = project.findProperty(key).toString()
sourceSets["main"].java.srcDirs("src/main/gen")

plugins {
    // Java support
    id("java")
    // Kotlin support
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    // Gradle IntelliJ Plugin
    id("org.jetbrains.intellij") version "1.9.0"
    // Gradle Changelog Plugin
    id("org.jetbrains.changelog") version "1.3.1"
    // Gradle Qodana Plugin
    id("org.jetbrains.qodana") version "0.1.13"
    // Gradle Grammar-Kit Plugin
    id("org.jetbrains.grammarkit") version "2021.2.2"
    // Gradle Spotless Code Formatting Plugin
    id("com.diffplug.spotless") version "6.11.0"
}

group = properties("pluginGroup")
version = properties("pluginVersion")

// Configure project's dependencies
repositories {
    mavenCentral()
}

// Set the JVM language level used to compile sources and generate files - Java 11 is required since 2020.3
kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

// Configure Gradle IntelliJ Plugin - read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    pluginName.set(properties("pluginName"))
    version.set(properties("platformVersion"))
    type.set(properties("platformType"))
    downloadSources.set(properties("platformDownloadSources") == "true")

    // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file.
    plugins.set(properties("platformPlugins").split(',').map(String::trim).filter(String::isNotEmpty))
}

// Configure Gradle Changelog Plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
changelog {
    version.set(properties("pluginVersion"))
    groups.set(emptyList())
}

// Configure Gradle Qodana Plugin - read more: https://github.com/JetBrains/gradle-qodana-plugin
qodana {
    cachePath.set(projectDir.resolve(".qodana").canonicalPath)
    reportPath.set(projectDir.resolve("build/reports/inspections").canonicalPath)
    saveReport.set(true)
    showReport.set(System.getenv("QODANA_SHOW_REPORT")?.toBoolean() ?: false)
}

grammarKit {
    tasks {
        generateLexer {
            source.set("src/main/grammars/_KlothoLexer.flex")
            targetDir.set("src/main/gen/com/github/cloudcompilers/klotho/language")
            targetClass.set("_KlothoLexer")
        }

        generateParser {
            source.set("src/main/grammars/Klotho.bnf")
            targetRoot.set("src/main/gen")
            pathToParser.set("KlothoParser.java")
            pathToPsiRoot.set("com/github/cloudcompilers/klotho/language/psi")
            purgeOldFiles.set(true)
        }
    }
}

spotless {
    format("misc") {
        // define the files to apply `misc` to
        target("*.gradle", "*.md", ".gitignore")

        // define the steps to apply to those files
        trimTrailingWhitespace()
        indentWithTabs() // or spaces. Takes an integer argument if you don't like 4
        endWithNewline()
    }
    java {
        // don't need to set target, it is inferred from java
        targetExclude("src/main/gen/com/github/cloudcompilers/klotho/language/psi/**")
        // apply a specific flavor of google-java-format
        googleJavaFormat("1.15.0").aosp().reflowLongStrings()
        // fix formatting of type annotations
        formatAnnotations()
        // make sure every file has the following copyright header.
        // optionally, Spotless can set copyright years by digging
        // through git history (see "license" section below)
        //  licenseHeader("/* (C)\$YEAR */")
    }
}

tasks {
    wrapper {
        gradleVersion = properties("gradleVersion")
    }

    patchPluginXml {
        version.set(properties("pluginVersion"))
        sinceBuild.set(properties("pluginSinceBuild"))
        untilBuild.set(properties("pluginUntilBuild"))

        // Extract the <!-- Plugin description --> section from README.md and provide for the plugin's manifest
        pluginDescription.set(
            projectDir.resolve("README.md").readText().lines().run {
                val start = "<!-- Plugin description -->"
                val end = "<!-- Plugin description end -->"

                if (!containsAll(listOf(start, end))) {
                    throw GradleException("Plugin description section not found in README.md:\n$start ... $end")
                }
                subList(indexOf(start) + 1, indexOf(end))
            }.joinToString("\n").run { markdownToHTML(this) }
        )

        // Get the latest available change notes from the changelog file
        changeNotes.set(provider {
            changelog.run {
                getOrNull(properties("pluginVersion")) ?: getLatest()
            }.toHTML()
        })
    }

    // Configure UI tests plugin
    // Read more: https://github.com/JetBrains/intellij-ui-test-robot
    runIdeForUiTests {
        systemProperty("robot-server.port", "8082")
        systemProperty("ide.mac.message.dialogs.as.sheets", "false")
        systemProperty("jb.privacy.policy.text", "<!--999.999-->")
        systemProperty("jb.consents.confirmation.enabled", "false")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        dependsOn("patchChangelog")
        token.set(System.getenv("PUBLISH_TOKEN"))
        // pluginVersion is based on the SemVer (https://semver.org) and supports pre-release labels, like 2.1.7-alpha.3
        // Specify pre-release label to publish the plugin in a custom Release Channel automatically. Read more:
        // https://plugins.jetbrains.com/docs/intellij/deployment.html#specifying-a-release-channel
        channels.set(listOf(properties("pluginVersion").split('-').getOrElse(1) { "default" }.split('.').first()))
    }

    runIde {
        // Absolute path to the installed targetIDE to use as IDE Development
        // Instance (the "Contents" directory is macOS specific):
//      //ideDir.set(file("<HOME>Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/<BUILD>/IntelliJ IDEA.app/Contents"))
    }
}

tasks.getByPath("compileJava").mustRunAfter("generateLexer", "generateParser")
tasks.getByPath("spotlessApply").mustRunAfter("generateLexer", "generateParser")
tasks.getByPath("buildPlugin").mustRunAfter("generateLexer", "generateParser", "spotlessApply")
tasks.getByPath("runIde").mustRunAfter("generateLexer", "generateParser", "spotlessApply")

task("buildKlothoPlugin") {
    dependsOn("generateLexer", "generateParser", "spotlessApply", "buildPlugin")
    logger.info("Klotho plugin build complete.")
}

task("runKlothoPlugin") {
    dependsOn("generateLexer", "generateParser", "spotlessApply", "runIde")
    logger.info("Klotho plugin run complete.")
}
