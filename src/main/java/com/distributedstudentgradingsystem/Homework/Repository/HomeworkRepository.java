package com.distributedstudentgradingsystem.Homework.Repository;

import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface HomeworkRepository extends JpaRepository<Homework,Long> {

    List<Homework> findAllByLesson_Id(Long id);

    List<Homework> findAllByCreator_Id(Long id);

    List<Homework> findAllByExpert_Id(Long id);

}
