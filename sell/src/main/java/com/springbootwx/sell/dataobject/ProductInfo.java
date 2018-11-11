package com.springbootwx.sell.dataobject;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 卖家商品
 */
@Entity
@Data
public class ProductInfo {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//  id 不需要自增长，不需要，否则会出现 Field 'product_id' doesn't have a default value 的错误
    private String productId;

    // 商品名称
    private String productName;

    // 单价
    private BigDecimal productPrice;

    // 库存
    private Integer productStock;

    // 商品描述
    private String productDescription;

    // 商品图标
    private String productIcon;

    // 商品状态，0正常，1下架
    private Integer productStatus;

    // 类目编号
    private Integer categoryType;

    // 创建时间
    @CreatedDate
    private Date createTime;

    // 修改时间
    @LastModifiedDate
    private Date updateTime;
}
