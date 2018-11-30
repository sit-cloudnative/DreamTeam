package com.sit.cloudnative.MaterialService;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import com.sit.cloudnative.MaterialService.exception.BadRequestException;
import com.sit.cloudnative.MaterialService.exception.NotFoundException;
import com.sit.cloudnative.MaterialService.exception.UnauthorizedException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private TokenService tokenService;

    Logger logger = LoggerFactory.getLogger(MaterialController.class);

    @GetMapping("/files")
    public ResponseEntity<List<Material>> getAllFiles(@RequestHeader("Authorization") String auth, HttpServletRequest request) {
        tokenService.validateToken(auth, request, logger);
        return new ResponseEntity<List<Material>>(materialService.getMaterialList(), HttpStatus.OK);
    }

    @GetMapping("/files/{subjectCode}")
    public ResponseEntity<List<Material>> getFilesBySubjectCode(@PathVariable String subjectCode, @RequestHeader("Authorization") String auth, HttpServletRequest request) {
        tokenService.validateToken(auth, request, logger);
        return new ResponseEntity<List<Material>>(materialService.getMaterialListBySubjectCode(subjectCode), HttpStatus.OK);
    }

    @PostMapping("/file/{subjectCode}")
    public ResponseEntity<Material> uploadFile(@PathVariable String subjectCode, @RequestPart(value = "file") MultipartFile file, @RequestHeader("Authorization") String auth, HttpServletRequest request) {
        tokenService.validateToken(auth, request, logger);
        String username = tokenService.getUser(auth);
        if (!"admin".equals(tokenService.getRole(auth))) {
            logger.warn(System.currentTimeMillis() + " | " + username + " | " + "try to upload file");
            throw new UnauthorizedException("Not have permission");
        }
        try {
            Material material = materialService.uploadMaterial(subjectCode, file, username);
            logger.info(System.currentTimeMillis() + " | " + username + " | " + "upload material name (" + material.getFileName() + ")");
            return new ResponseEntity<Material>(material, HttpStatus.CREATED);
        } catch (IOException ex) {
            logger.warn(System.currentTimeMillis() + " | " + username + " | " + "cannot upload file IOException");
            throw new BadRequestException("Cannot upload this time");
        }
    }

    @DeleteMapping("/file/{materialId}")
    public ResponseEntity<Long> deleteFile(@PathVariable long materialId, @RequestHeader("Authorization") String auth, HttpServletRequest request) {
        tokenService.validateToken(auth, request, logger);
        String username = tokenService.getUser(auth);
        if (!"admin".equals(tokenService.getRole(auth))) {
            logger.warn(System.currentTimeMillis() + " | " + username + " | " + "try to delete material id (" + materialId + ")");
            throw new UnauthorizedException("Not have permission");
        }
        try {
            long deleteId = materialService.deleteMaterialById(materialId);
            logger.info(System.currentTimeMillis() + " | " + username + " | " + "delete material id (" + deleteId + ")");
            return new ResponseEntity<Long>(deleteId, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + username + " | " + "not found material id (" + materialId + ")");
            throw new NotFoundException(e.getMessage());
        }
    }

    @GetMapping("/file/{materialId}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable long materialId, @RequestHeader("Authorization") String auth, HttpServletRequest request) {
        tokenService.validateToken(auth, request, logger);
        String username = tokenService.getUser(auth);
        try {
            Material material = materialService.getMaterialById(materialId).get();
            logger.info(System.currentTimeMillis() + " | " + username + " | " + "download material id (" + materialId + ")");
            return ResponseEntity.ok()
                    .contentType(contentType(material.getFileName()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + material.getFileName() + "\"")
                    .body(materialService.downloadMaterial(material));
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + username + " | " + "not found material id (" + materialId + ")");
            throw new NotFoundException(e.getMessage());
        }
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
