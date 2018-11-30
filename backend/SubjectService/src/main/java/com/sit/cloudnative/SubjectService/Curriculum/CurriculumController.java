package com.sit.cloudnative.SubjectService.Curriculum;

import com.sit.cloudnative.SubjectService.TokenService;
import com.sit.cloudnative.SubjectService.exception.NotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CurriculumController {

    @Autowired
    CurriculumService curriculumService;
    
    @Autowired
    private TokenService tokenService;
    
    Logger logger = LoggerFactory.getLogger(CurriculumController.class);

    @GetMapping(value = "/curriculum/{curriculumId}")
    public ResponseEntity<Curriculum> getCurriculum(@PathVariable("curriculumId") long curriculumId, 
                                                    @RequestHeader("Authorization") String auth, 
                                                    HttpServletRequest request) {
        tokenService.validateToken(auth, request, logger);
        try {
            Curriculum curriculum = curriculumService.getCurriculumById(curriculumId);
            return new ResponseEntity<>(curriculum, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "not found curriculum id (" + curriculumId + ")");
            throw new NotFoundException("curriculum " + curriculumId + " not found");
        }
    }

    @GetMapping(value = "/curriculums")
    public ResponseEntity<List<Curriculum>> getCurriculumList(@RequestHeader("Authorization") String auth,
                                                              HttpServletRequest request) {
        tokenService.validateToken(auth, request, logger);
        try {
            List<Curriculum> curriculum = curriculumService.getAllCurriculum();
            return new ResponseEntity<>(curriculum, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "empty curriculum in database");
            throw new NotFoundException("database does not have any curriculum");
        }
    }

}
