package com.sit.cloudnative.SubjectListService.SubjectList;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SubjectListAdapter {

  public List<SubjectList> getSubjectDetail(long curriculumId){
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://ngelearning.sit.kmutt.ac.th/api/v0/program/"+curriculumId+"/subjects";
    List<SubjectList> subjectList = restTemplate.getForObject(url,List.class);
    return subjectList;
  }

}