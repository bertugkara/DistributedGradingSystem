package com.distributedstudentgradingsystem.Users.Expert.Mapper;

import com.distributedstudentgradingsystem.Users.Expert.DTO.PojoExpertResponseDTO;
import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL ,
        componentModel = "spring")
public interface ExpertMapper {

    ExpertMapper INSTANCE = Mappers.getMapper(ExpertMapper.class);

    PojoExpertResponseDTO entityToDTO(Expert expert);

}
