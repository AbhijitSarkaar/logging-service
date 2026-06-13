package com.service.log_service.controller;

import com.service.log_service.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api")
public class S3Controller {

    @Autowired
    S3Service s3Service;

    @GetMapping("/list-s3-buckets")
    public ResponseEntity<List<String>> getBuckets() {
        return new ResponseEntity<>(
                s3Service.getBuckets(),
                HttpStatus.OK
        );
    }

    @PostMapping("/s3-upload")
    public ResponseEntity<String> upload(@RequestBody MultipartFile file) {
        return new ResponseEntity<>(
                s3Service.upload(file),
                HttpStatus.OK
        );
    }

}
