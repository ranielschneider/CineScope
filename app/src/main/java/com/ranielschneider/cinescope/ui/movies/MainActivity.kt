package com.ranielschneider.cinescope.ui.movies

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ranielschneider.cinescope.data.repository.MovieRepository
import com.ranielschneider.cinescope.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val repository = MovieRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerMovies.layoutManager = LinearLayoutManager(this)
        loadMovies()
    }

    private fun loadMovies() {
        lifecycleScope.launch {
            try {
                val response = repository.getPopularMovies()
                Log.d("CineScope", "HTTP: ${response.code()}")
                if (response.isSuccessful) {
                    val movies = response.body()?.results ?: emptyList()
                    if (movies.isEmpty()) {
                        Toast.makeText(this@MainActivity, "Nenhum filme encontrado.", Toast.LENGTH_LONG).show()
                    } else {
                        binding.recyclerMovies.adapter = MovieAdapter(movies)
                    }
                } else {
                    val msg = "Erro na API: ${response.code()} ${response.message()}"
                    Log.e("CineScope", msg)
                    Toast.makeText(this@MainActivity, msg, Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                val msg = "Sem conexão ou erro de rede: ${e.message}"
                Log.e("CineScope", msg, e)
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_LONG).show()
            }
        }
    }
}