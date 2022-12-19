package com.distributedstudentgradingsystem.Users.Expert.Service;

import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
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
}
