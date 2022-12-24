package com.distributedstudentgradingsystem.Users.Expert.Service;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Class.Service.ClassService;
import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import com.distributedstudentgradingsystem.Homework.Service.Homework.HomeworkService;
import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import com.distributedstudentgradingsystem.Users.Expert.Entity.ExpertProfile;
import com.distributedstudentgradingsystem.Users.Expert.Repository.ExpertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExpertServiceImpl implements ExpertService {

    private final ExpertRepository expertRepository;
    private final ClassService classService;
    private final HomeworkService homeworkService;

    @Override
    public Expert findById(Long id) {
        if (id != null) {
            return expertRepository.findById(id).orElse(null);
        }
        return null;
    }

    public Set<Expert> findByIdList(List<Long> idList) {
        if (idList != null && !idList.isEmpty()) {
            return new HashSet<>(expertRepository.findAllById(idList));
        }
        return null;
    }

    @Override
    public List<Expert> findAllExperts() {
        return expertRepository.findAll();
    }

    @Override
    public ExpertProfile whoAmI(Long id) {
        Expert expert = expertRepository.findById(id).orElse(null);
        List<Class> classList = classService.getClassesByExpertId(id);
        List<Homework> homeworkList = homeworkService.getAllHomeworksByExpertId(id);
        ExpertProfile expertProfile = ExpertProfile.fromExpert(expert,classList,homeworkList);
        return expertProfile;
    }
}
