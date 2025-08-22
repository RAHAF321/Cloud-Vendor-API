package com.practise.cloud_vendor_api.repository;

import com.practise.cloud_vendor_api.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class CloudVendorRepositoryTest {

    //  given -  when -  Then

    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    // @BeforeEach
    @BeforeEach
    void setUp() {
        cloudVendor =new CloudVendor("1","Amazon Web Services", "USA", "123456");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    //Test case success
    @Test
    void testFindByVendorName_Found(){
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Amazon Web Services");
        assertThat
    }
    //Test case failure

}
