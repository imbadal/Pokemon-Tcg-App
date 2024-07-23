plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.android.pokemontcg"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.android.pokemontcg"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "BASE_URL", "\"https://api.pokemontcg.io/v2/\"");
        buildConfigField("String", "APP_PREFS", "\"app_prefs\"");
        buildConfigField("String", "POKEMON_DB", "\"pokemon_db\"");

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.core.ktx.v1131)
    implementation(libs.lifecycle.runtime.ktx.v283)
    implementation(libs.activity.compose.v190)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidxComposeUi)
    implementation(libs.material3.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.junit.v121)
    androidTestImplementation(libs.espresso.core.v361)

    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation(libs.ui.v143)
    implementation(libs.material3.v120alpha04)
    implementation(libs.runtime)
    implementation(libs.foundation)

    implementation(libs.retrofit)
    implementation(libs.retrofitConverterGson)

    implementation(libs.hilt.android.v2511)
    implementation(libs.hilt.navigation.compose.v120)
    kapt(libs.hilt.android.compiler)

    implementation(libs.kotlinx.coroutines.android.v181)
    implementation(libs.kotlinx.coroutines.core.v181)
    implementation(libs.lifecycle.viewmodel.ktx.v283)
    implementation(libs.lifecycle.livedata.ktx.v283)

    implementation(libs.room.runtime.v261)
    kapt(libs.room.compiler)

    annotationProcessor(libs.room.compiler)
    implementation(libs.room.ktx.v261)

    implementation(libs.coil.compose.v270)

    implementation(libs.accompanist.placeholder.material.v0300)
    implementation(libs.navigation.compose.v277)
}