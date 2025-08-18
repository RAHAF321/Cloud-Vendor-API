package com.practise.cloud_vendor_api.controller;

import com.practise.cloud_vendor_api.model.CloudVendor;
import com.practise.cloud_vendor_api.response.ResponseHandler;
import com.practise.cloud_vendor_api.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloud_vendor")
public class CloudVendorController
{
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService){
        this.cloudVendorService = cloudVendorService;
    }

    //Read specific cloud Vendor Details
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
        return ResponseHandler.responseBuilder(
                "Cloud Vendors retrieved successfully",
                HttpStatus.OK,
                cloudVendorService.getCloudVendor(vendorId));
    }

    //Read All cloud Vendor Details
    @GetMapping
    public ResponseEntity<Object> getAllCloudVendorDetails(){
        return ResponseHandler.responseBuilder("Cloud Vendors retrieved successfully",
                HttpStatus.OK,
                cloudVendorService.getAllCloudVendor());
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
       cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor details created successfully";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return ("Cloud Vendor details Updated successfully");
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return ("Cloud Vendor Deleted Successfully");
    }


}
