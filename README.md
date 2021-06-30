# Fun-Apps
Let the fun begin.

Fun-Apps is simple App listing app that fetches channel and social apps.

# Developed using Clean Architecture, MVVM, Hilt, Kotlin, Data Binding, Coroutines, LiveData and Flow

# Architecture:
Project is developed using Uncle bob's CLEAN ARCHITECTURE.

Project is divided into three layers:
1)Data
2)Domain
3)Presentation

All three layer are divided in package level (simplest way to demonstrate the clean architecture.)

# Data
Data layer is responsible to provide data either from network or from local database.
Data layer is designed in REPOSITORY PATTERN
Data layer uses power of kotlin's coroutines,flow,room and retrofit

# Domain
Domain layer is where the core business logic of the application is defined.
Domain layer has all the use cases of the system.
Domain layer has the abstraction of each repositories. 

# Presentation
Presentation layer is the core applicatin where all activities and fragments are created.
Presentation layer uses google's recommended MVVM pattern.
Presentation layer uses google architectural libraries

