package com.sant.toomanymovies.Movie;

import com.sant.toomanymovies.Category.CategoryModel;
import com.sant.toomanymovies.UserMovieList.UserMovieListModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name="tb_movies")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieModel {
    @Id
    private Long id;
    private String name;
    private String photoUrl;

    @ManyToMany
    @JoinTable(name="categories_ids")
    List<CategoryModel> categories;

    @ManyToMany
    List<UserMovieListModel> userLists;


}
