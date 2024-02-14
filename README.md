# About

It loads Pokémon data and display it with a simple and clean UI powered by Jetpack Compose.

# Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.  
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more.
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Gson Converter](https://github.com/google/gson) - A Converter which uses Gson for serialization to and from JSON.
- [Coil-kt](https://coil-kt.github.io/coil/) - An image loading library for Android backed by Kotlin Coroutines.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
- [Navigation](https://developer.android.com/guide/navigation) - Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app.

# Package Structure

    com.example.soostoneassignment # Root Package
    .
    ├── data                 # Data layer
    │   ├── repository    # Repository.
    │   └── remote         # Remote data handlers
    
    ├── presentation    # View layer
    │   ├── ui      		  # Screens with the pokémon list and pokémon detail
    │   ├── navigation   # Navigation between classes
    │   ├── viewmodel   # ViewModel classes
    │   ├── theme          # App theme
   
