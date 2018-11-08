package com.sit.cloudnative.SubjectListService.Curriculum;

import java.util.List;

public interface CurriculumServiceInterface {

    Curriculum getCurriculumById(long curriculumId);

    List<Curriculum> getAllCurriculum();

}
