package com.sit.cloudnative.SubjectListService.adapter;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class ProgramAdapter {
    public Program getProgramDetail(long programId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ngelearning.sit.kmutt.ac.th/api/v0/program/" + programId;
        Program program = restTemplate.getForObject(url, Program.class);
        return program;
    }

}