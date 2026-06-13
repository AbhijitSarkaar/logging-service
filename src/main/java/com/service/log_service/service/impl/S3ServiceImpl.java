package com.service.log_service.service.impl;

import com.service.log_service.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.async.AsyncRequestBody;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class S3ServiceImpl implements S3Service {

    @Autowired
    S3Client s3Client;

    @Autowired
    S3AsyncClient s3AsyncClient;

    @Value("${aws.s3.bucket_name}")
    String bucketName;

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
    public String upload(MultipartFile file) {
        System.out.println(file.getOriginalFilename());

        try {

            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(file.getOriginalFilename())
                    .build();

            s3Client.putObject(request, RequestBody.fromBytes("/Users/abhijitsarkar/Desktop/image.jpg".getBytes()));

            String s3UploadLink = "https://" + bucketName + ".s3.ap-south-1.amazonaws.com"+ file.getOriginalFilename();
            System.out.println(s3UploadLink);
            return s3UploadLink;


        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}
