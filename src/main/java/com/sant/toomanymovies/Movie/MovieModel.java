package com.sant.toomanymovies.Movie;

import com.sant.toomanymovies.Category.CategoryModel;
import com.sant.toomanymovies.UserMovieList.UserMovieListModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="tb_movies")

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class MovieModel {
    @Id
    @NonNull
    private Long id;
    @NonNull
    private String name;
    private String photoUrl;

    @ManyToMany
    @JoinTable(name="tb_categories_ids")
    List<CategoryModel> categories;

    @ManyToMany
    List<UserMovieListModel> userLists;


}
