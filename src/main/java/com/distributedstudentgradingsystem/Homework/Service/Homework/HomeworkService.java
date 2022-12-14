package com.distributedstudentgradingsystem.Homework.Service.Homework;

import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import com.distributedstudentgradingsystem.utilities.Result;

import java.util.List;

public interface HomeworkService {

    Result addHomework(Homework homework);

    Homework getOneHomework(Long id);

    List<Homework> getAllHomeworksByClassID(Long id);

    List<Homework> getAllHomeworksByClassIDList(List<Long> idList);

    List<Homework> getAllHomeworksByExpertId(Long id);

    List<Homework> getAllHomeworksByCreatorId(Long id);
}
