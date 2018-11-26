package com.sit.cloudnative.MaterialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MaterialController {
    
    @Autowired
    private AmazonService amazonService;

//    @GetMapping("/q")
//    public String daaqqq() {
//        amazonService.uploadFile();
//        return "qqqq";
//    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonService.uploadFile(file);
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "fileName") String fileName) {
        return this.amazonService.deleteFileFromS3Bucket(fileName);
    }
}
