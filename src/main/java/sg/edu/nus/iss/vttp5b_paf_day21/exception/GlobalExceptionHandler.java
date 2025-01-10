package sg.edu.nus.iss.vttp5b_paf_day21.exception;

import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.vttp5b_paf_day21.model.exception.ApiError;
import sg.edu.nus.iss.vttp5b_paf_day21.model.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        ApiError apiError = new ApiError(response.getStatus(), ex.getMessage(), new Date(), "");

        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ApiError> handleDataAccessException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        ApiError apiError = new ApiError(400, "Record not found", new Date(), "");

        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request, HttpServletResponse response) {
        ApiError apiError = new ApiError(response.getStatus(), ex.getMessage(), new Date(), "");

        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(ResourceNotFoundException ex, HttpServletRequest request, HttpServletResponse response) {
        ApiError apiError = new ApiError(404, ex.getMessage(), new Date(), request.getRequestURI());

        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
