package com.sit.cloudnative.SubjectService.Curriculum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Curriculum {

    private long curriculumId;

    private String curriculumName;

    private String curriculumCode;

    private String curriculumDescription;

    public Curriculum() {
    }

    @JsonCreator
    public Curriculum(@JsonProperty("program_id") long id,
            @JsonProperty("program_name") String name,
            @JsonProperty("program_code") String code,
            @JsonProperty("program_description") String description) {
        this.curriculumId = id;
        this.curriculumName = name;
        this.curriculumCode = code;
        this.curriculumDescription = description;
    }

    @JsonGetter("curriculumId")
    public long getCurriculumId() {
        return this.curriculumId;
    }

    public void setCurriculumId(long curriculumId) {
        this.curriculumId = curriculumId;
    }

    @JsonGetter("curriculumName")
    public String getCurriculumName() {
        return this.curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    @JsonGetter("curriculumCode")
    public String getCurriculumCode() {
        return this.curriculumCode;
    }

    public void setCurriculumCode(String curriculumCode) {
        this.curriculumCode = curriculumCode;
    }

    @JsonGetter("curriculumDescription")
    public String getCurriculumDescription() {
        return this.curriculumDescription;
    }

    public void setCurriculumDescription(String curriculumDescription) {
        this.curriculumDescription = curriculumDescription;
    }

}
