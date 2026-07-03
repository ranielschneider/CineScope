# CineScope 🎬

Built this to learn how REST APIs work on Android. It pulls popular movies from TMDB and shows them in a list — poster, title, rating, synopsis.

## ✨ Features

- Fetches popular movies from The Movie Database (TMDB)
- Displays poster, title, rating and synopsis in a card-based list
- Secure API credentials handling via `local.properties` + `BuildConfig` (never committed to Git)

## 🛠 Stack

Kotlin, Retrofit, OkHttp, Picasso, Coroutines, ViewBinding

## 🚀 Running locally

You'll need a free [TMDB](https://www.themoviedb.org/) account. Once you have your API key and Read Access Token, add them to `local.properties` at the project root:

```properties
tmdb_api_key=YOUR_API_KEY_HERE
tmdb_token=YOUR_READ_ACCESS_TOKEN_HERE
```

> ⚠️ `local.properties` is git-ignored by default — never commit your real credentials.

Then:

1. Clone the repository:
   ```bash
   git clone https://github.com/ranielschneider/CineScope.git
   ```
2. Open it in Android Studio and let Gradle sync.
3. Run on an emulator or physical device (minSdk 24+).

The app will load the list of popular movies from TMDB on launch.

## 👤 Author

**Raniel Schneider**
[GitHub](https://github.com/ranielschneider) · [LinkedIn](https://linkedin.com/in/raniel-schneider-79006b50)
