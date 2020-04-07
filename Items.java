package com.mansterdevelopers;

public class Items<T extends Category> {

    //Declare variables for Constructor
    private String name;
    private String descriptionOfItem;
    private int stockCount;
    private double priceOfItem;

    //Create Constructor
    public Items(String name, String descriptionOfItem, int stockCount, double priceOfItem) {
        this.name = name;
        this.descriptionOfItem = descriptionOfItem;
        this.stockCount = stockCount;
        this.priceOfItem = priceOfItem;
    }

    //Method return Item name
    public String getName() {
        return name;
    }

    //Method return Item description
    public String getDescriptionOfItem() {
        return descriptionOfItem;
    }

    //Method return the stock count of a Item
    public int getStockCount() {
        return stockCount;
    }

    //Method update stock count of a Item
    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    //Method return Item price.
    public double getPriceOfItem() {
        return priceOfItem;
    }
}
