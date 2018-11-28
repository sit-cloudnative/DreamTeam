package com.sit.cloudnative.MaterialService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private AmazonService amazonService;

    public List<Material> getMaterialList() {
        return materialRepository.findAll();
    }

    public Optional<Material> getMaterialById(long id) {
        return materialRepository.findById(id);
    }

    public Material uploadMaterial(String subjectCode, MultipartFile multipartFile) throws IOException {
        String OriginalName = multipartFile.getOriginalFilename();
        String uploadFileName = generateFileName(subjectCode, multipartFile);
        File file = convertMultiPartToFile(multipartFile);

        amazonService.uploadFile(uploadFileName, file);

        Material material = new Material();
        material.setFileName(OriginalName);
        material.setFileKey(uploadFileName);
        material.setFileOwner("test");
        material.setSubjectCode(subjectCode);
        return materialRepository.save(material);
    }

    public byte[] downloadMaterial(Material material) {
        ByteArrayOutputStream downloadInputStream = amazonService.downloadFile(material.getFileKey());
        return downloadInputStream.toByteArray();
    }

    public long deleteMaterialById(long id) {
        Material material = materialRepository.findById(id).get();
        amazonService.deleteFile(material.getFileKey());
        materialRepository.deleteById(id);
        return id;
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String generateFileName(String subjectCode, MultipartFile multiPart) {
        return subjectCode + "/" + new Date().getTime() + "-" + multiPart.getOriginalFilename().replaceAll("[^.,a-zA-Z0-9]", "_");
    }

    public List<Material> getMaterialListBySubjectCode(String subjectCode) {
        return materialRepository.findBySubjectCode(subjectCode);
    }

}
