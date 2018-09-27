package com.sit.cloudnative.SubjectListService.SubjectList;


public class SubjectList{
    private long subjectId;
    private String subjectName;
    private boolean isFavorite;

    public SubjectList(long subjectId, String subjectName,boolean isFavorite){
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.isFavorite = isFavorite;
    }

    public long getSubjectId(){
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