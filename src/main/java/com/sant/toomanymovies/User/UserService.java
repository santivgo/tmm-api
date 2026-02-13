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
    public List<UserDTO> getUsersList(){
        return userRepository.findAll().stream().map(userMapper::map).toList();
    }

    public UserDTO createUser(UserDTO user) {
        UserModel convertedUser = userMapper.map(user);
        UserModel savedUser = userRepository.save(convertedUser);
        return userMapper.map(savedUser);
    }

    /// CREATE

    public UserDTO getUser(Long id){
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.map(userMapper::map).orElse(null);

    }

    /// UPDATE

    public UserDTO updateUser(long id, UserDTO partialUser){
        UserModel searchedUser = userRepository.findById(id).orElse(null);
        if (searchedUser == null) return null;

        searchedUser.setEmail(partialUser.getEmail());
        searchedUser.setNome(partialUser.getNome());
        searchedUser.setUsername(partialUser.getUsername());
        searchedUser.setIdade(partialUser.getIdade());
        searchedUser = userRepository.save(searchedUser);
        return userMapper.map(searchedUser);
    }

    ///  DELETE

    public void deleteUser(long id){
        userRepository.findById(id).ifPresent(foundUser -> userRepository.deleteById(id));


    }

}
