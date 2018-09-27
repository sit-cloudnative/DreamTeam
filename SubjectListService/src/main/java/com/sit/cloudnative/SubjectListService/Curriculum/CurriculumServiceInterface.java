package com.sit.cloudnative.SubjectListService.curriculum;

import java.util.List;

public interface CurriculumServiceInterface {

    Curriculum getCurriculumById(long curriculumId);

    List<Curriculum> getAllCurriculum();
    
}