package com.distributedstudentgradingsystem.Users.Admin.Service;

import com.distributedstudentgradingsystem.Class.DTO.UserInformationForClassCreatingResponse;
import com.distributedstudentgradingsystem.Users.Admin.Entity.Admin;

public interface AdminService {

    Admin findById(Long id);

    UserInformationForClassCreatingResponse getUserInformationForCreatingClass();
}
