package com.sant.toomanymovies.User;

import com.sant.toomanymovies.UserMovieList.UserMovieListDTO;
import java.util.List;

public record UserResponseDTO (Long id, String nome, String username,
                               String email, int idade, List<UserMovieListDTO> userLists
){}
