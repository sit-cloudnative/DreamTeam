package com.sit.cloudnative.Materials;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materialId;

    @Column(name = "materialName")
    private String materialName;
   
   
    @Column(name = "materialPath")
    private String materialPath;

  
    @Column(name = "uploader")
    private String uploader;

    
    @Column(name = "subjectId")
    private String subjectId;

    public Material(){

    }

    public Material(Long materialId,String materialName,String materialPath){
        this.materialId = materialId;
        this.materialName = materialName;
        this.materialPath = materialPath;

    }


    /**
     * @return Long return the materialId
     */
    public Long getMaterialId() {
        return materialId;
    }

    /**
     * @param materialId the materialId to set
     */
    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    /**
     * @return String return the materialName
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * @param materialName the materialName to set
     */
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    /**
     * @return String return the materialPath
     */
    public String getMaterialPath() {
        return materialPath;
    }

    /**
     * @param materialPath the materialPath to set
     */
    public void setMaterialPath(String materialPath) {
        this.materialPath = materialPath;
    }

    /**
     * @return String return the uploader
     */
    public String getUploader() {
        return uploader;
    }

    /**
     * @param uploader the uploader to set
     */
    public void setUploader(String uploader) {
        this.uploader = uploader;
    }



    /**
     * @return String return the subjectId
     */
    public String getSubjectId() {
        return subjectId;
    }

    /**
     * @param subjectId the subjectId to set
     */
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

	

}