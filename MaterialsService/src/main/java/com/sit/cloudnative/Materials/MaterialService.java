package com.sit.cloudnative.Materials;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;

   
    public List<Material> getMaterialById(String subjectId) {
        return   materialRepository.findAllBySubjectId(subjectId);
               
    }
   public Material uploadMaterial(Material material) {
        return materialRepository.save(material);
    }

    public void delete(Material material) {
        materialRepository.delete(material);
    }

    public Material getMaterialById(Long materialId) {
        return materialRepository.findById(materialId)
                .orElseThrow(() -> new ResourceNotFoundException("Material", "id", materialId));
    }

}