package com.sant.toomanymovies.User;


import com.sant.toomanymovies.UserMovieList.UserMovieListModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String nome;
    @Column(unique = true, nullable = false, updatable = false)
    String username;
    @Column(unique = true, nullable = false, updatable = false)
    String email;
    String senha;
    int idade;

    @OneToMany(mappedBy = "owner")
    List<UserMovieListModel> userLists;



}
