package com.mansterdevelopers;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Category<T extends Items> implements Comparable<Category<T>> {

    //Declare variables for constructor
    private String name;
    private ArrayList<T> items = new ArrayList<>();

    //Create object (df) of the DecimalFormat class to format the price of items accordance currency format.
    DecimalFormat df = new DecimalFormat("#.00");

    //Declare class variables
    int categoryCount = 0;
    int lowStockCount = 0;
    int highStockCount = 0;
    int equalStockCount = 0;

    //Create constructor
    public Category(String name){
        this.name = name;
    }

    //Method return Category name
    public String getName() {
        return name;
    }

    //Method add Items to specific Category list
    public void addItems(T newItem){
        if(items.contains(newItem)){
            System.out.println(newItem.getName() + " is already in the " + this.name + " list.");
        }
        else {
            items.add(newItem);
            System.out.println(newItem.getName() + " is added to the " + this.name + " list.");
        }
    }

    //Method return the number of all items that is store under a specific category.
    public int getCategoryCount(){
        return items.size();
    }

    //Method print out all the Items that stored under a specific category.
    public void printStockCountUnderEachCategory(){
        System.out.println("**********"+ this.name + " Stock List**********");
        for(int i = 0; i < items.size(); i++){
            System.out.println(items.get(i).getName() + " stock count is: " + items.get(i).getStockCount());
        }
        System.out.println("***********End of " + this.name + " Stock List**********\n");
    }

    //Method to print out all the Items in detail that stored under a specific category
    public void printStockInDetail(){
        System.out.println("**********************"+ this.name + " List**********************");
        for(int i = 0; i < items.size(); i++){
            System.out.println(items.get(i).getName() + " -- Description: " + items.get(i).getDescriptionOfItem() + "\n" +
                    "Price: R" + df.format(items.get(i).getPriceOfItem()) + " -- Items in Stock: " + items.get(i).getStockCount());
        }
        System.out.println("**********************End of " + this.name + " List**********************\n");
    }

    //Method return the number of stock for each Item that is stored under a specific category.
    public int getStockCountUnderEachCategory(){
        int stockCountNumber = 0;
        for (T item : items) {
            stockCountNumber += item.getStockCount();
        }
        return stockCountNumber;
    }

    //Method compare two categories accordance them total stock under each category.
    public void compareEachCategoryAccordanceStockCount(Category otherCategory, int ourStockCount, int theirStockCount){
        String message;
        if(ourStockCount > theirStockCount){
            highStockCount++;
            message = " is higher than ";
        } else if(ourStockCount == theirStockCount){
            equalStockCount++;
            message = " is equal ";
        } else{
            lowStockCount++;
            message = " is lower than ";
        }
        categoryCount++;
        if(otherCategory != null){
            System.out.println(this.name + " stock count " + message + otherCategory.getName() + " stock count");
            otherCategory.compareEachCategoryAccordanceStockCount(null, theirStockCount, ourStockCount);
        }
    }

    //Implement compareTo method to sort categories accordance them total stock.
    @Override
    public int compareTo(Category<T> otherCategory) {
        if(this.getStockCountUnderEachCategory() > otherCategory.getStockCountUnderEachCategory()){
            return -1;
        } else if(this.getStockCountUnderEachCategory() < otherCategory.getStockCountUnderEachCategory()){
            return  1;
        } else{
            return 0;
        }
    }

    //Method to check that the name that pass though the parameter, does that item exist in the store.
    public Items<Category> findItemInStore(String nameOfItem){
        for(Items checkedItemInStore : this.items){
            if(checkedItemInStore.getName().equalsIgnoreCase(nameOfItem)){
                return checkedItemInStore;
            }
        }
        return null;
    }

    //Method to update  specific item stock level
    public void updateItemStockLevel(String nameOfItem, int newCountItems){
        //Get Item position in the arrayList
        int position = this.items.indexOf(findItemInStore(nameOfItem));
        //Get current stock level of the item
        int currentStockLevel = this.items.get(position).getStockCount();
        //add the newCountItems to the current stock level of item.
        int newStockLevel = currentStockLevel + newCountItems;
        //Update the new stock level of the item.
        this.items.get(position).setStockCount(newStockLevel);
        System.out.println(nameOfItem + " stock count is successfully updated.");
    }

    //Method to delete a item from the store stock list
    public void removeItem(String nameOfItem){
        //Remove item from the store list.
        this.items.remove(findItemInStore(nameOfItem));
        System.out.println(nameOfItem + " is successfully removed from the store stock");
    }

}
