package com.distributedstudentgradingsystem.Users.Admin.Service;

import com.distributedstudentgradingsystem.Users.Admin.Entity.Admin;
import com.distributedstudentgradingsystem.Users.Admin.Repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;
    @Override
    public Admin findById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
}
