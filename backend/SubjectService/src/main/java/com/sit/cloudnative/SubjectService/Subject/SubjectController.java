package com.sit.cloudnative.SubjectService.Subject;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SubjectController {

    @Autowired
    SubjectService subjectListService;

    @RequestMapping(value = "/curriculum/{curriculumId}/subjectlist", method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> getSubjectListByCurriculumId(@PathVariable("curriculumId") long curriculumId) {
        List<Subject> subjectList = subjectListService.getSubjectListByCurriculumId(curriculumId);
        return new ResponseEntity<>(subjectList, HttpStatus.OK);
    }

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable long subjectId) {
        return new ResponseEntity<>(subjectListService.getSubjectById(subjectId), HttpStatus.OK);
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getSubjectList(@RequestParam String keyword) {
        return new ResponseEntity<>(subjectListService.searchSubject(keyword.toLowerCase()), HttpStatus.OK);
    }

}
