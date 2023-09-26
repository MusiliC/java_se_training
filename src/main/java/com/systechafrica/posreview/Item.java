package com.systechafrica.posreview;

public class Item {
    private int id;
    private String itemCode;
    private int itemQuantity;
    private double price;

    public Item(){

    }  
    
    public Item(int id, String itemCode, int itemQuantity, double price) {
        this.id = id;
        this.itemCode = itemCode;
        this.itemQuantity = itemQuantity;
        this.price = price;
    }

    public Item(String itemCode, int itemQuantity, double price) {
        this.itemCode = itemCode;
        this.itemQuantity = itemQuantity;
        this.price = price;
    }
    
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
