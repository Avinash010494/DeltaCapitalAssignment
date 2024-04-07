package com.deltacapita.assigment.model;

public class Item {

    private String itemName;
    private int price;
    private String offer;

    public Item(String itemName, int price, String offer) {
        this.itemName = itemName;
        this.price = price;
        this.offer = offer;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }
}
