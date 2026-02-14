package com.sant.toomanymovies.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO map(UserModel userModel);
    UserModel map(UserDTO userModel);

}
