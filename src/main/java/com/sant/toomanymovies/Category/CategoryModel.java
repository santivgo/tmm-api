package com.sant.toomanymovies.Category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sant.toomanymovies.Movie.MovieModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@Table(name = "tb_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CategoryModel {
    @Id
    @NonNull
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "categories")
    private List<MovieModel> movies;

}
