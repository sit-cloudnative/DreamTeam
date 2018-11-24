package com.sit.cloudnative.SubjectService.Curriculum;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.sit.cloudnative.SubjectService.TokenService;
import com.sit.cloudnative.SubjectService.exception.BadRequestException;
import com.sit.cloudnative.SubjectService.exception.UnauthorizedException;
import java.util.List;
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

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CurriculumController {

    @Autowired
    CurriculumService curriculumService;
    
    @Autowired
    private TokenService tokenService;
    
    Logger logger = LoggerFactory.getLogger(CurriculumController.class);

    @GetMapping(value = "/curriculum/{curriculumId}")
    public ResponseEntity<Curriculum> getCurriculum(@PathVariable("curriculumId") long curriculumId, @RequestHeader("Authorization") String auth) {
        if (auth.isEmpty()) {
            throw new BadRequestException("Not have value in Authorization");
        }
        try {
            tokenService.checkToken(auth);
        } catch (JWTVerificationException e) {
            throw new UnauthorizedException(e.getMessage());
        }
        Curriculum curriculum = curriculumService.getCurriculumById(curriculumId);
        return new ResponseEntity<>(curriculum, HttpStatus.OK);
    }

    @GetMapping(value = "/curriculums")
    public ResponseEntity<List<Curriculum>> getCurriculumList(@RequestHeader("Authorization") String auth) {
        if (auth.isEmpty()) {
            throw new BadRequestException("Not have value in Authorization");
        }
        try {
            tokenService.checkToken(auth);
        } catch (JWTVerificationException e) {
            throw new UnauthorizedException(e.getMessage());
        }
        List<Curriculum> curriculum = curriculumService.getAllCurriculum();
        return new ResponseEntity<>(curriculum, HttpStatus.OK);
    }
}
