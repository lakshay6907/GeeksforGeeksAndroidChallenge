# GeeksforGeeks Android Challenge

## Project Description

The GeeksforGeeks Android Challenge is an Android application that fetches news articles from a remote server and displays them in a RecyclerView. The app separates the articles into enclosures and thumbnails and presents them in a user-friendly manner. It leverages the power of modern Android development techniques, such as ViewModel, LiveData, Retrofit for networking, and Coil for image loading.

## Features

- Fetches news articles from a remote server.
- Separates articles into enclosures and thumbnails.
- Utilizes ViewModel and LiveData for data management.
- Implements RecyclerView for displaying the articles.
- Uses Retrofit for network communication.
- Integrates Coil for efficient image loading.

## Installation

1. Clone the repository:
   git clone [https://github.com/your-username/geeksforgeeks-android-challenge.git](https://github.com/lakshay6907/GeeksforGeeksAndroidChallenge.git)
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.   

##  Usage
1. Launch the app on your Android device or emulator.
2. View the list of news articles separated into enclosures and thumbnails.
3. Scroll through the articles.

## Project Structure
   The project has the following structure:
   - app
     - src
       - main
         - java/com/example/geeksforgeeksandroidchallenge
           - Adapter
             - ItemAdapter.kt
           - Data
             - Article.kt
             - Enclosure.kt
             - News.kt
           - Network
             - ApiService.kt
           - Viewholder
             - Viewholder1.kt
             - Viewholder2.kt
           - ViewModel
             - NewsViewModel.kt
           - MainActivity.kt
         - res
           - layout
             - action_bar.xml
             - activity_main.xml
             - item_list_1.xml
             - item_list_rest.xml
           - values
             - strings.xml
         
1. Adapter: Contains the ItemAdapter class responsible for binding the data to the RecyclerView.
2. Data: Contains data classes representing the articles and their details.
3. Network: Includes the NewsService class for making API requests to fetch news articles.
4. Viewholder: Includes custom views to show the articles on the screen coming from the remote server.
5. ViewModel: Defines the NewsViewModel class that handles the data and business logic for the news articles.
6. MainActivity: The main entry point of the application, responsible for setting up the ViewModel and observing the data changes.

## Decisions Taken

In developing this project, the following decisions were made:

1. Architecture: The decision to use the MVVM (Model-View-ViewModel) architecture was made to separate the concerns of data management and user interface. This      architecture promotes testability, modularity, and maintainability by providing a clear separation of responsibilities.
2. Retrofit for Network Communication: Retrofit was chosen as the networking library for its simplicity, performance, and compatibility with the RESTful API used    in the project. It provides a clean and intuitive way to define API endpoints and handle network requests and responses.
3. Coil for Image Loading: Coil was selected as the image loading library due to its lightweight nature and excellent performance. It simplifies the process of      loading and caching images from URLs, ensuring fast and efficient image loading in the app.
4. LiveData for Data Observing: LiveData was chosen as the data observation mechanism in the ViewModel to enable reactive updates of the UI when data changes.        LiveData provides lifecycle-awareness, ensuring that UI components only receive updates when they are active, avoiding memory leaks and unnecessary UI updates.

## Project Scope
   The scope of this project is intentionally kept small to focus on a specific set of functionalities. As a result, certain features and functionalities that are    typically found in more comprehensive applications may not be implemented here.

   The decision to limit the scope allows for a more focused development approach, enabling quicker implementation and a simplified codebase. This project aims to    demonstrate specific concepts and showcase particular features without overwhelming complexity.

