# InspectionBugPoC
This repository is a proof-of-concept Android Studio project to demonstrate a bug with the inspection engine in 2021.2 and above.

When a dependency is added in a dependent module, some methods in the :androidApp module are no longer found, even though build passes without error.

## Steps to reproduce
This project was created with the [Kotlin Multiplatform Mobile](https://kotlinlang.org/lp/mobile/) plugin for Android Studio.

After creation, I added the dependency in the shared [build.gradle.kts](shared/build.gradle.kts#L29),
which causes the `registerForActivityResultMethod`in [MainActivity.kt](androidApp/src/main/java/com/example/inspectionbugpoc/android/MainActivity.kt#L19)
to no longer be found by the inspection engine (`Unresolved reference: registerForActivityResult`),
however, building the project still works.

Also, this error does not appear, if the import statement is not in the shared module build.gradle.kts,
but in the [androidApp-Module build-file](androidApp/build.gradle.kts#L28) instead.
