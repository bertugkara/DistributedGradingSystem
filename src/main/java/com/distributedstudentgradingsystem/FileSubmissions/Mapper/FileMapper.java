package com.distributedstudentgradingsystem.FileSubmissions.Mapper;


import com.distributedstudentgradingsystem.FileSubmissions.DTO.FileResponseDTO;
import com.distributedstudentgradingsystem.FileSubmissions.Service.FileService;
import com.distributedstudentgradingsystem.FileSubmissions.entity.File;
import com.distributedstudentgradingsystem.Users.Student.Mapper.StudentMapper;
import com.distributedstudentgradingsystem.Users.Student.Service.StudentService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {StudentService.class, FileService.class,
        StudentMapper.class})
public abstract class FileMapper {

   @Autowired
   protected FileService fileService;

   @Mapping(target = "url" , expression = "java(fileService.getFileUrl(file))")
   @Mapping(target = "id" , source = "id")
   public abstract FileResponseDTO entityToDTO(File file);
   public abstract List<FileResponseDTO> entityListToDtoList(List<File> file);

}
