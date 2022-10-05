package com.daicent.Entity;

public class Product {
    private int id;
    private String name;

    private Seller sellerID;
    private double price;

    public Product() {
    }

    public Product(int id, String name, Seller sellerID, double price) {
        this.id = id;
        this.name = name;
        this.sellerID = sellerID;
        this.price = price;
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
    @Override
    public String toString() {
        return "ID = " + id + ", Product Name = " + name + ", Seller = " + sellerID.getSeller()+ ", price = " + price +"$";
    }
    
}
