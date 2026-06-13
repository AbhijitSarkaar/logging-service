package com.service.log_service.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface S3Service {
    List<String> getBuckets();

    String upload(MultipartFile file);
}
