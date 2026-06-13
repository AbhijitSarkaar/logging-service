package com.service.log_service.service.impl;

import com.service.log_service.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class S3ServiceImpl implements S3Service {

    @Autowired
    S3Client s3Client;

    @Value("${aws.s3.bucket_name}")
    String bucketName;

    @Override
    public List<String> uploadFile() {
       ListBucketsResponse response = s3Client.listBuckets();
       List<Bucket> buckets = response.buckets();
       List<String> result = new ArrayList<>();
       buckets.forEach(bucket -> {
           result.add(bucket.name());
       });
       return result;
    }
}
