plugins {
    id("com.android.application")
}

android {
    namespace = "com.assesment.cmedtask02"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.assesment.cmedtask02"
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
    viewBinding{
        enable = true
    }

    dataBinding {
        enable = true
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("androidx.fragment:fragment:1.6.1")

    implementation ("com.android.support:multidex:1.0.3")
    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.6.4")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // rx
    implementation ("io.reactivex.rxjava2:rxandroid:2.0.1")
    implementation ("io.reactivex.rxjava2:rxjava:2.0.6")
    implementation ("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")

    implementation ("android.arch.lifecycle:viewmodel:1.1.1")
    implementation ("android.arch.lifecycle:livedata:1.1.1")

    //type convert
    implementation ("com.google.code.gson:gson:2.9.1")

    // piccaso
    implementation ("com.squareup.picasso:picasso:2.8")

    val nav_version = "2.7.4"
    // Java language implementation
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")
}