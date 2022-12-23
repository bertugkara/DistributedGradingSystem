package com.distributedstudentgradingsystem.Homework.Service.Homework;

import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import com.distributedstudentgradingsystem.Homework.Repository.HomeworkRepository;
import com.distributedstudentgradingsystem.Homework.Repository.HomeworkSubmissionRepository;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;
    private final HomeworkSubmissionRepository homeworkSubmissionRepository;

    @Override
    public Result addHomework(Homework homework) {
        if (homework != null) return new Result(homeworkRepository.save(homework) != null);
        return null;
    }

    @Override
    public Homework getOneHomework(Long id) {
        return homeworkRepository.findById(id).orElse(null);
    }

    @Override
    public List<Homework> getAllHomeworksByClassID(Long id) {
        if (id != null) return homeworkRepository.findAllByLesson_Id(id);
        return null;
    }

    @Override
    public List<Homework> getAllHomeworksByClassIDList(List<Long> idList) {
        if (!idList.isEmpty()) return homeworkRepository.findAllByLessonIdIn(idList);
        return null;
    }

    @Override
    public List<Homework> getAllHomeworksByExpertId(Long id) {
        if (id != null) {
            return homeworkRepository.findAllByExpert_Id(id);
        }
        return null;
    }

    @Override
    public List<Homework> getAllHomeworksByCreatorId(Long id) {
        if (id != null) {
            homeworkRepository.findById(id).orElse(null);
        }
        return null;
    }

}
