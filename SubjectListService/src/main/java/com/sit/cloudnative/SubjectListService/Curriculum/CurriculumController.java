package com.sit.cloudnative.SubjectListService.curriculum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurriculumController {

    @Autowired
    CurriculumService curriculumService;

    @GetMapping(value = "/curriculum/{curriculumId}")
    public ResponseEntity<Curriculum> getCurriculum(@PathVariable("curriculumId") long curriculumId) {
        Curriculum curriculum = curriculumService.getCurriculumById(curriculumId);
        return new ResponseEntity<>(curriculum, HttpStatus.OK);
    }

    @GetMapping(value = "/curriculum")
    public ResponseEntity<List<Curriculum>> getCurriculumList() {
        List<Curriculum> curriculum = curriculumService.getAllCurriculum();
        return new ResponseEntity<>(curriculum, HttpStatus.OK);
    }
}
