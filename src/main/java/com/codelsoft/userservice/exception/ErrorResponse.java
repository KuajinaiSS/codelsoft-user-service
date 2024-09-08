package com.codelsoft.userservice.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private boolean success;
    private String message;
    private Map<String, String> errors;
}
