package com.sant.toomanymovies.UserMovieList;


import com.sant.toomanymovies.Movie.MovieModel;
import com.sant.toomanymovies.User.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_user_list")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMovieListModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserModel owner;


    @ManyToMany
    @JoinTable(name="tb_movie_list")
    private List<MovieModel> UserMoviesList;
}
