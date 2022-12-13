package com.distributedstudentgradingsystem.Users.Expert.Repository;

import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertRepository extends JpaRepository<Expert,Long> {
}
