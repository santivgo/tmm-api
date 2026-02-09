package com.sant.toomanymovies.Category;

import com.sant.toomanymovies.Movie.MovieModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {
    @Id
    Long id;
    String nome;
    @ManyToMany(mappedBy = "categories")
    List<MovieModel> movies;
}
