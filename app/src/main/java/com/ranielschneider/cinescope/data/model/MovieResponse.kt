package com.ranielschneider.cinescope.data.model

data class MovieResponse(
    val page: Int? = null,
    val results: List<Movie>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)