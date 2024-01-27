package dev.abhiroopsantra.inventoryservice.handler;

import dev.abhiroopsantra.inventoryservice.dto.ApiResponse;
import dev.abhiroopsantra.inventoryservice.exception.BadRequestException;
import dev.abhiroopsantra.inventoryservice.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // handle Exception class and return 500 status code
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception e) {
        log.error("Exception: ", e);
        ApiResponse response = new ApiResponse();
        response.errCode = "500";
        response.errMessage = e.getMessage();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // handle BadRequestException and return 400 status code
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> handleBadRequestException(BadRequestException e) {
        log.error("BadRequestException: ", e);
        ApiResponse response = new ApiResponse();
        response.errCode = "400";
        response.errMessage = e.getMessage();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // handle NotFoundException and return 404 status code
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFoundException(NotFoundException e) {
        log.error("NotFoundException: ", e);
        ApiResponse response = new ApiResponse();
        response.errCode = "404";
        response.errMessage = e.getMessage();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
