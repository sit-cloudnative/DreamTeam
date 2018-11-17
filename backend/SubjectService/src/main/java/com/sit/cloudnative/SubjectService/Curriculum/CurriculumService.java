package com.sit.cloudnative.SubjectService.Curriculum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumService implements CurriculumServiceInterface {

    @Autowired
    CurriculumAdapter curriculumAdapter;

    @Override
    public Curriculum getCurriculumById(long curriculumId) {
        Curriculum curriculum = curriculumAdapter.getProgramDetail(curriculumId);
        return curriculum;
    }

    @Override
    public List<Curriculum> getAllCurriculum() {
        Curriculum[] curriculum = curriculumAdapter.getProgramList();
        return new ArrayList<>(Arrays.asList(curriculum));
    }

}
