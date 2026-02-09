package com.sant.toomanymovies.Movie;
import com.sant.toomanymovies.Category.CategoryModel;
import com.sant.toomanymovies.UserMovieList.UserMovieListDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    Long id;
    String name;
    String photoUrl;
    List<CategoryModel> categories;
    List<UserMovieListDTO> userLists;

}
