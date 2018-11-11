package com.springbootwx.sell.repository;

import com.springbootwx.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ProductInfoRepository DAO
 */

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
//    List<ProductInfo> findByProductIds (List<String> productId);
}
