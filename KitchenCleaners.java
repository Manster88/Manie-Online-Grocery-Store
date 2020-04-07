package com.mansterdevelopers;

public class KitchenCleaners extends Items {

    //Create Constructor
    public KitchenCleaners(String name, String descriptionOfItem, int stockCount, double priceOfItem) {
        super(name, descriptionOfItem, stockCount, priceOfItem);
    }

    //Implement Method to return the KitchenCleaner Item name.
    @Override
    public String getName() {
        return super.getName();
    }

    //Implement Method to return the KitchenCleaner Item description.
    @Override
    public String getDescriptionOfItem() {
        return super.getDescriptionOfItem();
    }

    //Implement Method to return the KitchenCleaner Item Stock Count.
    @Override
    public int getStockCount() {
        return super.getStockCount();
    }

    //Implement Method to return the KitchenCleaner Item price.
    @Override
    public double getPriceOfItem() {
        return super.getPriceOfItem();
    }
}
