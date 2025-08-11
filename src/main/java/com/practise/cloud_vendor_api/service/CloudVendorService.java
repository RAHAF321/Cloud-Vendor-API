package com.practise.cloud_vendor_api.service;

import com.practise.cloud_vendor_api.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    //return in GET call we give as CloudVendor Object
    public CloudVendor getCloudVendor(String vendorId);
    public String deleteCloudVendor(String vendorId);
    public List<CloudVendor> getAllCloudVendor();

    }
