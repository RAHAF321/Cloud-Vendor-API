package com.practise.cloud_vendor_api.service.Impl;

import com.practise.cloud_vendor_api.model.CloudVendor;
import com.practise.cloud_vendor_api.repository.CloudVendorRepository;
import com.practise.cloud_vendor_api.service.CloudVendorService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("C1", "Microsoft Azure","Azure Office","123435");
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void createCloudVendor(){

    }

    @Test
    void updateCloudVendor(){

    }

    @Test
    void getCloudVendor(){

    }

    @Test
    void deleteCloudVendor(){

    }

    @Test
    void getAllCloudVendor(){

    }
}