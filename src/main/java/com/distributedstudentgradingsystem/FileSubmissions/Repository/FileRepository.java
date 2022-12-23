package com.distributedstudentgradingsystem.FileSubmissions.Repository;

import com.distributedstudentgradingsystem.FileSubmissions.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FileRepository extends JpaRepository<File,Long> {
}
