package com.service.log_service.util;

import com.service.log_service.config.LogConfig;
import org.springframework.stereotype.Component;

@Component
public class LogUtils {

    public String format(String requestUri, String method, String queryString) {
        String logMessage = "";

        logMessage = LogConfig.REQUEST_URI + "=" + requestUri;
        logMessage += ";;" + LogConfig.REQUEST_METHOD + "=" + method;
        logMessage += ";;" + LogConfig.REQUEST_QUERY_STRINGS + "=" + queryString;

        return logMessage;
    }

}
