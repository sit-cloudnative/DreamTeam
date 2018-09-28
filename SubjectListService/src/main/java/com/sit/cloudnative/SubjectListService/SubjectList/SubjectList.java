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
    public String getSubjectDes() {
        return subjectDes;
    }

    /**
     * @param subjectDes the subjectDes to set
     */
    public void setSubjectDes(String subjectDes) {
        this.subjectDes = subjectDes;
    }

    public long getSubjectId() {
        return subjectId;
    }
    public String getSubName(){
        return subjectName;
    }
    public boolean getIsFavorite(){
        return isFavorite;
    }
    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}