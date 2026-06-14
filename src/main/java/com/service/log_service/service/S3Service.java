package com.service.log_service.service;

import com.service.log_service.payload.APIResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface S3Service {
    List<String> getBuckets();

    APIResponse upload(MultipartFile file);
}
