package com.sit.cloudnative.SubjectService.Subject;

import com.sit.cloudnative.SubjectService.Curriculum.Curriculum;
import com.sit.cloudnative.SubjectService.Curriculum.CurriculumService;
import com.sit.cloudnative.SubjectService.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class SubjectService {

    @Autowired
    private SubjectAdapter subjectAdapter;

    @Autowired
    private CurriculumService curriculumService;

    public List<Subject> getSubjectListByCurriculumId(long curriculumId) {
        List<Subject> subjectList = new ArrayList<Subject>();
        try{
            subjectAdapter.getSubjectListByCurriculumId(curriculumId);
        }catch(HttpClientErrorException httpException){
            throw new NotFoundException("target curriculumn id \'" + curriculumId + "\' is not found");
        }
        return subjectList;
    }

    public Subject getSubjectById(long subjectId) {
        Subject subject = new Subject();
        try{
            subject = subjectAdapter.getSubjectBySubjectId(subjectId);
        }catch(HttpClientErrorException httpException){
            throw new NotFoundException("target subject id \'" + subjectId + "\' is not found");
        }
        return subject;
    }

    public List<Subject> searchSubject(String keyword) {
        List<Curriculum> curriculums = curriculumService.getAllCurriculum();
        List<Subject> subjects = new ArrayList<>();
        List<Subject> keywordSubject = new ArrayList<>();
        for (Curriculum curriculum : curriculums) {
            subjects.addAll(subjectAdapter.getSubjectListByCurriculumId(curriculum.getCurriculumId()));
        }
        for (Subject subject : subjects) {
            if (subject.getSubjectCode().toLowerCase().contains(keyword) || subject.getSubjectName().toLowerCase().contains(keyword)) {
                keywordSubject.add(subject);
            }
        }

        return keywordSubject;
    }

}
