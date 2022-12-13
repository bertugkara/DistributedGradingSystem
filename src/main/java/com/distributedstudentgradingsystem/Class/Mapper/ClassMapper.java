package com.distributedstudentgradingsystem.Class.Mapper;

import com.distributedstudentgradingsystem.Class.DTO.AddPojoClassRequest;
import com.distributedstudentgradingsystem.Class.Entity.Class;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface ClassMapper {

    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    Class addDtoToEntity(AddPojoClassRequest addPojoClassRequest);
}
