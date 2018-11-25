package com.sit.cloudnative.MaterialService;

import com.amazonaws.AmazonClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialController {
    
    @Autowired
    private AmazonService amazonService;
    
    @GetMapping("/q")
    public String daaqqq() {
        amazonService.uploadFile();
        return "qqqq";
    }
}
