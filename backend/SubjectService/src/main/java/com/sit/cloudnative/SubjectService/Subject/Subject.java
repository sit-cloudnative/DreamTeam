package com.sit.cloudnative.SubjectService.Subject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Subject {

    private long subjectId;

    private String subjectName;

    private String subjectDescription;

    private String subjectCode;

    private boolean isFavorite;

    @JsonCreator
    public Subject(@JsonProperty("subject_id") long subjectId, @JsonProperty("subject_name") String subjectName, @JsonProperty("subject_description") String subjectDescription, @JsonProperty("subject_code") String subjectCode) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectDescription = subjectDescription;
        this.subjectCode = subjectCode;
        this.isFavorite = false;
    }

    @JsonGetter("subjectDescription")
    public String getSubjectDescription() {
        return subjectDescription;
    }

    @JsonProperty("subject_description")
    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    @JsonGetter("subjectId")
    public long getSubjectId() {
        return subjectId;
    }

    @JsonGetter("subjectName")
    public String getSubjectName() {
        return subjectName;
    }

    @JsonGetter("isFavorite")
    public boolean getIsFavorite() {
        return isFavorite;
    }

    @JsonProperty("subject_id")
    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    @JsonProperty("subject_name")
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    @JsonGetter("subjectCode")
    public String getSubjectCode() {
        return subjectCode;
    }

    @JsonProperty("subject_code")
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

}
