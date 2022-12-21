package com.distributedstudentgradingsystem.Users.Admin.Mapper;

import com.distributedstudentgradingsystem.Users.Admin.DTO.AddAdminRequestDTO;
import com.distributedstudentgradingsystem.Users.Admin.DTO.AdminPojoResponseDTO;
import com.distributedstudentgradingsystem.Users.Admin.Entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper (nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, componentModel = "spring")
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin dtoToEntity(AddAdminRequestDTO addAdminRequestDTO);
    @Mapping(source = "email", target = "email")
    AdminPojoResponseDTO entityToResponseDTO(Admin admin);

}
