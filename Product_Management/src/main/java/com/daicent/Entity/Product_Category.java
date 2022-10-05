/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daicent.Entity;

/**
 *
 * @author LENNOVO
 */
public class Product_Category {
    private Product productid;
    private Category categoryid;

    public Product_Category() {
    }

    public Product_Category(Product productid, Category categoryid) {
        this.productid = productid;
        this.categoryid = categoryid;
    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public String toString() {
        return "Product" + productid + ", "+categoryid ;
    }
    
}
