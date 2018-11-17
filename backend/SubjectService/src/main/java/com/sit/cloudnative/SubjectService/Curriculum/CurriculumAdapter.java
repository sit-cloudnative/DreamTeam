package com.sit.cloudnative.SubjectService.Curriculum;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurriculumAdapter {

    public Curriculum getProgramDetail(long programId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ngelearning.sit.kmutt.ac.th/api/v0/program/" + programId;
        Curriculum curriculum = restTemplate.getForObject(url, Curriculum.class);
        return curriculum;
    }

    public Curriculum[] getProgramList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ngelearning.sit.kmutt.ac.th/api/v0/program/";
        Curriculum[] curriculumList = restTemplate.getForObject(url, Curriculum[].class);
        return curriculumList;
    }

}
