package com.sant.toomanymovies.User;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    ///  READ
    public List<UserResponseDTO> getUsersList(){
        return userRepository.findAll().stream().map(userMapper::responseMap).toList();
    }

    public UserResponseDTO createUser(UserRequestDTO user) {
        UserModel convertedUser = userMapper.map(user);
        UserModel savedUser = userRepository.save(convertedUser);
        return userMapper.responseMap(savedUser);
    }

    /// CREATE

    public UserResponseDTO getUser(Long id){
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.map(userMapper::responseMap).orElse(null);

    }

    /// UPDATE

    public UserResponseDTO updateUser(long id, UserRequestDTO partialUser){
        UserModel searchedUser = userRepository.findById(id).orElse(null);
        if (searchedUser == null) return null;

        searchedUser.setEmail(partialUser.email());
        searchedUser.setNome(partialUser.nome());
        searchedUser.setUsername(partialUser.username());
        searchedUser.setIdade(partialUser.idade());
        searchedUser = userRepository.save(searchedUser);
        return userMapper.responseMap(searchedUser);
    }

    ///  DELETE

    public void deleteById(long id){
        userRepository.findById(id).ifPresent(foundUser -> userRepository.deleteById(id));


    }

}
