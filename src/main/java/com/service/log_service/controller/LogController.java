package com.service.log_service.controller;

import com.service.log_service.config.ThreadConfig;
import com.service.log_service.model.Log;
import com.service.log_service.payload.LogDTO;
import com.service.log_service.service.LogService;
import com.service.log_service.util.LogUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class LogController {

    @Autowired
    ThreadConfig threadConfig;

    @Autowired
    LogService logService;

    @Autowired
    LogUtils logUtils;

    @PostMapping("/v2/log")
    public ResponseEntity<Log> postLog(@RequestBody LogDTO logDto) {
        return new ResponseEntity<>(
                logService.createLog(logDto),
                HttpStatus.OK
        );
    }

    @GetMapping("/v1/log")
    public ResponseEntity<String> getLog() {
        return new ResponseEntity<>(
                "response 1",
                HttpStatus.OK
        );
    }

    @GetMapping("/threads-config")
    public ResponseEntity<Map<String, String>> getThreadConfig() {
        Map<String, String> map = new HashMap<>();
        map.put("maxThreads", threadConfig.getMaxThreads());
        map.put("minSpareThreads", threadConfig.getMinSpareThreads());
        map.put("acceptCount", threadConfig.getAcceptCount());
        map.put("dataSourceUrl", threadConfig.getDataSourceUrl());

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
