package de.allcom.exceptions;

import de.allcom.dto.StandardResponseDto;
import jakarta.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<StandardResponseDto> handleRestException(RestException e) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(StandardResponseDto.builder()
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<StandardResponseDto> handleServletException(ServletException e) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(StandardResponseDto.builder()
                        .message(e.getMessage())
                        .build());
    }
}