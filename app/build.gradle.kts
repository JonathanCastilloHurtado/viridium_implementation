plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.viridium_implementation"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.viridium_implementation"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
      implementation(project(mapOf("path" to ":veridium-settings-ui-release")))
    implementation(project(mapOf("path" to ":veridium-fourf-ui-release")))
    implementation(project(mapOf("path" to ":veridium-core-release")))
    implementation(project(mapOf("path" to ":veridium-fourf-release")))
    implementation(project(mapOf("path" to ":veridium-support-release")))
    implementation(project(mapOf("path" to ":veridium-analytics-release")))
    implementation(project(mapOf("path" to ":veridiumid-sdk-release")))
    implementation(project(mapOf("path" to ":veridium-secure-data-release")))
    project(":veridium-core-release")
      project(":veridium-analytics-release")
      project(":veridium-fourf-release")
      project(":veridium-fourf-ui-release")
      project(":veridiumid-sdk-release")
      project(":veridium-secure-data-release")
      project(":veridium-settings-ui-release")
      project(":veridium-support-release")


    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}