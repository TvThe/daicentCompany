package com.daicent.Entity;

public class Seller {

    private int id;
    private String seller;

    public Seller() {
    }

    public Seller(String seller) {
        this.seller = seller;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return seller;
    }
}
