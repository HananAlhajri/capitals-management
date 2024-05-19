package com.demo.capmgnmt.exception;

import com.demo.capmgnmt.common.response.APIResponse;
import com.demo.capmgnmt.common.response.ResponseMessage;
import com.demo.capmgnmt.exception.custom.BadRequestException;
import com.demo.capmgnmt.exception.custom.CategoryNotFoundException;
import com.demo.capmgnmt.exception.custom.RegionNotSupportedException;
import com.demo.capmgnmt.exception.custom.UserDoesNotExistException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.demo.capmgnmt.common.constants.Message.Code.*;
import static com.demo.capmgnmt.common.constants.Message.MapCode.RESPONSE_MESSAGE_MAP;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        List<ResponseMessage> responseMessages = fieldErrors.stream().map(fieldError -> {
            ResponseMessage responseMessage = RESPONSE_MESSAGE_MAP.getOrDefault(fieldError.getDefaultMessage(),
                    new ResponseMessage(INVALID_INPUT, "المدخلات غير صحيحة", fieldError.getDefaultMessage()));

            responseMessage.setInvalidValue(fieldError.getRejectedValue() != null ? fieldError.getRejectedValue().toString() : null);

            return responseMessage;
        }).toList();


        return APIResponse.failure(responseMessages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException() {
        return APIResponse.failure(
                Collections.singletonList(RESPONSE_MESSAGE_MAP.get(GENERIC_ERROR))
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        List<ResponseMessage> errorsList = new ArrayList<>();
        ex.getErrorMessageCodes().forEach(errorMessageCode ->
                errorsList.add(RESPONSE_MESSAGE_MAP.get(errorMessageCode)));
        return APIResponse.failure(errorsList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity<Object> handleUserDoesNotExistException() {
        return APIResponse.failure(
                Collections.singletonList(RESPONSE_MESSAGE_MAP.get(USER_DOES_NOT_EXIST))
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RegionNotSupportedException.class)
    public ResponseEntity<Object> handleBadRequestException() {
        return APIResponse.failure(
                Collections.singletonList(RESPONSE_MESSAGE_MAP.get(REGION_NOT_SUPPORTED))
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Object> handleCategoryNotFoundException() {
        return APIResponse.failure(
                Collections.singletonList(RESPONSE_MESSAGE_MAP.get(CATEGORY_NOT_SUPPORTED))
                , HttpStatus.NOT_FOUND);
    }
}