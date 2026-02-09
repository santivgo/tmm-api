package com.sant.toomanymovies.UserMovieList;

import com.sant.toomanymovies.Movie.MovieRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMovieListRepository extends JpaRepository<MovieRepository, Long> {
}
