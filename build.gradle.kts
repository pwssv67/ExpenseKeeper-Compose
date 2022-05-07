ext {
    extra["composeUiVersion"] = "1.1.1"
} // Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version "7.3.0-alpha08" apply false
    id("com.android.library") version "7.3.0-alpha08" apply false
    id("org.jetbrains.kotlin.android") version "1.6.20" apply false
}