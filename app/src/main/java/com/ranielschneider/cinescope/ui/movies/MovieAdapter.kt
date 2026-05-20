package com.ranielschneider.cinescope.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ranielschneider.cinescope.data.model.Movie
import com.ranielschneider.cinescope.databinding.ItemMovieBinding
import com.ranielschneider.cinescope.utils.Constants
import com.squareup.picasso.Picasso

class MovieAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.textTitle.text = movie.title ?: ""
        holder.binding.textReleaseDate.text = movie.release_date ?: ""
        holder.binding.textVoteAverage.text = "Nota: ${movie.vote_average ?: 0.0}"
        holder.binding.textOverview.text = movie.overview ?: ""
        Picasso.get()
            .load(Constants.IMAGE_BASE_URL + (movie.poster_path ?: ""))
            .into(holder.binding.imagePoster)
    }

    override fun getItemCount(): Int = movies.size
}