package com.sit.cloudnative.MaterialService;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MaterialController {
    
    @Autowired
    private MaterialService materialService;
    
    @Autowired
    private AmazonService amazonService;
    
    Logger logger = LoggerFactory.getLogger(MaterialController.class);
    
    @GetMapping("/files")
    public ResponseEntity<List<Material>> listAllFiles() {
        return new ResponseEntity<List<Material>>(materialService.getMaterialList(), HttpStatus.OK);
    }
    
    @GetMapping("/files/{subjectCode}")
    public ResponseEntity<List<Material>> listFilesBySubjectCode(@PathVariable String subjectCode) {
        return new ResponseEntity<List<Material>>(materialService.getMaterialListBySubjectCode(subjectCode), HttpStatus.OK);
    }
    
    @PostMapping("/file/{subjectCode}")
    public ResponseEntity<Material> uploadFile(@PathVariable String subjectCode, @RequestPart(value = "file") MultipartFile file) {
        try {
            Material material = materialService.uploadMaterial(subjectCode, file);
            return new ResponseEntity<Material>(material, HttpStatus.CREATED);
        } catch (IOException ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/file/{materialId}")
    public ResponseEntity<Long> deleteFile(@PathVariable long materialId) {
        return new ResponseEntity<Long>(materialService.deleteMaterialById(materialId), HttpStatus.OK);
    }
    
    @GetMapping("/file/{materialId}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable long materialId) {
        Material material = materialService.getMaterialById(materialId).get();
        return ResponseEntity.ok()
                .contentType(contentType(material.getFileName()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + material.getFileName() + "\"")
                .body(materialService.downloadMaterial(material));
    }
    
    private MediaType contentType(String keyname) {
        String[] arr = keyname.split("\\.");
        String type = arr[arr.length - 1];
        switch (type) {
            case "txt":
                return MediaType.TEXT_PLAIN;
            case "png":
                return MediaType.IMAGE_PNG;
            case "jpg":
                return MediaType.IMAGE_JPEG;
            case "pdf":
                return MediaType.APPLICATION_PDF;
            default:
                return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
}
