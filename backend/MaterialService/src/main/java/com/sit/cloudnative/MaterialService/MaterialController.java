package com.sit.cloudnative.MaterialService;

import java.io.ByteArrayOutputStream;
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
    private AmazonService amazonService;

    @PostMapping("/file")
    public ResponseEntity<String> uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return new ResponseEntity<String>(amazonService.uploadFile(file), HttpStatus.CREATED);
    }

    @GetMapping("/files")
    public ResponseEntity<List<String>> listAllFiles() {
        return new ResponseEntity<List<String>>(amazonService.listFiles(), HttpStatus.OK);
    }

    @DeleteMapping("/file")
    public ResponseEntity<String> deleteFile(@RequestPart(value = "fileName") String fileName) {
        return new ResponseEntity<String>(amazonService.deleteFileFromS3Bucket(fileName), HttpStatus.OK);
    }

    @GetMapping("/file/{keyname}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String keyname) {
        ByteArrayOutputStream downloadInputStream = amazonService.downloadFile(keyname);

        return ResponseEntity.ok()
                .contentType(contentType(keyname))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + keyname + "\"")
                .body(downloadInputStream.toByteArray());
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
