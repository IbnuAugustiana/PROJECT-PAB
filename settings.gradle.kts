try {
    System.clearProperty("ANDROID_PREFS_ROOT")
    val peClass = Class.forName("java.lang.ProcessEnvironment")
    val fields = arrayOf("theEnvironment", "theUnmodifiableEnvironment", "theCaseInsensitiveEnvironment")
    for (fieldName in fields) {
        try {
            val f = peClass.getDeclaredField(fieldName)
            f.isAccessible = true
            val map = f.get(null)
            if (map is MutableMap<*, *>) {
                map.remove("ANDROID_PREFS_ROOT")
                map.remove("android_prefs_root")
            }
        } catch (e: Throwable) {
        }
    }
} catch (e: Throwable) {
}

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PAB_Praktikum 01"
include(":app")
