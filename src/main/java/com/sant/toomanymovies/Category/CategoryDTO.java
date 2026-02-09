package com.sant.toomanymovies.Category;

import com.sant.toomanymovies.Movie.MovieModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    Long id;
    String nome;
    List<MovieModel> movies;
}
