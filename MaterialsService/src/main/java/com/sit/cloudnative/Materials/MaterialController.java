package com.sit.cloudnative.Materials;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialController {

    @Autowired
    private MaterialService materialService;

   
    @GetMapping("/material/{id}")
    public ResponseEntity<List<Material>> getMaterialById(@PathVariable(value = "id") String subjectId) {
        List<Material> material = materialService.getMaterialById(subjectId);
        return new ResponseEntity<List<Material>>(material,HttpStatus.OK);
    }
    @PostMapping("/material/{id}")
    public ResponseEntity<Material> uploadMaterial(@Valid @RequestBody Material material) {
        Material materialObject = materialService.uploadMaterial(material);
        return new ResponseEntity<Material>(materialObject, HttpStatus.OK);
    }
    
    @DeleteMapping("/material/{id}")
    public ResponseEntity<Material> deleteMaterial(@PathVariable(value = "id") Long materialId) {
        Material material = materialService.getMaterialById(materialId);
        materialService.delete(material);
        return ResponseEntity.ok().build();
    }
    
    
}

 
   
