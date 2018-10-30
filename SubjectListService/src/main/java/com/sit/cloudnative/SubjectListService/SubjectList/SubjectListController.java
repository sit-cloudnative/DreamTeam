package com.sit.cloudnative.SubjectListService.SubjectList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectListController {

    @Autowired
    SubjectListService subjectListService;

    @RequestMapping(value = "/subjectlist/curriculum/{curriculumId}", method = RequestMethod.GET)
    public ResponseEntity<List<SubjectList>> getSubject(@PathVariable("curriculumId") long curriculumId) {
        List<SubjectList> subjectList = subjectListService.getSubjectByName(curriculumId);
        return new ResponseEntity<>(subjectList, HttpStatus.OK);
    }

}
