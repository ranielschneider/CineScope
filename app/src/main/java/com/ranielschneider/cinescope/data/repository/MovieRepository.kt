package com.ranielschneider.cinescope.data.repository

import com.ranielschneider.cinescope.data.remote.RetrofitClient

class MovieRepository {

    suspend fun getPopularMovies()=
        RetrofitClient.api.getPopularMovies()

}