# Crypto Coins App

A simple Android app to display cryptocurrency information using the CoinPaprika API. The app follows Clean Architecture principles and uses the MVVM pattern.

## Project Overview

This app fetches and displays information about cryptocurrencies, including their logos, names, symbols, and additional details. 
The app is designed using Clean Architecture, because i was exploring/learning that. It actually dont need because is small app, but on bigger projects with we can ensure a modular and scalable codebase.
With this app i learn to structure with domain, data and presentation layers. Now i can use on my future android apps to be more scalable and modular.




<img src="https://github.com/user-attachments/assets/cb087ed2-d266-4508-b139-3178c0cd13bf" alt="Screenshot 1" width="300"/>
<img src="https://github.com/user-attachments/assets/e9da6b0a-ffff-43b8-91ad-77a29ca640cd" alt="Screenshot 1" width="300"/>


## Architecture

### Clean Architecture

- **Presentation Layer**
  - **UI**: Composed of Jetpack Compose UI components.
  - **View Models**: Manage UI-related data and handle user interactions.

- **Domain Layer**
  - **Business Logic**: Encapsulated in use cases that define the operations the app can perform.
  - **Interface Definitions**: Define repositories that abstract the data source operations.
  - **Model Classes**: Represent the core business models.

- **Data Layer**
  - **Repository Implementation**: Concrete implementation of repository interfaces.
  - **DTO**: Data Transfer Objects that directly map to the API response.
  - **API**: Handles API calls to the CoinPaprika service.

### MVVM Pattern

The app uses the Model-View-ViewModel (MVVM) pattern to separate concerns and manage the UI state effectively.

### Use Cases

Use cases are implemented in the domain layer to encapsulate the application's business logic. They define specific operations that the app performs, such as:

- **Fetch Coin Details**: Retrieves detailed information about a specific cryptocurrency.
- **List Coins**: Fetches a list of available cryptocurrencies from the API.

These use cases interact with repositories to perform data operations and provide the results to the View Models.

## Dependencies

- **Jetpack Compose**: For building the UI.
- **Coil**: For image loading.
- **Hilt**: For dependency injection.

## Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/crypto-coins-app.git
   ```

2. **Open the Project**

   Open the project in Android Studio.

3. **Sync Gradle**

   Make sure to sync the project with Gradle to download all dependencies.

4. **Run the App**

   Run the app on an emulator or physical device.

## Usage

1. **Launch the App**

   Open the app, and you will see a list of cryptocurrencies fetched from CoinPaprika.

2. **View Coin Details**

   Tap on a coin to view its detailed information, including the coin’s description, tags, and team members.

## API

The app uses the CoinPaprika API for fetching cryptocurrency data. For more information about the API endpoints and data structure, visit [CoinPaprika API Documentation](https://api.coinpaprika.com/).

## Contributing

Feel free to contribute to this project by submitting pull requests or opening issues. For any questions or suggestions, please contact [your-email@example.com](mailto:jlpmartins98@gmail.com).

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
