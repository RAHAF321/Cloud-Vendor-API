package com.practise.cloud_vendor_api.controller;

import com.practise.cloud_vendor_api.model.CloudVendor;
import com.practise.cloud_vendor_api.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;
import java.lang.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
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
        cloudVendorList.clear();
    }

    @Test
    void testGetCloudVendorDetails() throws Exception {
        when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendor1);

        mockMvc.perform(get("/cloud_vendor/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Data.vendorId").value("1"))
                .andExpect(jsonPath("$.Data.vendorName").value("AWS"));
    }

    @Test
    void testGetAllCloudVendorDetails() throws Exception {
        when(cloudVendorService.getAllCloudVendor()).thenReturn(cloudVendorList);

        mockMvc.perform(get("/cloud_vendor"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Data.length()").value(2))
                .andExpect(jsonPath("$.Data[0].vendorName").value("AWS"))
                .andExpect(jsonPath("$.Data[1].vendorName").value("Azure"));
    }

    @Test
    void testCreateCloudVendorDetails() throws Exception{
        when(cloudVendorService.createCloudVendor(cloudVendor1)).thenReturn("SUCCESS");

        mockMvc.perform(post("/cloud_vendor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                   "vendorId":"1",
                                   "vendorName":"AWS",
                                   "vendorAddress":"Amazon Web Services",
                                   "vendorPhoneNumber":"8974532"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Cloud Vendor details created successfully"));

    }

    @Test
    void testUpdateCloudVendorDetails() throws Exception {
        when(cloudVendorService.updateCloudVendor(cloudVendor1)).thenReturn("SUCCESS");

        mockMvc.perform(put("/cloud_vendor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                   "vendorId":"1",
                                   "vendorName":"AWS",
                                   "vendorAddress":"Amazon Web Services",
                                   "vendorPhoneNumber":"8974532"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Cloud Vendor details Updated successfully"));
    }

    @Test
    void testDeleteCloudVendorDetails() throws Exception {
        when(cloudVendorService.deleteCloudVendor("1")).thenReturn("SUCCESS");

        mockMvc.perform(delete("/cloud_vendor/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Cloud Vendor Deleted Successfully"));
    }
}