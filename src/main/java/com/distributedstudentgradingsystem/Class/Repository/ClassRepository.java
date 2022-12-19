package com.distributedstudentgradingsystem.Class.Repository;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class,Long> {
}