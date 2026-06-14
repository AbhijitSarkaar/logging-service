package com.service.log_service.service.impl;

import com.service.log_service.config.S3Properties;
import com.service.log_service.payload.APIResponse;
import com.service.log_service.service.S3Service;
import com.service.log_service.util.S3Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class S3ServiceImpl implements S3Service {

    @Autowired
    S3Properties s3Properties;

    @Autowired
    S3Client s3Client;

    @Autowired
    S3Utils s3Utils;

    @Override
    public List<String> getBuckets() {
       ListBucketsResponse response = s3Client.listBuckets();
       List<Bucket> buckets = response.buckets();
       List<String> result = new ArrayList<>();
       buckets.forEach(bucket -> {
           result.add(bucket.name());
       });
       return result;
    }

    @Override
    public APIResponse upload(MultipartFile file) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss");
            String time = formatter.format(LocalDateTime.now());
            String key = time + "-" + file.getOriginalFilename();

            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(s3Properties.getBucketName())
                    .key(key)
                    .contentType(file.getContentType())
                    .build();

            s3Client.putObject(request, RequestBody.fromBytes(file.getBytes()));
            return new APIResponse(
                    "File uploaded",
                    s3Utils.getS3UploadUrl(s3Properties.getBucketName(), key)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
