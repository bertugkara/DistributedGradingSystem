package com.distributedstudentgradingsystem.Users.Admin.Service;

import com.distributedstudentgradingsystem.Class.DTO.UserInformationForClassCreatingResponse;
import com.distributedstudentgradingsystem.Users.Admin.Entity.Admin;
import com.distributedstudentgradingsystem.Users.Admin.Repository.AdminRepository;
import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import com.distributedstudentgradingsystem.Users.Expert.Service.ExpertService;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Student.Service.StudentService;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.Users.Teacher.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final ExpertService expertService;

    @Override
    public Admin findById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public UserInformationForClassCreatingResponse getUserInformationForCreatingClass() {
        List<Student> pojoStudentResponseDTOList = studentService.findAllStudents();
        List<Teacher> pojoTeacherResponseDTOList = teacherService.findAllTeachersAndConvertToResponseDTO();
        List<Expert> pojoExpertResponseDTOList = expertService.findAllExperts();

        UserInformationForClassCreatingResponse classUserInformationResponseDTO = new UserInformationForClassCreatingResponse();

        classUserInformationResponseDTO.setExpertResponseDTOList(pojoExpertResponseDTOList);
        classUserInformationResponseDTO.setStudentResponseDTOList(pojoStudentResponseDTOList);
        classUserInformationResponseDTO.setTeacherResponseDTOList(pojoTeacherResponseDTOList);
        return classUserInformationResponseDTO;
    }

}
