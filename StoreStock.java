package com.mansterdevelopers;

import java.util.ArrayList;
import java.util.Collections;

public class StoreStock<T extends Category> {

    //Declare constructor variable.
    private String name;
    //Declare a Category type ArrayList.
    private ArrayList<T> stockList = new ArrayList<>();

    //Create Constructor.
    public StoreStock(String name) {
        this.name = name;
    }

    //Method return the name StoreStock class.
    public String getName() {
        return name;
    }

    //Method add each category to stockList ArrayList.
    public void addStock(T newStock){
        if(stockList.contains(newStock)){
            System.out.println(newStock.getName() + " is already in the store stock list");
        } else{
            stockList.add(newStock);
        }
    }

    //Sort the Store Stock list accordance category stock count
    public void sortStock(){
        Collections.sort(stockList);
        for(T t : stockList){
            System.out.println(t.getName() + " has " + t.getStockCountUnderEachCategory() + " items in stock");
        }
    }
}
