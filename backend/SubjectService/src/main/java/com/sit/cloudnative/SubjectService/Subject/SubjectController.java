package com.sit.cloudnative.SubjectService.Subject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sit.cloudnative.SubjectService.TokenService;
import com.sit.cloudnative.SubjectService.exception.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SubjectController {

    @Autowired
    SubjectService subjectListService;
        
    @Autowired
    TokenService tokenService;

    Logger logger = LoggerFactory.getLogger(SubjectController.class);

    @GetMapping("/")
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<String>("Welcome to Subject Service", HttpStatus.OK);
    }
	
    @RequestMapping(value = "/curriculum/{curriculumId}/subjects", method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> getSubjectListByCurriculumId(@PathVariable("curriculumId") long curriculumId, 
                                                                      @RequestHeader("Authorization") String auth,
                                                                      HttpServletRequest request) {
        tokenService.validateToken(auth, request, logger);
        try {
            List<Subject> subjectList = subjectListService.getSubjectListByCurriculumId(curriculumId);
            return new ResponseEntity<>(subjectList, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "not found curriculum id (" + curriculumId + ")");
            throw new NotFoundException("curriculum " + curriculumId + " not found");
        }
    }

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable long subjectId, 
                                                  @RequestHeader("Authorization") String auth,
                                                  HttpServletRequest request) {
        tokenService.validateToken(auth, request, logger);
        try {
            Subject subject = subjectListService.getSubjectById(subjectId);
            return new ResponseEntity<>(subject, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "not found subject id (" + subjectId + ")");
            throw new NotFoundException("subject " + subjectId + " not found");
        }
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getSubjectList(@RequestParam String keyword, 
                                                        @RequestHeader("Authorization") String auth,
                                                        HttpServletRequest request) {
        tokenService.validateToken(auth, request, logger);
        try {
            List<Subject> subjectList = subjectListService.searchSubject(keyword.toLowerCase());
            logger.info(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "search "+keyword);
            return new ResponseEntity<>(subjectList, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "not found keyword for (" + keyword + ")");
            throw new NotFoundException("keyword " + keyword + " not found");
        }
    }

}
