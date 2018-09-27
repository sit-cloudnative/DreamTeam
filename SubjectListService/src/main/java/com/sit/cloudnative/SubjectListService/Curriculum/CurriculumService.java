package com.sit.cloudnative.SubjectListService.curriculum;

import java.util.List;

import com.sit.cloudnative.SubjectListService.adapter.ProgramAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumService implements CurriculumServiceInterface {

    @Autowired
    ProgramAdapter programAdapter;

    @Override
    public Curriculum getCurriculumById(long curriculumId) {
        Curriculum curriculum = programAdapter.getProgramDetail(curriculumId);
        return curriculum;
    }

    @Override
    public List<Curriculum> getAllCurriculum() {
		return null;
	}


}