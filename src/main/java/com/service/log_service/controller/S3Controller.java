package com.service.log_service.controller;

import com.service.log_service.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class S3Controller {

    @Autowired
    S3Service s3Service;

    @GetMapping("/list-s3-buckets")
    public ResponseEntity<List<String>> getBuckets() {
        return new ResponseEntity<>(
                s3Service.uploadFile(),
                HttpStatus.OK
        );
    }

}
