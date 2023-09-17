plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.csk.mymapssample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.csk.mymapssample"
        minSdk = 24
        //noinspection EditedTargetSdkVersion
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.core)
    implementation(Dependencies.lifecycleRt)
    implementation(Compose.compose)
    implementation(platform(Compose.composeBOM))
    implementation(Compose.ui)
    implementation(Compose.uiGraphics)
    implementation(Compose.preview)
    implementation(Compose.material3)
    implementation(Compose.navigation)

    //Hilt
    implementation(Hilt.android)
    implementation(Hilt.navigationCompose)
    ksp(Hilt.compiler)

    //viewModel for compose
    implementation(Compose.lifecyle)
    implementation(Compose.runtime)

    // Coroutines
    implementation (Coroutine.core)
    implementation (Coroutine.android)

    //retrofit
    implementation (Retrofit.gsonConverter)
    implementation (Retrofit.retrofit)

    //okhttp
    implementation (Dependencies.okhttp)
    implementation (Dependencies.okhttpSquare)

    //room
    implementation(Room.runtime)
    implementation(Room.ktx)
    ksp(Room.compiler)

    implementation(Dependencies.googleMaps)
    implementation(Dependencies.googleMapsCompose)

    implementation(Dependencies.locationPlayService)

    //test
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitExt)
    androidTestImplementation(Dependencies.espresso)
    androidTestImplementation(platform(Compose.composeBOM))
    androidTestImplementation(Compose.uiTestJunit4)

    //debug
    debugImplementation(Compose.tooling)
    debugImplementation(Compose.uiTestManifest)
}