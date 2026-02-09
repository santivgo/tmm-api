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
    Long id;
    String nome;
    String username;
    String email;
    String senha;
    int idade;
    List<UserMovieListDTO> userLists;
}
