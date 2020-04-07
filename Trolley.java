package com.mansterdevelopers;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Trolley<T extends Category> {

    //Declare variable for constructor.
    private String name;

    //Declare Items type ArrayList to store items that is loaded into the trolley.
    private ArrayList<Items> trolley = new ArrayList<>();

    //Declare Integer type ArrayList to store the number of the same items that is loaded into the trolley.
    private ArrayList<Integer> numberOfEachItem = new ArrayList<>();

    //Declare Double type ArrayList to store the item price that is loaded into the trolley.
    private ArrayList<Double> totalPricePerItem = new ArrayList<>();

    //Create object (df2) of the DecimalFormat class to format the price of items accordance currency format.
    DecimalFormat df2 = new DecimalFormat("#.00");

    //Create Constructor.
    public Trolley(String name) {
        this.name = name;
    }

    //Method return trolley name.
    public String getName() {
        return name;
    }

    //Method store the price of the item into numberOfEachItem ArrayList that is loaded into the trolley.
    public void setCountOfEachItem(int indexOfItem, int countOfNewItem){
       numberOfEachItem.add(indexOfItem, countOfNewItem);
    }

    //Method return the price of the item that is stored in numberOfEachItem ArrayList.
    public int getCountOfEachItem(int indexOfItem){
        return numberOfEachItem.get(indexOfItem);
    }

    //Method store the price of the item into totalPricePerItem ArrayList that is loaded into the trolley.
    public void setTotalPricePerItem(int indexOfItem, double totalAmountOfItems){
        totalPricePerItem.add(indexOfItem, totalAmountOfItems);
    }

    //Method return the price of the item that is stored in totalPriceItem ArrayList
    public double getTotalPricePerItem(int indexOfItem){
        return totalPricePerItem.get(indexOfItem);
    }

    /* Method add the Items to the trolley ArrayList that is loaded into the trolley,
       Method also check if it is possible to add the number of same items that user request by
       checking the item stock count. Method also check if the item already exist in the trolley, if so
        than update the number of same item that is in the trolley. Than update the item stock count.*/
    public void addItemsToTrolley(Items<T> newItem, int countOfEachItem){
        int updateItemCount = 0;
        int updateCountOfNewItem = 0;
        double updateTotalPriceOfItem = 0;

        //Check if the item already exist in the trolley.
        if(trolley.contains(newItem)){
            //check if the item stock count is enough to full fill the user request.
            if(newItem.getStockCount() > 0){
                updateItemCount = newItem.getStockCount() - countOfEachItem;
                if(updateItemCount <= 0){
                    System.out.println("Can`t add " + newItem.getName() + " to the trolley, there is only " + newItem.getStockCount() + " items in the store");
                }
                //Add the item to the trolley and update the item stock count.
                else {
                    newItem.setStockCount(updateItemCount);

                    //Update the item stock count after the item was added to the trolley.
                    updateCountOfNewItem = getCountOfEachItem(trolley.indexOf(newItem));
                    updateCountOfNewItem += countOfEachItem;
                    setCountOfEachItem(trolley.indexOf(newItem), updateCountOfNewItem);

                    //Get the price of the item that is added to the trolley and also do the calculations
                    //if more than one of same item is added to the trolley to get the total amount of the item.
                    updateTotalPriceOfItem = getTotalPricePerItem(trolley.indexOf(newItem));
                    updateTotalPriceOfItem += (newItem.getPriceOfItem() * countOfEachItem);
                    setTotalPricePerItem(trolley.indexOf(newItem), updateTotalPriceOfItem);

                   //Display message after successfully update the trolley of the specific item.
                    System.out.println(newItem.getName() + " @ R" + df2.format(newItem.getPriceOfItem()) + " is updated in the trolley. Items: "
                            + countOfEachItem + " = R" + df2.format(getTotalPricePerItem(trolley.indexOf(newItem))));
                   }
                } else{
                //if the item stock count not enough to full fill the user request, display message.
                System.out.println(newItem.getName() + " is out of stock.");
            }
        }
        //Add the new item to the trolley if it was not found the trolley list.
        else{
            if(newItem.getStockCount() > 0){

                //check if the item stock count is enough to full fill the user request.
                updateItemCount = newItem.getStockCount() - countOfEachItem;
                if(updateItemCount <= 0){
                    System.out.println("Can`t add to the trolley, there is only " + newItem.getStockCount() + " items in the store");
                } else {
                    newItem.setStockCount(updateItemCount);

                    trolley.add(newItem);
                    setCountOfEachItem(trolley.indexOf(newItem), countOfEachItem);
                    setTotalPricePerItem(trolley.indexOf(newItem), (newItem.getPriceOfItem() * countOfEachItem));

                    //Display message after successfully update the trolley of the specific item.
                    System.out.println(newItem.getName() + " @ R" + df2.format(newItem.getPriceOfItem()) + " is added to the trolley. Items: "
                            + countOfEachItem + " = R" + df2.format(getTotalPricePerItem(trolley.indexOf(newItem))));
                }
            } else{
                //if the item stock count not enough to full fill the user request, display message.
                System.out.println(newItem.getName() + " is out of stock.");
            }
        }
    }

    //Method print all the items with each item price that was added to the trolley list.
    public void printItemsInTrolley(){
        System.out.println("******************Items in Trolley******************");
        for(int i = 0; i < trolley.size(); i++){
            System.out.println((i + 1) + " " + trolley.get(i).getName() + " @ R" + df2.format(trolley.get(i).getPriceOfItem())  +
                    " --> Items: " + getCountOfEachItem(i) + " = R" + df2.format(getTotalPricePerItem(i)));
        }
        double totalCost = 0.00d;
        for(int j = 0; j < totalPricePerItem.size(); j++){
            totalCost += getTotalPricePerItem(j);
        }
        System.out.println("\nTotal Cost = R" + df2.format(totalCost));
        System.out.println("******************************************************");
    }

    //Method to remove a item in the trolley list.
    public void removeItemInTrolley(String itemName){
        int restoreItemCount = 0;
        int updateItemCount = 0;
        if(findTrolleyItem(itemName) != null){
            int position = trolley.indexOf(findTrolleyItem(itemName));
            restoreItemCount = this.numberOfEachItem.get(position);
            updateItemCount = this.trolley.get(position).getStockCount() + restoreItemCount;
            this.trolley.get(position).setStockCount(updateItemCount);
            this.trolley.remove(position);
            this.numberOfEachItem.remove(position);
            this.totalPricePerItem.remove(position);
            System.out.println(itemName + " is successfully removed from the trolley.");
        } else{
            System.out.println(itemName + " is not in the trolley");
        }
    }

    //Method to check if the item want to be remove is in the trolley list.
    private Items<T> findTrolleyItem(String name){
        for(Items<T> checkedTrolleyItem : this.trolley){
            if(checkedTrolleyItem.getName().equalsIgnoreCase(name)){
                return checkedTrolleyItem;
            }
        }
        return null;
    }

    //Method delete all the items that was stored in trolley list.
    public void emptyTrolley(){
        trolley.clear();
        numberOfEachItem.clear();
        totalPricePerItem.clear();
    }

    //Method generate a slip when the user pay for items in his trolley
    public void generateSlip(){
        System.out.println("************************************************************************");
        System.out.println("\t\t\t\t\t\t MANIE ONLINE STORE\n");
        System.out.println("\t\tITEMS");
        //Print all the items in trolley
        for(int i = 0; i < trolley.size(); i++){
            System.out.println("\t\t" + trolley.get(i).getName() + " @ R" + df2.format(trolley.get(i).getPriceOfItem())  +
                    " --> Items: " + getCountOfEachItem(i) + " = R" + df2.format(getTotalPricePerItem(i)));
        }
        //Calculate the total cost for the items
        double totalCost = 0.00d;
        for(int j = 0; j < totalPricePerItem.size(); j++){
            totalCost += getTotalPricePerItem(j);
        }
        //Calculate the vat on the total price.
        double vat = totalCost * 0.15;
        //Calculate total amount without VAT
        double totalBeforeVat = totalCost - vat;
        //Round off to nearest hundred to use the value as Cash.
        int cash = (((int) totalCost + 99) / 100) * 100;
        //Framework of the slip.
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\tTOTAL BEFORE VAT = R" + df2.format(totalBeforeVat));
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tVAT = R" + df2.format(vat));
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tTOTAL = R" + df2.format(totalCost));
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tCASH = R" + df2.format(cash));
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tCHANGE = R" + df2.format(cash - totalCost));
        System.out.println("\n\t\t\t\t\t\t\t THANK YOU");
        System.out.println("************************************************************************");
    }
}
