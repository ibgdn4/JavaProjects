package com.springbootwx.sell.service;

import com.springbootwx.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品信息
 */

public interface ProductInfoService {
    ProductInfo findById(String productId);

    // 查询所有在售商品
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

//    List<ProductInfo> findByProductStatus(Integer productStatus);

    ProductInfo save(ProductInfo productInfo);

    // 加库存

    // 减库存
}
