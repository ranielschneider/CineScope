package com.ranielschneider.cinescope.data.repository

import com.ranielschneider.cinescope.data.remote.RetrofitClient
import com.ranielschneider.cinescope.utils.Constants

class MovieRepository {

    suspend fun getPopularMovies() =
        RetrofitClient.api.getPopularMovies(Constants.API_KEY)
}