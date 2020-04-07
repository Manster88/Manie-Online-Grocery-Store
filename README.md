# Manie-Online-Grocery-Store
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
