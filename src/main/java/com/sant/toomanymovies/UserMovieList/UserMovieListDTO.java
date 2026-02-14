package com.sant.toomanymovies.UserMovieList;

import com.sant.toomanymovies.Movie.MovieDTO;
import com.sant.toomanymovies.User.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMovieListDTO {
    Long id;
    String name;
    UserModel owner;
    List<MovieDTO> UserMoviesList;
}
