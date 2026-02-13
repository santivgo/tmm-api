package com.sant.toomanymovies.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO responseMap(UserModel userModel);

    UserRequestDTO requestMap(UserModel userModel);

    UserModel map(UserResponseDTO userResponseDTO);
    UserModel map(UserRequestDTO userRequestDTO);

}
