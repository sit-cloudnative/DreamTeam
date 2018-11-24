package com.sit.cloudnative.SubjectService.Curriculum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sit.cloudnative.SubjectService.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class CurriculumService implements CurriculumServiceInterface {

    @Autowired
    CurriculumAdapter curriculumAdapter;

    @Override
    public Curriculum getCurriculumById(long curriculumId) {
        Curriculum curriculum = new Curriculum();
        try{
            curriculum = curriculumAdapter.getProgramDetail(curriculumId); 
        }catch(HttpClientErrorException httpException){
            throw new NotFoundException("target curriculumn id \'" + curriculumId + "\' is not found");
        }
        return curriculum;
    }

    @Override
    public List<Curriculum> getAllCurriculum() {
        List<Curriculum> curriculum = new ArrayList<>();
        try{
            curriculum = Arrays.asList(curriculumAdapter.getProgramList());
        }catch(HttpClientErrorException httpException){
            throw new NotFoundException("curriculumns are not found");
        }
        return curriculum;
    }

}
