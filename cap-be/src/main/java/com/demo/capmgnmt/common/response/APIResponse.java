package com.demo.capmgnmt.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class APIResponse<T> implements Serializable {
    T data;
    List<ResponseMessage> errors;
    ResponseMessage message;

    public static <T> ResponseEntity<APIResponse<T>> success() {
        return getResponse(null, Collections.emptyList(), HttpStatus.OK, null);
    }

    public static <T> ResponseEntity<APIResponse<T>> success(T data) {
        return getResponse(data, Collections.emptyList(), HttpStatus.OK, null);
    }

    public static <T> ResponseEntity<Object> failure(T data, List<ResponseMessage> errors, HttpStatus httpStatus) {
        APIResponse<Object> response = new APIResponse<>();
        response.setData(data);
        response.setErrors(errors);
        return new ResponseEntity<>(response, httpStatus);
    }

    public static ResponseEntity<Object> failure(List<ResponseMessage> errors, HttpStatus httpStatus) {
        return failure(null, errors, httpStatus);
    }

    private static <T> ResponseEntity<APIResponse<T>> getResponse(T data, List<ResponseMessage> errors, HttpStatus httpStatus, ResponseMessage message) {
        APIResponse<T> response = new APIResponse<>();
        response.setData(data);
        response.setErrors(errors);
        response.setMessage(message);
        return new ResponseEntity<>(response, httpStatus);
    }
}