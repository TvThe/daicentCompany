package com.daicent.Entity;

public class Product {
    private int id;
    private String name;

    private Seller sellerID;
    private double price;
    private CategoryDetail categoryDetail;

    public Product() {
    }

    public Product(int id, String name, Seller sellerID, double price, CategoryDetail categoryDetail) {
        this.id = id;
        this.name = name;
        this.sellerID = sellerID;
        this.price = price;
        this.categoryDetail = categoryDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seller getSellerID() {
        return sellerID;
    }

    public void setSellerID(Seller sellerID) {
        this.sellerID = sellerID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryDetail getCategoryDetail() {
        return categoryDetail;
    }

    public void setCategoryDetail(CategoryDetail categoryDetail) {
        this.categoryDetail = categoryDetail;
    }

    @Override
    public String toString() {
        return "Product{" +"Name : " + name + "| Seller : " + sellerID + "| Price : " + price+ " | "+ categoryDetail+ " }";
    }
    
    
}
