/*
* Developer: Hermanus Steyn
* Date: 07 April 2020
*
* This program is basic online store that have the basic functions that a normal online store will have. The main
* menu is divide in two parts. The first part (Manage Store Stock) is for the store owner to manage his store stock.
* The second part is where user can shop online from the online store. The store has 4 different categories where the
*  stock is listed under : Pasta, Baking Products, Kitchen Cleaners, Bath Aid Toiletries.
*
* THE FIRST PART - Manage Store Stock Menu has the following functions
* 1) Add new item to the relevant category where the store owner wanted to listed it. When store owner add new item, he
*    need the following information of the new Item - Item Name, Description of item, the quantity, price of item.
* 2)The store owner can check his stock levels under each category
* 3)The Store owner can update a specific item stock level by enter the name of the item.
* 4)The store owner can delete a item from the store stock list.
* 5)Than the store owner has a function to display the all the items in detail per category.
* 6)The store owner can compare a category stock levels against other categories.
* 7)Than there is function to display the categories from high to low accordance stock levels.
*
* THE SECOND PART - Shop Online Menu has the following functions for the user.
* 1) The user can go though each category to see what items is available in the store.
* 2) The user can add items to trolley list, with the function to specify the quantity of each item
*    that the user is added to the trolley list. When the user added a item to the trolley, that item stock
*    count is automatically updated. If the user try add more quantity of a item that is available then the user
*    will get error message and state the quantity that is available in the store for that item.
* 3) The user can check what items is already in the trolley that he/she is added and also see the total amount of the
*    current items that is in the trolley.
* 4) The user can remove a item from the trolley that he/she did not want anymore. When a item is removed from the
*    trolley list, that item quantity is automatically update in the store stock list.
* 5) When the user use the 'Check out items in trolley' function, a slip is automatically generated and the trolley
*    is also automatically cleared.
*
*   A UNIQUE FUNCTION INSIDE THE PROGRAM
*   When a new item is added to a specific category, a new object is created from the Items class. That new object
*   is link to specific category example - Pasta, BakingProducts. If a developer try to add a item that link to specific
*   category to another category list in the main class via programming the IDE will see it as error.
*   Example - macaroni is object that is created of the Items class and is link to Category<Pasta>, if you try to add the
*             macaroni object of the Items class to Category<BakingProducts> list the IDE will see it as error.
*   Reason - The Category<Pasta> is different type and is not the same type as Category<BakingProducts>.
*  */

