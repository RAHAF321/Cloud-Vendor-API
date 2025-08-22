package com.practise.cloud_vendor_api.repository;
import java.util.*;
import com.practise.cloud_vendor_api.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>{
    List<CloudVendor> findByVendorName(String vendorName);
}
