package com.service.log_service.controller;

import com.service.log_service.util.LogUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class LogController {

    @Autowired
    LogUtils logUtils;

    @PostMapping("/v2/log")
    public ResponseEntity<String> postLog() {
        return new ResponseEntity<>(
                "response 2",
                HttpStatus.OK
        );
    }

    @GetMapping("/v1/log")
    public ResponseEntity<String> getLog(HttpServletRequest request) {

        log.info(
                logUtils.format(
                        request.getRequestURI(),
                        request.getMethod(),
                        request.getQueryString()
                )
        );

        return new ResponseEntity<>(
                "response 1",
                HttpStatus.OK
        );

    }

}
