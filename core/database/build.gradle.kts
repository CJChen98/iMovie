plugins {
    id("imovie.android.lib")
    id("imovie.android.hilt")
    alias(libs.plugins.ksp)
}
android {
    namespace = "cn.chitanda.app.imovie.core.database"
}

dependencies {
    implementation(libs.room.runtime)
    implementation(libs.room.paging)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    implementation(libs.paging3.runtime)
    implementation(libs.kotlinx.datetime)
}
