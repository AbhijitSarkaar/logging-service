package com.service.log_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class LogController {

    @PostMapping("/v2/log")
    public ResponseEntity<String> postLog() {
        return new ResponseEntity<>(
                "response 2",
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

}
