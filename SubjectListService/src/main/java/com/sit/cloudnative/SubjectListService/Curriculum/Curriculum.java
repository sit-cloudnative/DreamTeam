package com.sit.cloudnative.SubjectListService.Curriculum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "curriculums")

public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "curriculumId")
    private String curriculumId;

    @NotBlank
    @Column(name = "curriculumName")
    private String curriculumName;

    @NotBlank
    @Column(name = "curriculumCode")
    private String curriculumCode;

    @NotBlank
    @Column(name = "curriculumDescription")
    private String curriculumDescription;

    public Curriculum() {
     
    }

    public String getCurriculumId() {
        return this.curriculumId;
    }

    public void setCurriculumId(String curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getCurriculumName() {
        return this.curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public String getCurriculumCode() {
        return this.curriculumCode;
    }

    public void setCurriculumCode(String curriculumCode) {
        this.curriculumCode = curriculumCode;
    }

    public String getCurriculumDescription() {
        return this.curriculumDescription;
    }

    public void setCurriculumDescription(String curriculumDescription) {
        this.curriculumDescription = curriculumDescription;
    }

}