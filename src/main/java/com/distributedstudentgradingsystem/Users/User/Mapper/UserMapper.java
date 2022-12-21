package com.distributedstudentgradingsystem.Users.User.Mapper;


import com.distributedstudentgradingsystem.Users.User.DTO.UserResponseDTO;
import com.distributedstudentgradingsystem.Users.User.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "role", source="roleSet")
    UserResponseDTO entityToDto(User user);

    List<UserResponseDTO> entityListToDtoList(List<User> userList);
}
