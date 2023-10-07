package com.systechafrica.part4.enums;

public enum Laptop {
    HP(30000), MACBOOK(150000), LENOVO(25000), DELL(40000);

    private int price;

    private Laptop(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

   
    

}
