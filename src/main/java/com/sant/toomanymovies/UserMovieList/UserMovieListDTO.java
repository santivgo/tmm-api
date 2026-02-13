package com.sant.toomanymovies.UserMovieList;

import com.sant.toomanymovies.Movie.MovieDTO;
import com.sant.toomanymovies.User.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class UserMovieListDTO {
    private final Long id;
    private final String name;
    private final UserModel owner;
    private final List<MovieDTO> UserMoviesList;
}
