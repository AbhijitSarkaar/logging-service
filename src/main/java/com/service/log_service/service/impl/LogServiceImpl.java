package com.service.log_service.service.impl;

import com.service.log_service.model.Log;
import com.service.log_service.payload.LogDTO;
import com.service.log_service.repository.LogRepository;
import com.service.log_service.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogRepository logRepository;

    @Override
    public Log createLog(LogDTO logDto) {
        Log log = new Log(logDto.getLogText());
        return logRepository.save(log);
    }

}
