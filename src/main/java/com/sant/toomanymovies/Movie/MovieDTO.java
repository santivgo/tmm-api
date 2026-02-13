package com.sant.toomanymovies.Movie;
import com.sant.toomanymovies.Category.CategoryDTO;
import com.sant.toomanymovies.Category.CategoryModel;
import com.sant.toomanymovies.UserMovieList.UserMovieListDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieDTO {
    private Long id;
    private String name;
    private String photoUrl;
    private List<CategoryDTO> categories;

}
