package com.service.log_service.service;

import com.service.log_service.model.Log;
import com.service.log_service.payload.LogDTO;

public interface LogService {
    Log createLog(LogDTO logDto);
}
