/*
 * Copyright 2022 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    kotlin("multiplatform")
    id("dev.icerock.mobile.multiplatform-resources")
    id("detekt-convention")
    id("org.jetbrains.compose")
}

kotlin {
    iosX64("uikitX64") {
        binaries {
            executable() {
                entryPoint = "main"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal",
                    "-linker-option", "-framework", "-linker-option", "CoreText",
                    "-linker-option", "-framework", "-linker-option", "CoreGraphics"
                )
            }
        }
    }
    iosArm64("uikitArm64") {
        binaries {
            executable() {
                entryPoint = "main"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal",
                    "-linker-option", "-framework", "-linker-option", "CoreText",
                    "-linker-option", "-framework", "-linker-option", "CoreGraphics"
                )
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.resourcesCompose)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
            }
        }
        val uikitMain by creating {
            dependsOn(commonMain)
        }
        val uikitX64Main by getting {
            dependsOn(uikitMain)
        }
        val uikitArm64Main by getting {
            dependsOn(uikitMain)
        }
    }
}

dependencies {
    commonMainImplementation(projects.sample.mppLibrary)
}

multiplatformResources {
    multiplatformResourcesPackage = "com.icerockdev.app"
}

compose.experimental {
    uikit.application {
        bundleIdPrefix = "com.icerockdev"
        projectName = "MokoResourcesSampleApp"
        deployConfigurations {
            simulator("IPhone13ProMax") {
                //Usage: ./gradlew iosDeployIPhone13ProMaxDebug
                device = org.jetbrains.compose.experimental.dsl.IOSDevices.IPHONE_13_PRO_MAX
            }
            simulator("IPad") {
                //Usage: ./gradlew iosDeployIPadDebug
                device = org.jetbrains.compose.experimental.dsl.IOSDevices.IPAD_MINI_6th_Gen
            }
            connectedDevice("Device") {
                //First need specify your teamId here, or in local.properties (compose.ios.teamId=***)
                //teamId="***"
                //Usage: ./gradlew iosDeployDeviceRelease
            }
        }
    }
}
