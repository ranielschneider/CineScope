package com.ranielschneider.cinescope.utils

import com.ranielschneider.cinescope.BuildConfig

object Constants {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
    const val LANGUAGE = "pt-BR"
    val TOKEN: String = BuildConfig.TMDB_TOKEN
    val API_KEY: String = BuildConfig.TMDB_API_KEY
}