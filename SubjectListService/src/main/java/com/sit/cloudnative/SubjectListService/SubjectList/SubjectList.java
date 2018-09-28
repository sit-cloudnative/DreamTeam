package com.sit.cloudnative.SubjectListService.SubjectList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SubjectList{
    private long subjectId;
    private String subjectName;
    private String subjectDes;
    private boolean isFavorite;

    @JsonCreator
    public SubjectList(@JsonProperty("subject_id") long subjectId,@JsonProperty("subject_name") String subjectName,@JsonProperty("subject_description") String subjectDes){
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectDes = subjectDes;
        this.isFavorite = false;
    }

    /**
     * @return the subjectDes
     */
    @JsonProperty("subject_description")
    public String getSubjectDes() {
        return subjectDes;
    }

    /**
     * @param subjectDes the subjectDes to set
     */
    @JsonProperty("subject_description")
    public void setSubjectDes(String subjectDes) {
        this.subjectDes = subjectDes;
    }

    @JsonProperty("subject_id")
    public long getSubjectId() {
        return subjectId;
    }

    @JsonProperty("subject_name")
    public String getSubName(){
        return subjectName;
    }
    public boolean getIsFavorite(){
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
}