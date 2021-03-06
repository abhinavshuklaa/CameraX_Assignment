# CameraX_Assignment
This repository is for the code submission of Kaagaz Scanner Android Assignment

##ScreenShots

<img src ="https://user-images.githubusercontent.com/56826217/127779930-9656a9ed-4464-44d4-9412-76dc8ef9abfa.png" width=200 height=400/><img src ="https://user-images.githubusercontent.com/56826217/127779937-871b7813-aadf-49a7-b24f-f8cd74df6dbe.png" width=200 height=400/><img src ="https://user-images.githubusercontent.com/56826217/127779941-17330a72-f83b-4c74-8fd9-8a6aea8ed6c4.png" width=200 height=400/><img src ="https://user-images.githubusercontent.com/56826217/127779944-c736488e-7c1f-453d-8967-e4e0827bb190.png" width=200 height=400/><img src ="https://user-images.githubusercontent.com/56826217/127779945-41776b63-cd81-49af-9477-6c547f680445.png" width=200 height=400/><img src ="https://user-images.githubusercontent.com/56826217/127779948-2ca442ae-6780-4c21-abbb-a701543ad070.png" width=200 height=400/>

## Description  :
-  A Camera app using uses the CameraX library. The camera is an in-app camera which clicks multiple 
clicks in one go and preview all photos. Also storing the album details into the room database.
- Minimum sdk : 23
- Target SDK : 29

## Technology/Stack Used

**In this project I have used the following tech stack.**
- Kotlin 
- Android
- MVVM architecture
- Room Database
- CameraX library(https://developer.android.com/training/camerax.)
- 

### dependencies {

    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation 'androidx.core:core-ktx:1.6.0'
    implementation 'androidx.appcompat:appcompat:1.3.1'
    implementation 'com.google.android.material:material:1.4.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

    def jetpack_version = "2.3.0"
    def arch_version = '2.2.0-alpha01'
    def coroutines = "1.4.1"
    def kotlinCoroutineVersion = "1.4.2"

    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-extensions:$arch_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$arch_version"

    //Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion"
    implementation 'de.hdodenhof:circleimageview:3.1.0'
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
    implementation 'com.todkars:shimmer-recyclerview:0.4.1'
    implementation 'com.facebook.shimmer:shimmer:0.5.0'

    //lottie animations
    implementation "com.airbnb.android:lottie:3.7.0"

    def room_version = "2.2.5"

    kapt "androidx.room:room-compiler:$room_version"

    //  Kotlin Extensions and Coroutines support for Room
    implementation "androidx.room:room-ktx:$room_version"
    implementation "androidx.room:room-runtime:$room_version"
    implementation("io.coil-kt:coil:1.0.0-rc3")

    // CameraX core library
    def camerax_version = '1.1.0-alpha07'
    implementation "androidx.camera:camera-core:$camerax_version"

    // CameraX Camera2 extensions
    implementation "androidx.camera:camera-camera2:$camerax_version"

    // CameraX Lifecycle library
    implementation "androidx.camera:camera-lifecycle:$camerax_version"

    // CameraX View class
    implementation 'androidx.camera:camera-view:1.0.0-alpha27'

    // CameraX Extensions library
    // implementation 'androidx.camera:camera-extensions:1.0.0-alpha27'

    //WindowManager
    implementation 'androidx.window:window:1.0.0-alpha09'

    //Libraries for Unit Tests
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation "android.arch.core:" +
            "core-testing:1.1.0"
    testImplementation 'org.robolectric:robolectric:4.0'
    testImplementation "com.android.support.test.espresso:espresso-core:3.0.2"
    testImplementation "androidx.test.ext:junit-ktx:1.1.2-beta01"
    androidTestImplementation "androidx.test.ext:junit-ktx:1.1.2-beta01"
    androidTestImplementation "org.mockito:mockito-core:2.27.0"
    testImplementation "org.mockito:mockito-core:2.27.0"
    
### Install

After making a clone of this repo open your cmd/terminal and use by installing in your phone.


### Please fork the repository and then use it on your own. If you want to collaborate with us on this project then please feel free to reach out to us.


## Show your support

Give a ?????? if you like this project!



