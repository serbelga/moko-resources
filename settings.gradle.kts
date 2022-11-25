/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()

        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
        
        jcenter {
            content {
                includeGroup("org.jetbrains.kotlinx")
            }
        }
    }
}

includeBuild("resources-build-logic")
includeBuild("resources-generator")
include(":resources")
include(":resources-compose")
include(":resources-test")

include(":sample:android-app")
include(":sample:android-app-compose")
include(":sample:android-mpp-app")
include(":sample:mpp-library")
include(":sample:mpp-library:nested-module")
include(":sample:mpp-library:empty-module")
include(":sample:mpp-conditional")
include(":sample:mpp-hierarhical")
include(":sample:mpp-mixed")
include(":sample:jvm-app")
include(":sample:web-app-compose")
include(":sample:test-utils")
include(":sample:ios-kotlin-app")
include(":sample:ios-kotlin-app-compose")
