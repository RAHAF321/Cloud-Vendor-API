package com.practise.cloud_vendor_api.exception;

import com.practise.cloud_vendor_api.model.CloudVendor;

public class CloudVendorNotFoundException extends RuntimeException{

    public CloudVendorNotFoundException(String message){
        super(message);
    }

    public CloudVendorNotFoundException(String message,Throwable cause){
        super(message, cause);
    }
}
