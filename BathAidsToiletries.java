package com.mansterdevelopers;

public class BathAidsToiletries extends Items {

    //Create Constructor
    public BathAidsToiletries(String name, String descriptionOfItem, int stockCount, double priceOfItem) {
        super(name, descriptionOfItem, stockCount, priceOfItem);
    }

    //Implement Method to return the BathAidsToiletries Item name.
    @Override
    public String getName() {
        return super.getName();
    }

    //Implement Method to return the BathAidsToiletries Item description.
    @Override
    public String getDescriptionOfItem() {
        return super.getDescriptionOfItem();
    }

    //Implement Method to return the BathAidsToiletries Item Stock Count.
    @Override
    public int getStockCount() {
        return super.getStockCount();
    }

    //Implement Method to return the BathAidsToiletries Item Price.
    @Override
    public double getPriceOfItem() {
        return super.getPriceOfItem();
    }
}
