package com.sant.toomanymovies.User;

import lombok.Data;
import lombok.Getter;


public record UserRequestDTO(Long id, String nome, String username,
                             String email, String senha, int idade) {
}
