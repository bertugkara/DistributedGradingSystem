package com.distributedstudentgradingsystem.Users.Expert.Service;

import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;

import java.util.List;
import java.util.Set;

public interface ExpertService {

    Expert findById(Long id);
    Set<Expert> findByIdList(List<Long> idList);
}
