package com.springbootwx.sell.service;

import com.springbootwx.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 商品类目
 */
public interface ProductCategoryService {

    ProductCategory findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
