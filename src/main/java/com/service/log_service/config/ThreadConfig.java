package com.service.log_service.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ThreadConfig {
    @Value("${server.tomcat.threads.max}")
    private String maxThreads;

    @Value("${server.tomcat.min-spare-threads}")
    private String minSpareThreads;

    @Value("${server.tomcat.accept-count}")
    private String acceptCount;
}
