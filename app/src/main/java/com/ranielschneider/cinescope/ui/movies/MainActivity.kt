package com.ranielschneider.cinescope.ui.movies

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.ranielschneider.cinescope.R
import com.ranielschneider.cinescope.data.repository.MovieRepository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val repository = MovieRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            try {
                val response = repository.getPopularMovies()
                Log.d("CineScope", "Filmes recebidos: ${response.results.size}")
                Log.d("CineScope","Primeiro filme: ${response.results.firstOrNull()?.title}")
            }catch (e: Exception) {
                Log.e("CineScope", "Erro ao buscar filmes", e)
            }
        }

    }
}