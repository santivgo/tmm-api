package com.sant.toomanymovies.Movie;

import org.mapstruct.Mapper;

@Mapper
public interface MovieMapper {
    MovieDTO map(MovieModel movieModel);
    MovieModel map(MovieDTO movieDTO);
}
