package com.practise.cloud_vendor_api.controller;

import com.practise.cloud_vendor_api.model.CloudVendor;
import com.practise.cloud_vendor_api.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendor1;
    CloudVendor cloudVendor2;
    List<CloudVendor> cloudVendorList=new ArrayList<>();

    @BeforeEach
    void setUp() {
        cloudVendor1=new CloudVendor("1","AWS","Amazon Web Services","8974532");
        cloudVendor2=new CloudVendor("2","Azure","Microsoft Azure","8974533");
        cloudVendorList.add(cloudVendor1);
        cloudVendorList.add(cloudVendor2);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testGetCloudVendorDetails() {
    }

    @Test
    void testGetAllCloudVendorDetails() {
    }

    @Test
    void testCreateCloudVendorDetails() {
    }

    @Test
    void testUpdateCloudVendorDetails() {
    }

    @Test
    void testDeleteCloudVendorDetails() {
    }
}