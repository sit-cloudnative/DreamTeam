package com.sit.cloudnative.SubjectService.Subject;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SubjectAdapter {

    public List<Subject> getSubjectListByCurriculumId(long curriculumId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ngelearning.sit.kmutt.ac.th/api/v0/program/" + curriculumId + "/subjects";
        Subject[] subjectList = restTemplate.getForObject(url, Subject[].class);
        return Arrays.asList(subjectList);
    }

    public Subject getSubjectBySubjectId(long subjectId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ngelearning.sit.kmutt.ac.th/api/v0/subject/" + subjectId;
        Subject subject = restTemplate.getForObject(url, Subject.class);
        return subject;
    }
}
