package com.springbootwx.sell.controller;

import com.springbootwx.sell.VO.ProductInfoVO;
import com.springbootwx.sell.VO.ProductVO;
import com.springbootwx.sell.VO.ResultVO;
import com.springbootwx.sell.dataobject.ProductCategory;
import com.springbootwx.sell.dataobject.ProductInfo;
import com.springbootwx.sell.service.ProductCategoryService;
import com.springbootwx.sell.service.ProductInfoService;
import com.springbootwx.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO list() {
        // 1. 查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        // 2. 查询类目（一次性查询）
        // 传统方法
//        List<Integer> catgoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo : productInfoList) {
//            catgoryTypeList.add(productInfo.getCategoryType());
//        }
        // 精简方法（lambda)
        List<Integer> catgoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(catgoryTypeList);
        // 3. 数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        resultVO.setData(productVOList);
//        return resultVO;
        return ResultVOUtil.success(productVOList);
    }
}
