package com.sit.cloudnative.SubjectService.service;

import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.sit.cloudnative.SubjectService.Curriculum.Curriculum;
import com.sit.cloudnative.SubjectService.Curriculum.CurriculumService;
import com.sit.cloudnative.SubjectService.Subject.Subject;
import com.sit.cloudnative.SubjectService.Subject.SubjectAdapter;
import com.sit.cloudnative.SubjectService.Subject.SubjectService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes=SubjectService.class)
public class SubjectServiceUnitTest {

    private SubjectService subjectService;

    @Mock
    private CurriculumService curriculumService;
    @Mock
    private SubjectAdapter subjectAdapter;
    private List<Curriculum> curriculums;
    private List<Subject> subjectsIT;
    private List<Subject> subjectsCS;

    @Before
    public void setUp() {
        this.subjectService = new SubjectService(curriculumService, subjectAdapter);

        curriculums = new ArrayList<>();
        curriculums.add(new Curriculum(1, "Information Technology", "IT", "Thai"));
        curriculums.add(new Curriculum(2, "Computer Science", "CS", "Inter"));

        subjectsIT = new ArrayList<>();
        subjectsIT.add(new Subject(1, "ComPro", "IT Programing", "INT102"));
        subjectsIT.add(new Subject(2, "Discrete", "ITMath", "INT104"));

        subjectsCS = new ArrayList<>();
        subjectsCS.add(new Subject(1, "ComPro", "CS Programing", "CSC102"));
        subjectsCS.add(new Subject(2, "Discrete", "CSMath", "CSC104"));
    }

    @Test
    public void searchSubject() {
        when(curriculumService.getAllCurriculum()).thenReturn(curriculums);
        when(subjectAdapter.getSubjectListByCurriculumId(1)).thenReturn(subjectsIT);
        when(subjectAdapter.getSubjectListByCurriculumId(2)).thenReturn(subjectsCS);

        List<Subject> subjectsResponse = subjectService.searchSubject("int");

        assertThat(subjectsResponse.get(0).getSubjectCode().toLowerCase()).contains("int");
        verify(curriculumService).getAllCurriculum();
        verify(subjectAdapter, times(2)).getSubjectListByCurriculumId(anyLong());
    }
}