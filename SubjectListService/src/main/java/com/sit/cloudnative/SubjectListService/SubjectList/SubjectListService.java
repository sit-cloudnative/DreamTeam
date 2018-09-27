package com.sit.cloudnative.SubjectListService.SubjectList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectListService{
    @Autowired
    private SubjectListAdapter subjectAdap;
   
    public List<SubjectList> getSubjectByName(long curriculumId){
        List<SubjectList> subjectList = subjectAdap.getSubjectDetail(curriculumId);
        return subjectList;
      }
   
}