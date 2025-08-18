package com.practise.cloud_vendor_api.response;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(
            String message, HttpStatus httpStatus, Object responseData){

        Map<String, Object> response=new HashMap<>();
        response.put("Message",message);
        response.put("HttpStatus", httpStatus);
        response.put("Data", responseData);

        return new ResponseEntity<>(response,httpStatus);

    }
}
