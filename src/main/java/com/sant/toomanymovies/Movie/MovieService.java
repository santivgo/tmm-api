package com.sant.toomanymovies.Movie;


import org.springframework.stereotype.Service;

@Service

public class MovieService {

    MovieRepository movieRepository;
    MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }


    public MovieDTO createMovie(MovieDTO movieDTO){

        MovieModel createdMovie = this.movieMapper.map(movieDTO);
        createdMovie = this.movieRepository.save(createdMovie);
        return this.movieMapper.map(createdMovie);

    }

}
