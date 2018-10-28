package com.springbootwx.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 买家类目
 */
@Entity // 映射为对象
//@DynamicUpdate // 动态更新（执行修改操作时，修改时间同时更新）
@Data
public class ProductCategory {

    // 类目 id
    @Id // 主键 id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长
    private Integer categoryId;
    // 类目名称
    private String categoryName;
    // 类目标号
    private Integer categoryType;
    // 创建时间
    @CreatedDate
    private Date createTime;
    // 修改时间
    @LastModifiedDate
    private Date updateTime;

    public ProductCategory(String s, int i) {
        this.categoryName = s;
        this.categoryType = i;
    }

    public ProductCategory() {
    }


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }
}
