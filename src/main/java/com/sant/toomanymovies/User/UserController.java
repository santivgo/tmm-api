package com.sant.toomanymovies.User;


import com.sant.toomanymovies.Category.CategoryDTO;
import com.sant.toomanymovies.Category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers(){
        List<UserResponseDTO> usersDTO = userService
                .getUsersList()
                .stream()
                .toList();
        return ResponseEntity.ok(usersDTO) ;
    }

    @GetMapping("/{id}")
    ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
        UserResponseDTO userDTO = userService.getUser(id);
        if (userDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO createUserResponse = userService.createUser(userRequestDTO);
        if (createUserResponse == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já cadastrada no banco.");
        }

        return ResponseEntity.status(201).body(createUserResponse);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }

}
