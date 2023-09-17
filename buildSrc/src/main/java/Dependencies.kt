object Version{
    internal const val CORE = "1.12.0"
    internal const val LIFECYCLE = "2.6.2"
    internal const val COMPOSE = "1.7.2"
    internal const val BOM = "2023.03.00"
    internal const val JUNIT = "4.13.2"
    internal const val JUNIT_EXT = "1.1.5"
    internal const val ESPRESSO = "3.5.1"
    internal const val HILT = "2.48"
    internal const val NAV_COMPOSE = "1.0.0"
    internal const val COROUTINE = "1.7.1"
    internal const val RETROFIT = "2.9.0"
    internal const val COMPOSE_NAVIGATION = "2.7.2"
    internal const val OKHTTP = "4.11.0"
    internal const val GOOGLE_MAPS = "18.1.0"
    internal const val GOOGLE_MAPS_COMPOSE = "2.2.0"
    internal const val LOCATION_SERVICE = "21.0.1"
    internal const val ROOM = "2.5.2"
}

object Dependencies{
    const val core = "androidx.core:core-ktx:${Version.CORE}"
    const val lifecycleRt = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LIFECYCLE}"
    const val junit = "junit:junit:${Version.JUNIT}"
    const val junitExt = "androidx.test.ext:junit:${Version.JUNIT_EXT}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.ESPRESSO}"
    const val okhttp = "com.squareup.okhttp3:logging-interceptor:${Version.OKHTTP}"
    const val okhttpSquare = "com.squareup.okhttp3:okhttp:${Version.OKHTTP}"
    const val googleMaps = "com.google.android.gms:play-services-maps:${Version.GOOGLE_MAPS}"
    const val googleMapsCompose = "com.google.maps.android:maps-compose:${Version.GOOGLE_MAPS_COMPOSE}"
    const val locationPlayService = "com.google.android.gms:play-services-location:${Version.LOCATION_SERVICE}"

}

object Compose {
    const val compose = "androidx.activity:activity-compose:${Version.COMPOSE}"
    const val composeBOM = "androidx.compose:compose-bom:${Version.BOM}"
    const val lifecyle = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.LIFECYCLE}"
    const val runtime = "androidx.lifecycle:lifecycle-runtime-compose:${Version.LIFECYCLE}"
    const val ui = "androidx.compose.ui:ui"
    const val navigation = "androidx.navigation:navigation-compose:${Version.COMPOSE_NAVIGATION}"
    const val uiGraphics = "androidx.compose.ui:ui-graphics"
    const val preview = "androidx.compose.ui:ui-tooling-preview"
    const val material3 = "androidx.compose.material3:material3"
    const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4"
    const val tooling = "androidx.compose.ui:ui-tooling"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"
}

object Hilt {
    const val android = "com.google.dagger:hilt-android:${Version.HILT}"
    const val compiler = "com.google.dagger:hilt-android-compiler:${Version.HILT}"
    const val navigationCompose = "androidx.hilt:hilt-navigation-compose:${Version.NAV_COMPOSE}"
}

object Coroutine{
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.COROUTINE}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.COROUTINE}"
}

object Retrofit {
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.RETROFIT}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Version.ROOM}"
    const val compiler = "androidx.room:room-compiler:${Version.ROOM}"
    const val ktx = "androidx.room:room-ktx:${Version.ROOM}"
}