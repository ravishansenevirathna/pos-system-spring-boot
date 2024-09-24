package com.pos_system.advisor;

import com.pos_system.exception.NotFoundException;
import com.pos_system.response.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<StandardResponse> (new StandardResponse(404,"Error","Error",e.getMessage()+"ffffffff"),HttpStatus.NOT_FOUND);
    }
}
