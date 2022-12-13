package com.distributedstudentgradingsystem.Users.Admin.Mapper;

import com.distributedstudentgradingsystem.Users.Admin.DTO.AddAdminRequestDTO;
import com.distributedstudentgradingsystem.Users.Admin.Entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper (nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin dtoToEntity(AddAdminRequestDTO addAdminRequestDTO);

}
