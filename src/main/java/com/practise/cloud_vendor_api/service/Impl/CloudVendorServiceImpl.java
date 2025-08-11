package com.practise.cloud_vendor_api.service.Impl;

import com.practise.cloud_vendor_api.model.CloudVendor;
import com.practise.cloud_vendor_api.repository.CloudVendorRepository;
import com.practise.cloud_vendor_api.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;


// This class implements the CloudVendorService interface and provides the business logic for managing cloud vendors
@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    // Autowiring the repository to interact with the database
    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImpl(CloudVendorRepository cloudvendorRepository){
        this.cloudVendorRepository= cloudvendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor){
        // Check if the cloud vendor already exists
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor created with ID:" +cloudVendor.getVendorId();
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor){
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor updated with ID:" + cloudVendor.getVendorId();
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId){
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public String deleteCloudVendor(String vendorId){
        if(!cloudVendorRepository.existsById(vendorId)){
            return "Cloud Vendor not found with ID:" + vendorId;
        }
        cloudVendorRepository.deleteById(vendorId);
        return "Cloud Vendor deleted with ID:" + vendorId;
    }
    public List<CloudVendor> getAllCloudVendor(){
        return cloudVendorRepository.findAll();
    }

}
