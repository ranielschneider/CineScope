package com.ranielschneider.cinescope.data.remote

import com.ranielschneider.cinescope.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "pt-BR",
        @Query("page") page: Int = 1
    ): MovieResponse
}