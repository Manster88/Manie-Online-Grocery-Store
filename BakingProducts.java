package com.mansterdevelopers;

public class BakingProducts extends Items {

    //Create Constructor
    public BakingProducts(String name, String descriptionOfItem, int stockCount, double priceOfItem) {
        super(name, descriptionOfItem, stockCount, priceOfItem);
    }

    //Implement Method to return the BakingProducts Item name.
    @Override
    public String getName() {
        return super.getName();
    }

    //Implement Method to return the BakingProducts Item description.
    @Override
    public String getDescriptionOfItem() {
        return super.getDescriptionOfItem();
    }

    //Implement Method to return the BakingProducts Item Stock Count.
    @Override
    public int getStockCount() {
        return super.getStockCount();
    }

    //Implement Method to return the BakingProducts Item price.
    @Override
    public double getPriceOfItem() {
        return super.getPriceOfItem();
    }
}
