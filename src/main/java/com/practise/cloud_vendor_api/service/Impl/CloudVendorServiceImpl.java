package com.practise.cloud_vendor_api.service.Impl;

import com.practise.cloud_vendor_api.exception.CloudVendorNotFoundException;
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
        if(cloudVendorRepository.findById(cloudVendor.getVendorId()).isPresent())
            throw new CloudVendorNotFoundException("Cloud Vendor Already Exists with ID: " + cloudVendor.getVendorId());
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor created with ID:" +cloudVendor.getVendorId();
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor){
        // Check if the cloud vendor exists before updating
        if(cloudVendorRepository.findById((cloudVendor.getVendorId())).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor Does Not Exist with ID: " + cloudVendor.getVendorId());
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor updated with ID:" + cloudVendor.getVendorId();
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId){
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor Does Not Exist with ID: " + cloudVendorId);
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public String deleteCloudVendor(String vendorId){
       if(cloudVendorRepository.findById(vendorId).isEmpty())
           throw new CloudVendorNotFoundException("Requesed Cloud Vendor Does Not Exist with ID:"+vendorId);
        cloudVendorRepository.deleteById(vendorId);
        return "Cloud Vendor deleted with ID:" + vendorId;
    }
    @Override
    public List<CloudVendor> getAllCloudVendor(){
        if(cloudVendorRepository.findAll().isEmpty())
            throw new CloudVendorNotFoundException("No Cloud Vendors Found");
        return cloudVendorRepository.findAll();
    }
}
