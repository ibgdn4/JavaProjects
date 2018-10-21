package com.springbootwx.sell.repository;

import com.springbootwx.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductCategoryRepository DAO
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

}
