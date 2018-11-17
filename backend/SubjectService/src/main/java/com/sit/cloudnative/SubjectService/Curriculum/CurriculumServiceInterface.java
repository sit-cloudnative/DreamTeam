package com.sit.cloudnative.SubjectService.Curriculum;

import java.util.List;

public interface CurriculumServiceInterface {

    Curriculum getCurriculumById(long curriculumId);

    List<Curriculum> getAllCurriculum();

}
