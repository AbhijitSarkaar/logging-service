package com.service.log_service.util;

import org.springframework.stereotype.Component;

@Component
public class S3Utils {
    public String getS3UploadUrl(String bucketName, String fileName) {
        return "https://" + bucketName + ".s3.ap-south-1.amazonaws.com/"+ fileName;
    }
}
