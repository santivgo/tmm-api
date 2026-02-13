package com.sant.toomanymovies.User;

import com.sant.toomanymovies.UserMovieList.UserMovieListDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    public UserDTO(String nome, String username, String email, int idade) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.idade = idade;
    }

    private Long id;
    private String nome;
    private String username;
    private String email;
    private String senha;
    private int idade;
    private List<UserMovieListDTO> userLists;
}