package com.mansterdevelopers;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //Create object of the Scanner class to read the user input.
    private static Scanner scanner = new Scanner(System.in);
    //Create Pasta Category.
    static Category<Pasta> pastaCategory = new Category<>("Pasta`s Category");
    //Create Baking Products Category.
    static Category<BakingProducts> bakingProductsCategory = new Category<>("Baking Products Category");
    //Create Kitchen Cleaners Category.
    static Category<KitchenCleaners> kitchenCleanersCategory = new Category<>("Kitchen Cleaners Category");
    //Create BathAidsToiletries Category.
    static Category<BathAidsToiletries> bathAidsToiletriesCategory = new Category<>("BathAidsToiletries Category");
    //Create Store Stock List to add Categories.
   static StoreStock<Category> storeStock = new StoreStock<>("Manie Store Stock List");
   //Create new object of Trolley class to add items to the trolley list.
    static Trolley trolley = new Trolley("Trolley");

   //Declare class variables;
    static boolean quit = false;
    static int selection = 0;


    public static void main(String[] args) {

        /*Import store default stock, when program start. The stock list is only store temporary in the computer memory,
        while the program is running. I will implement in the future a function to store the stock list in a database or
        in text file.*/
        System.out.println("********************WELCOME BY MANIE ONLINE GROCERY STORE********************\n");
        System.out.println("Import Default Stock....");
        importStoreStock();
        System.out.println("\n*****************************************************************************");
        //Automatically add the categories to the store stock list.
        addCategoriesToStockList();
        //Starting menu for this program.
        mainMenuFunction();
    }

    //Method to print MainMenu Text
    private static void showMainMenu(){
        System.out.println("\n*******************MAIN MENU****************************\n" +
                "Press.. \n" +
                "0) Go to Manage Stock Menu.\n" +
                "1) Go to Shop online Menu.\n" +
                "2) Exit Store.\n");
        System.out.println("*********************************************************\n");
        System.out.print("Make a Selection: ");
    }

    //Method to control MainMenu Functions
    public static void mainMenuFunction(){
        quit = false;
        selection = 0;
        while(!quit){
            showMainMenu();
            try {
                selection = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please select only numbers that is in the Menu. Please Try again.");
                scanner.nextLine();
                continue;
            }
            switch (selection){
                case 0:
                    //Go to Stock Menu
                    manageStockMenuFunctions();
                    quit = true;
                    break;
                case 1:
                    //Go to shop online Menu
                    shopOnlineMenuFunctions();
                    break;
                case 2:
                    //Exit Store
                    quit = true;
                    break;
                default:
                    //Display error message
                    System.out.println("Wrong Number Selection, Please Select only number in the Menu");
                    break;
            }
        }
    }

    //Method to print showManageStockMenu() Text
    private static void showManageStockMenu(){
        System.out.println("\n********************MANAGE STORE STOCK MENU********************");
        System.out.println("Press..\n" +
                "0) Add new items to the store stock list.\n" +
                "1) Check how many items is their under each category.\n" +
                "2) Update a item stock level under specific category\n" +
                "3) Remove a item from the store stock list.\n" +
                "4) Display all the items under Pasta Category.\n" +
                "5) Display all the items under Baking Products Category.\n" +
                "6) Display all the items under Kitchen Cleaners Category.\n" +
                "7) Display all the items under Bath Aid Toiletries Category.\n" +
                "8) Check Stock Counts against other Category stock counts.\n" +
                "9) Display Categories accordance Stock level from High to Low.\n" +
                "10) Go back to Main Menu.\n" +
                "11) Exit Store");
        System.out.println("***************************************************************\n");
        System.out.print("Make a Selection: ");
    }

    //Method to control Manage Stock Menu functions
    public static void manageStockMenuFunctions(){
        quit = false;
        selection = 0;
        while(!quit){
            showManageStockMenu();
            try {
                selection = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please select only numbers that is in the Menu. Please Try again.");
                scanner.nextLine();
                continue;
            }
            switch (selection){
                case 0:
                    //Add new items
                    categoryMenuFunctions();
                    break;
                case 1:
                    //Display the total number of items under each category
                    displayTotalItemsUnderCategories();
                    break;
                case 2:
                    //Update a item stock under a specific category
                    updateItemStockLevel(true);
                    break;
                case 3:
                    //Remove a item from the store stock list
                      updateItemStockLevel(false);
                      break;

                case 4:
                    //Display items under pasta category
                    displayAllItemsUnderCategory(0, true);
                    break;
                case 5:
                    //Display items under Baking Products category
                    displayAllItemsUnderCategory(1, true);
                    break;
                case 6:
                    //Display items under Kitchen Cleaners category
                    displayAllItemsUnderCategory(2, true);
                    break;
                case 7:
                    //Display items under Bath Aid Toiletries category
                    displayAllItemsUnderCategory(3, true);
                    break;
                case 8:
                    //Check stock count against other category stock counts.
                    checkCategoryAgainstOther();
                    break;
                case 9:
                    //Display Categories accordance Stock level from High to Low.
                    displayCategoriesFromHighToLow();
                    break;
                case 10:
                    //Go back to Main Menu.
                    mainMenuFunction();
                    quit = true;
                    break;
                case 11:
                    //Exit Store
                    quit = true;
                    break;
                default:
                    //Display error message
                    System.out.println("Wrong Number Selection, Please Select only number in the Menu");
                    break;
            }
        }
    }

    //Method to print showCategoryMenu() text
    private static void showCategoryMenu(){
        System.out.println("Press..\n" +
                "0) Pasta Category\n" +
                "1) Baking Products Category\n" +
                "2) Kitchen Cleaners Category\n" +
                "3) Bath Aid Toiletries Category\n");
        System.out.print("Make a Selection: ");
    }

    public static void categoryMenuFunctions(){
        quit = false;
        selection = 0;
        while(!quit){
            System.out.println("\nSelect a Category where you want to add the new items: ");
            showCategoryMenu();
            try {
                selection = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please select only numbers that is in the Menu. Please Try again.");
                scanner.nextLine();
                continue;
            }
            switch (selection){
                case 0:
                    //Add item to Paste Category
                    addNewItemsToStockList(0);
                    manageStockMenuFunctions();
                    quit = true;
                    break;
                case 1:
                    //Add item to Baking Product Category
                    addNewItemsToStockList(1);
                    manageStockMenuFunctions();
                    quit = true;
                    break;
                case 2:
                    //Add item to Kitchen Cleaners Category
                    addNewItemsToStockList(2);
                    manageStockMenuFunctions();
                    quit = true;
                    break;
                case 3:
                    //Add item to Bath Aid Toiletries Category
                    addNewItemsToStockList(3);
                    manageStockMenuFunctions();
                    quit = true;
                    break;
                default:
                    //Display error message
                    System.out.println("Wrong Number Selection, Please Select only numbers that is in the Menu");
                    break;
            }
        }
    }

    //Method to add new items to store stock list.
    private static void addNewItemsToStockList(int number){
        //Create object (df) of the DecimalFormat class to format the price of items accordance currency format.
        DecimalFormat df = new DecimalFormat("#.00");
        //Ask user the required inputs to add a new item.
        System.out.print("\nPlease enter the Product Name: ");
        String itemName = scanner.nextLine();
        System.out.print("\nPlease enter the " + itemName + " description: ");
        String itemDescription = scanner.nextLine();
        System.out.print("\nPlease enter quantity for " + itemName + " :");
        int itemQuantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\nPlease enter the price for " + itemName + " :");
        double itemPrice = scanner.nextDouble();
        scanner.nextLine();
        df.format(itemPrice);

        //Add the new item to specific Category accordance the user request.
        switch (number){
            case 0:
                //Create a new object of the Pasta class and add item to the pasta category.
                Pasta itemPasta  = new Pasta(itemName, itemDescription, itemQuantity, itemPrice);
                pastaCategory.addItems(itemPasta);
                break;
            case 1:
                //Create a new object of the Baking Products class and add item to the Baking Products category.
                BakingProducts itemBakingProducts = new BakingProducts(itemName, itemDescription, itemQuantity, itemPrice);
                bakingProductsCategory.addItems(itemBakingProducts);
                break;
            case 2:
                //Create a new object of the Kitchen Cleaners class and add the item to the Kitchen Cleaner category.
                KitchenCleaners itemKitchenCleaner = new KitchenCleaners(itemName, itemDescription, itemQuantity, itemPrice);
                kitchenCleanersCategory.addItems(itemKitchenCleaner);
                break;
            case 3:
                //Create a new object of the Bath Aid Toiletries class and add the item to the Bath Aid Category.
                BathAidsToiletries itemBathAidToiletries = new BathAidsToiletries(itemName, itemDescription, itemQuantity, itemPrice);
                bathAidsToiletriesCategory.addItems(itemBathAidToiletries);
                break;
        }
    }

    //Method to display the total number of items under each category
    private static void displayTotalItemsUnderCategories(){
        System.out.println("Please select a category to check the stock: ");
        showCategoryMenu();
        try{
            selection = scanner.nextInt();
            scanner.nextLine();
        }  catch (InputMismatchException e){
            System.out.println("Please select only numbers that is in the Menu.");
            showCategoryMenu();
        }
        displayAllItemsUnderCategory(selection, false);
    }



    //Method to display all the items under a category accordance user selection.
    private static void displayAllItemsUnderCategory(int categoryNumber, boolean displayItemInDetail){
        switch (categoryNumber){
            case 0:
                //Print all the items in detail under Pasta Category - prices, description of items.
                if(displayItemInDetail){
                    pastaCategory.printStockInDetail();
                }else {
                    //Print all the items under Pasta Category
                    System.out.println("\nTotal products under " + pastaCategory.getName() + " is: " + pastaCategory.getCategoryCount());
                    pastaCategory.printStockCountUnderEachCategory();
                }
                break;
            case 1:
                //Print all the items in detail under Baking Products Category - prices, description of items.
                if(displayItemInDetail){
                    bakingProductsCategory.printStockInDetail();
                }else {
                    //Print all the items under Baking Products Category
                    System.out.println("\nTotal products under " + bakingProductsCategory.getName() + " is: " + bakingProductsCategory.getCategoryCount());
                    bakingProductsCategory.printStockCountUnderEachCategory();
                }
                break;
            case 2:
                //Print all the items in detail under Kitchen Cleaner Category - prices, description of items.
                if(displayItemInDetail){
                    kitchenCleanersCategory.printStockInDetail();
                }else {
                    //Print all the items under Kitchen Cleaner Category
                    System.out.println("\nTotal products under " + kitchenCleanersCategory.getName() + " is: " + kitchenCleanersCategory.getCategoryCount());
                    kitchenCleanersCategory.printStockCountUnderEachCategory();
                }
                break;
            case 3:
                //Print all the items in detail under Bath Aid Toiletries Category - prices, description of items.
                if(displayItemInDetail){
                    bathAidsToiletriesCategory.printStockInDetail();
                }else {
                    //Print all the items under Bath Aid Toiletries Category
                    System.out.println("\nTotal products under " + bathAidsToiletriesCategory.getName() + " is: " + bathAidsToiletriesCategory.getCategoryCount());
                    bathAidsToiletriesCategory.printStockCountUnderEachCategory();
                }
                break;
        }
    }

    //Method to check two categories against them stock count.
    private static void checkCategoryAgainstOther() {
        int userSelection1 = 0;
        int userSelection2 = 0;
        Category category1 = null;
        Category category2 = null;

        //Use loop to get the user input for the 2 categories to compare.
        for (int i = 0; i <= 1; i++) {
            System.out.println("Please Select Category " + (i + 1) + " that you like to compare their stock count: ");
            showCategoryMenu();
            try {
                if (i == 0) {
                    userSelection1 = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    userSelection2 = scanner.nextInt();
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                //Invalid user Input, throw error message.
                System.out.println("Wrong Selection, Select only the numbers that in the Menu: ");
                break;
            }
        }

        /*Ensure only that valid numbers that is stored in userSelection 1 & userSelection2 variables
          go through the next block of code */
        if ((userSelection1 >= 0) && (userSelection1 <= 3) && (userSelection2 >= 0) && (userSelection2 <= 3)) {
            //Determine the first object of Category class
            if (userSelection1 == 0) {
                category1 = pastaCategory;
            } else if (userSelection1 == 1) {
                category1 = bakingProductsCategory;
            } else if (userSelection1 == 2) {
                category1 = kitchenCleanersCategory;
            } else {
                category1 = bathAidsToiletriesCategory;
            }

            //Determine the second object of Category class
            if (userSelection2 == 0) {
                category2 = pastaCategory;
            } else if (userSelection2 == 1) {
                category2 = bakingProductsCategory;
            } else if (userSelection2 == 2) {
                category2 = kitchenCleanersCategory;
            } else {
                category2 = bathAidsToiletriesCategory;
            }

            //Check Category stock count against other category stock count
            category1.compareEachCategoryAccordanceStockCount(category2,
                    category1.getStockCountUnderEachCategory(), category2.getStockCountUnderEachCategory());
        }
        else{
            System.out.println("Wrong numbers selection, Please try again.");
        }
    }

    //Add all Categories Stock to the Store Stock List.
    private static void addCategoriesToStockList(){
        //Add Categories to the Store Stock List
        storeStock.addStock(pastaCategory);
        storeStock.addStock(bakingProductsCategory);
        storeStock.addStock(kitchenCleanersCategory);
        storeStock.addStock(bathAidsToiletriesCategory);
    }

    //Display categories in the store stock list from High to Low accordance stock level
    private static void displayCategoriesFromHighToLow(){
        System.out.println("******DISPLAY CATEGORIES STOCK COUNT FROM HIGH TO LOW******");
        storeStock.sortStock();
        System.out.println("***********************************************************");
    }

    /*Method to import store default stock, when program start. The stock list is only store temporary in the computer RAM,
      while the program is running. I will implement in the future a function to store the stock list in a database or
      in text file.*/
    private static void importStoreStock(){
        //Pasta Category Stock
        Pasta noodles = new Pasta("Spar 2 Minute Noodles","Ready to serve in 2 minutes", 50, 4.50);
        Pasta spaghetti = new Pasta("Spar Spaghetti", "Make from good natural products", 100, 8.99);
        Pasta macaroni = new Pasta("Spar Macaroni", "Make from good natural products", 75, 8.50);

        //Baking Products Stock
        BakingProducts bakeSoda = new BakingProducts("Baking Soda", "Is good all purposes of baking", 25, 21.50);
        BakingProducts cakeFlower = new BakingProducts("SunFlower Cake Flower", "Is made from good maize", 50, 35.00);
        BakingProducts cookAndSpray = new BakingProducts("Spray and Cook", "Is good for non-stick pans", 20, 32.50);

        //Kitchen Cleaners Stock
        KitchenCleaners dishWashingLiquid = new KitchenCleaners("Sunlight Liquid", "1 Bottle can was 200 dishes",
                15, 20.00);
        KitchenCleaners jik = new KitchenCleaners("Jik", "Very good product", 35, 42.00);
        KitchenCleaners ovenCleaner = new KitchenCleaners("Mr Bean Oven Cleaner", "Good for deep stains", 10, 52.50);

        //Bath Aid Toiletries Stock
        BathAidsToiletries  doveSoap = new BathAidsToiletries("Dove Soap 100g", "Dove Gentle Exfoliating bar" +
                " gently washes away dead skin", 80, 12.95);
        BathAidsToiletries niveaShowerGel = new BathAidsToiletries("Nivea Shower Gel 250ml", "Is specially designed" +
                " for men and offers long lasting freshness", 60, 36.95);
        BathAidsToiletries bathOil = new BathAidsToiletries("Soluble Bath Oil 500ml", "Suitable for all Skin types",
                25, 39.95);

        //Add pasta Items
        pastaCategory.addItems(noodles);
        pastaCategory.addItems(spaghetti);
        pastaCategory.addItems(macaroni);

        //Add Baking Products Items
        bakingProductsCategory.addItems(bakeSoda);
        bakingProductsCategory.addItems(cakeFlower);
        bakingProductsCategory.addItems(cookAndSpray);

        //Add Kitchen Cleaners Items
        kitchenCleanersCategory.addItems(dishWashingLiquid);
        kitchenCleanersCategory.addItems(jik);
        kitchenCleanersCategory.addItems(ovenCleaner);

        //Add BathAidsToiletries Items
        bathAidsToiletriesCategory.addItems(doveSoap);
        bathAidsToiletriesCategory.addItems(niveaShowerGel);
        bathAidsToiletriesCategory.addItems(bathOil);
    }

    //Method to print shopOnlineMenu() text
    private static void shopOnlineMenu(){
        System.out.println("\n***********************SHOP ONLINE MENU***********************");
        System.out.println("Press..\n" +
                "0) Display all the items under Pasta Category.\n" +
                "1) Display all the items under Baking Products Category.\n" +
                "2) Display all the items under Kitchen Cleaners Category.\n" +
                "3) Display all the items under Bath Aid Toiletries Category.\n" +
                "4) Add items to the Trolley.\n" +
                "5) Display items that is in the Trolley.\n" +
                "6) Remove a item from the Trolley.\n" +
                "7) Check out items in Trolley.\n" +
                "8) Go back to Main Menu.\n" +
                "9) Exit Store.\n");
        System.out.println("***************************************************************\n");
        System.out.print("Make a Selection: ");
    }

    private static void shopOnlineMenuFunctions(){
        quit = false;
        while(!quit){
            shopOnlineMenu();
            try{
                selection = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Please select only numbers that is in the Menu. Please Try again.");
                scanner.nextLine();
                continue;
            }

            switch (selection){
                case 0:
                    //Display all items in the Pasta Category
                    displayAllItemsUnderCategory(0, true);
                    break;
                case 1:
                    //Display all items in the Baking Products Category
                    displayAllItemsUnderCategory(1, true);
                    break;
                case 2:
                    //Display all items in the Kitchen Cleaners Category
                    displayAllItemsUnderCategory(2, true);
                    break;
                case 3:
                    //Display all items in the Bath Aid Toiletries Category
                    displayAllItemsUnderCategory(3, true);
                    break;
                case 4:
                    //Add items to the trolley
                    searchForItemToAdd();
                    break;
                case 5:
                    //Display all the items that is in the trolley
                    trolley.printItemsInTrolley();
                    break;
                case 6:
                    //Remove a item in the trolley.
                    System.out.println("Please enter the name of the item to be remove from the trolley : ");
                    String nameOfItem = scanner.nextLine();
                    //use method to remove the item from the trolley.
                    trolley.removeItemInTrolley(nameOfItem);
                    break;
                case 7:
                    //Generate Slip.
                    trolley.generateSlip();
                    //Empty the trolley
                    trolley.emptyTrolley();
                    break;
                case 8:
                    //Go back to the Main Menu
                    mainMenuFunction();
                    break;
                case 9:
                    //Exit the Store
                    quit = true;
                    break;
                default:
                    //Display error message
                    System.out.println("Wrong Number Selection, Please Select only number in the Menu");
                    break;
            }
        }
    }

    /*This Method search for a item name(that the user have to type in). If the item is found in the specific
    category accordance user selection, than the item is add to the trolley list. The method handle also the
    InputMisMatchExceptions.*/
    private static void searchForItemToAdd(){
        //Ask the user in what category is the item that he/she will add to the trolley.
        System.out.println("Please select a category to add items to the trolley.");
        showCategoryMenu();

        //Handle InputMisMatchExceptions
        try {
            selection = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e){
            System.out.println("Please select only the numbers that is in the Menu. Please try again.");
            showCategoryMenu();
        }

        //Create variables to store the user inputs.
        String nameOfItem = "";
        int numberOfItems = 0;

        /*The switch is uses to go in the specific category where item is that the user would like to the trolley.
           Than do the necessary processing to add the item and the quantity of the item to the trolley list. */
                switch (selection){
            case 0: //Pasta Category
                //Display all the items in pasta category to make it easier to add items to the trolley.
                displayAllItemsUnderCategory(0, true);
                System.out.println("Please enter the name of the item that you like to add to the Trolley: ");
                nameOfItem = scanner.nextLine();
                if(pastaCategory.findItemInStore(nameOfItem) != null){
                    System.out.println("How many items of " + nameOfItem + " would you like to add to the trolley: ");
                    try{
                        numberOfItems = scanner.nextInt();
                        scanner.nextLine();
                    } catch(InputMismatchException e){
                        System.out.println("Please type only numbers in as input.");
                        break;
                    }
                    //Use method in Trolley class to add the item in the pasta category to the trolley list.
                    trolley.addItemsToTrolley(pastaCategory.findItemInStore(nameOfItem), numberOfItems);
                } else{
                    System.out.println(nameOfItem + " is found the store stock list.");
                }
                break;

                    case 1: //Baking Products Category
                        //Display all the items in baking products category category to make it easier to add items to the trolley.
                        displayAllItemsUnderCategory(1, true);
                        System.out.println("Please enter the name of the item that you like to add to the Trolley: ");
                        nameOfItem = scanner.nextLine();
                        if(bakingProductsCategory.findItemInStore(nameOfItem) != null){
                            System.out.println("How many items of " + nameOfItem + " would you like to add to the trolley: ");
                            try{
                                numberOfItems = scanner.nextInt();
                                scanner.nextLine();
                            } catch(InputMismatchException e){
                                System.out.println("Please type only numbers in as input.");
                                break;
                            }
                            //Use method in Trolley class to add the item in the baking products category to the trolley list.
                            trolley.addItemsToTrolley(bakingProductsCategory.findItemInStore(nameOfItem), numberOfItems);
                        } else{
                            System.out.println(nameOfItem + " is found the store stock list.");
                        }
                        break;

                    case 2: //Kitchen Cleaners Category
                        //Display all the items in kitchen cleaners category to make it easier to add items to the trolley.
                        displayAllItemsUnderCategory(2, true);
                        System.out.println("Please enter the name of the item that you like to add to the Trolley: ");
                        nameOfItem = scanner.nextLine();
                        if(kitchenCleanersCategory.findItemInStore(nameOfItem) != null){
                            System.out.println("How many items of " + nameOfItem + " would you like to add to the trolley: ");
                            try{
                                numberOfItems = scanner.nextInt();
                                scanner.nextLine();
                            } catch(InputMismatchException e){
                                System.out.println("Please type only numbers in as input.");
                                break;
                            }
                            //Use method in Trolley class to add the item in the kitchen cleaners category to the trolley list.
                            trolley.addItemsToTrolley(kitchenCleanersCategory.findItemInStore(nameOfItem), numberOfItems);
                        } else{
                            System.out.println(nameOfItem + " is found the store stock list.");
                        }
                        break;

                    case 3: //Bath Aid Toiletries Category
                        //Display all the items in bath aid toiletries category to make it easier to add items to the trolley.
                        displayAllItemsUnderCategory(3, true);
                        System.out.println("Please enter the name of the item that you like to add to the Trolley: ");
                        nameOfItem = scanner.nextLine();
                        if(bathAidsToiletriesCategory.findItemInStore(nameOfItem) != null){
                            System.out.println("How many items of " + nameOfItem + " would you like to add to the trolley: ");
                            try{
                                numberOfItems = scanner.nextInt();
                                scanner.nextLine();
                            } catch(InputMismatchException e){
                                System.out.println("Please type only numbers in as input.");
                                break;
                            }
                            //Use method in Trolley class to add the item in the bath aid toiletries category to the trolley list.
                            trolley.addItemsToTrolley(bathAidsToiletriesCategory.findItemInStore(nameOfItem), numberOfItems);
                        } else{
                            System.out.println(nameOfItem + " is found the store stock list.");
                        }
                        break;
        }
    }

    /*Method is to update a item stock level and to remove a item from the store list.
    * Reason for this multi purpose method is to minimize repeatable code by using boolean variable.*/
    private static void updateItemStockLevel(boolean updateItem){
        if(updateItem) {
            //Ask user for the name of the item to update stock level
            System.out.println("Please enter the name of the item to update stock level: ");
        } else{
            //Ask user for the name of the item to be remove.
            System.out.println("Please enter the name of the item to be remove from the stock list");
        }
        String nameOfItem = scanner.nextLine();

        //Check if the item is in the pasta category list
        if(pastaCategory.findItemInStore(nameOfItem) != null){
            if(updateItem) {
                pastaCategory.updateItemStockLevel(nameOfItem, getUpdateStockNumber(nameOfItem));
            } else{
                pastaCategory.removeItem(nameOfItem);
            }

            //Check if the item is in the baking products category list
        }else if(bakingProductsCategory.findItemInStore(nameOfItem) != null){
            if(updateItem) {
                bakingProductsCategory.updateItemStockLevel(nameOfItem, getUpdateStockNumber(nameOfItem));
            } else{
                bakingProductsCategory.removeItem(nameOfItem);
            }

            //Check if the item is in the kitchen cleaners category list
        }else if(kitchenCleanersCategory.findItemInStore(nameOfItem) != null){
            if(updateItem) {
                kitchenCleanersCategory.updateItemStockLevel(nameOfItem, getUpdateStockNumber(nameOfItem));
            } else{
                kitchenCleanersCategory.removeItem(nameOfItem);
            }

            //Check if the item is in the bath aid toiletries category list
        }else if(bathAidsToiletriesCategory.findItemInStore(nameOfItem) != null){
            if(updateItem) {
                bathAidsToiletriesCategory.updateItemStockLevel(nameOfItem, getUpdateStockNumber(nameOfItem));
            } else{
                bathAidsToiletriesCategory.removeItem(nameOfItem);
            }

            //Inform user that item is not the store stock list, advice user to add the item.
        } else{
            System.out.println(nameOfItem + " is not in the store stock list.");
        }
    }

    //Method to get update Stock number from user and minimize repeatable codes.
    private static int getUpdateStockNumber(String nameOfItem){
        int stockCount = 0;
        System.out.println("Please enter the stock count for " + nameOfItem + " :");
        try{
            stockCount =  scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e){
            System.out.println("Please type only numbers in.");
        }
        return stockCount;
    }

}
