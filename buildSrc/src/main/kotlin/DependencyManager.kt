import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.uiImplentation() {
    AndroidX.getAll().forEach { implementation(it) }
    Coroutines.getAll().forEach { implementation(it) }
    Navigation.getAll().forEach { implementation(it) }
    implementation(AndroidX.composeMaterialIconsExtended)
    implementation(Di.hilt)
    kapt(Di.hiltCompiler)
}

fun DependencyHandler.domainImplentation() {
    implementation(Network.retrofitConvertor)
    Coroutines.getAll().forEach { implementation(it) }
    Network.getAll().forEach { implementation(it) }
}

fun DependencyHandler.domainNetworkImplentation() {
    Network.getAll().forEach { implementation(it) }
}
fun DependencyHandler.databaseImplementation() {
    implementation(Coil.coil)
    implementation(Room.room)
    implementation(Room.roomKTX)
    implementation(Room.roomPaging)
    kapt(Room.roomCompiler)
}

fun DependencyHandler.dataImplementation() {
    // implementation(project(Modules.Data.DATABASE))
    Network.getAll().forEach { implementation(it) }
    implementation(AndroidX.pagingCompose)
    implementation(Di.hilt)
    kapt(Di.hiltCompiler)
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
}

@Suppress("detekt.UnusedPrivateMember")
fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

@Suppress("detekt.UnusedPrivateMember")
private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)
