package com.practise.cloud_vendor_api.service.Impl;

import com.practise.cloud_vendor_api.exception.CloudVendorNotFoundException;
import com.practise.cloud_vendor_api.model.CloudVendor;
import com.practise.cloud_vendor_api.repository.CloudVendorRepository;
import com.practise.cloud_vendor_api.service.CloudVendorService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor(){
        when(cloudVendorRepository.findById(cloudVendor.getVendorId())).thenReturn(Optional.empty());
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor))
                .isEqualTo("Cloud Vendor created with ID:"+cloudVendor.getVendorId());
    }

    @Test
    void testUpdateCloudVendor(){
        when(cloudVendorRepository.findById(cloudVendor.getVendorId())).thenReturn(Optional.of(cloudVendor));
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor))
                .isEqualTo("Cloud Vendor updated with ID:"+cloudVendor.getVendorId());
    }

    @Test
    void testGetCloudVendor(){
        when(cloudVendorRepository.findById("C1")).thenReturn(Optional.of(cloudVendor));

        CloudVendor result = cloudVendorService.getCloudVendor("C1");

        assertThat(result).isEqualTo(cloudVendor);
    }

    @Test
    void testGetAllCloudVendor_Success(){
        List<CloudVendor> vendorList = List.of(cloudVendor);
        when(cloudVendorRepository.findAll()).thenReturn(vendorList);
        List<CloudVendor> result= cloudVendorService.getAllCloudVendor();
        assertThat(result).isEqualTo(vendorList);
    }

    @Test
    void testGetAllCloudVendor_NoVendorFound(){
        when(cloudVendorRepository.findAll()).thenReturn(List.of());
        assertThrows(CloudVendorNotFoundException.class,()->cloudVendorService.getAllCloudVendor());
    }

    @Test
    void testDeleteCloudVendor_Success(){
        when(cloudVendorRepository.findById("C1")).thenReturn(Optional.of(cloudVendor));
        doNothing().when(cloudVendorRepository).deleteById("C1");
        String result=cloudVendorService.deleteCloudVendor("C1");
        assertThat(result).isEqualTo("Cloud Vendor deleted with ID:"+"C1");
        verify(cloudVendorRepository,times(1)).findById("C1");
        verify(cloudVendorRepository,times(1)).deleteById("C1");
    }

    @Test
    void testDeleteCloudVendor_CloudVendorNotFound(){
        when(cloudVendorRepository.findById("C1")).thenReturn(Optional.empty());
        assertThrows(CloudVendorNotFoundException.class,
                ()->cloudVendorService.deleteCloudVendor("C1"));
        verify(cloudVendorRepository,times(1)).findById("C1");
        verify(cloudVendorRepository,never()).deleteById("C2");
    }
}