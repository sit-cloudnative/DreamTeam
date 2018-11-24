package com.sit.cloudnative.SubjectService.Subject;

import java.util.List;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.sit.cloudnative.SubjectService.TokenService;
import com.sit.cloudnative.SubjectService.exception.BadRequestException;
import com.sit.cloudnative.SubjectService.exception.NotFoundException;
import com.sit.cloudnative.SubjectService.exception.UnauthorizedException;

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

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SubjectController {

    @Autowired
    SubjectService subjectListService;

    @Autowired
    TokenService tokenService;

    Logger logger = LoggerFactory.getLogger(SubjectController.class);

    @RequestMapping(value = "/curriculum/{curriculumId}/subjectlist", method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> getSubjectListByCurriculumId(@PathVariable("curriculumId") long curriculumId) {
        logger.info("Get list of Subjects from curriculum ID = " + curriculumId);
        List<Subject> subjectList = subjectListService.getSubjectListByCurriculumId(curriculumId);
        return new ResponseEntity<>(subjectList, HttpStatus.OK);
    }

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable long subjectId) {
        logger.info("Get Subject by ID = " + subjectId);
        Subject subject = subjectListService.getSubjectById(subjectId);
        if(subject == null ){
            throw new NotFoundException("subjct not found");
        }
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getSubjectList(@RequestParam String keyword, @RequestHeader("Authorization") String auth) {
        if (auth.isEmpty()) {
            throw new BadRequestException("Not have value in Authorization");
        }
        try {
            tokenService.checkToken(auth);
            List<Subject> subjectList = subjectListService.searchSubject(keyword.toLowerCase());
            logger.info("Searching for " + keyword);
            return new ResponseEntity<>(subjectList, HttpStatus.OK);
        } catch (JWTVerificationException e) {
            throw new UnauthorizedException(e.getMessage());
        } catch (Exception e) {
            throw new NotFoundException(keyword + ": Keyword is not found");
        }
    }
    

}
