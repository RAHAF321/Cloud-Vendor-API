package com.practise.cloud_vendor_api.controller;

import com.practise.cloud_vendor_api.model.CloudVendor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloud-vendor")
public class CloudVendorAPIService
{
    CloudVendor cloudVendor;

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        this.cloudVendor = cloudVendor;
        return "Cloud Vendor details created successfully";
    }

    @GetMapping("{vendorId}")
    public ResponseEntity<CloudVendor> getCloudVendorDetails()
    {
        return new ResponseEntity<>(cloudVendor, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        this.cloudVendor = cloudVendor;
        return new ResponseEntity<>("Cloud Vendor details Updated successfully",HttpStatus.OK);
    }

    @DeleteMapping("{vendorId}")
    public ResponseEntity<String> deleteCloudVendorDetails(String vendorId){
        if (this.cloudVendor == null || !vendorId.equals(cloudVendor.getVendorId())) {
            return new ResponseEntity<>("Cloud Vendor not found", HttpStatus.NOT_FOUND);
        }
        this.cloudVendor=null;
        return new ResponseEntity<>("Cloud Vendor Deleted Successfully",HttpStatus.OK);
    }


}
