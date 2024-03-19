import java.util.Scanner;


/**
 * This class is used to manage an item registry.
 * It contains methods to add, delete, search, increase,
 * decrease and change price of items in the registry.
 *
 * @author Lars Mikkel Lødeng Nilsen
 * @since 11.12.2022
 */
public class Main {
  /**
   * The item registry containing the items.
   */
  ItemRegistry items = new ItemRegistry();
  /**
   * A Scanner object used to read user input.
   */
  Scanner sc = new Scanner(System.in);
  private final String invalidInput = "Invalid input.\nTry again!\n";
  private final String itemNotExist = "There dose not exist a item with that item number."
      + "\nTry again!\n";
  private final String to = " to: ";
  private final String tryAgain = "\nTry again!\n";
  /**
   * The main method of the class.
   * It is used to call other methods to manage the item registry.
   *
   * @param args the arguments passed to the main method
   */

  public static void main(String[] args) {
    Main main = new Main();
    try {
      main.testData();
    } catch (IllegalArgumentException iae) {
      System.out.println("Invalid input in testData. No items added.");
    }
    main.menu();
  }

  /**
   * A method used to add items to the item registry.
   */
  private void testData() {
    items.addItem("abc-321", "2x4 lumber", 600, "Holm AS", 50, 5, 0.02, "yellow", 20, 4, 0);
    items.addItem("fse-434", "door", 2000, "IKEA", 80, 1, 2, "white", 5, 3, 0);
    items.addItem("juh-185", "window", 1400, "ByggMax", 40, 1.4, 1.6, "white", 9, 2, 0);
    items.addItem("kbe-658", "floor laminate", 300, "Byggmakker", 20, 5, 0.02, "black", 45, 1, 0);
  }

  /**
   * A method displaying the main menu used to manage the item registry.
   */
  private void menu() {
    boolean flag = true;
    int choice;

    while (flag) {
      System.out.println("\n(1): See all items.");
      System.out.println("(2): Search items.");
      System.out.println("(3): Add a new item.");
      System.out.println("(4): Delete a item.");
      System.out.println("(5): Increase number of a item.");
      System.out.println("(6): Decrease number of a item.");
      System.out.println("(7): Change price of a item.");
      System.out.println("(8): Change discount for a item");
      System.out.println("(9): Quit");

      try {
        choice = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException nfe) {
        System.out.println(invalidInput);
        continue;
      }

      switch (choice) {
        case 1 -> seeAllItems();
        case 2 -> searchItems();
        case 3 -> addItem();
        case 4 -> deleteItem();
        case 5 -> increaseNumberOfAnItem();
        case 6 -> decreaseNumberOfAnItem();
        case 7 -> changePrice();
        case 8 -> changeDiscount();
        case 9 -> flag = false;
        default -> System.out.println("You must enter a number between 1 and 9.\nTry again!");
      }
    }
  }

  /**
   * A method used to display all items in the item registry.
   */
  private void seeAllItems() {
    if (items.toString().equals("")) {
      System.out.println("There are no items in the register.");
    } else {
      System.out.println(items.toString());
    }
  }

  /**
   * A method used to display all item numbers in the item registry.
   */
  private void getAllItemNumbers() {
    System.out.println("Item numbers of all items in the register:");
    System.out.println(items.getAllItemNumbers() + "\n");
  }

  /**
   * This method displays a menu and prompts the user to input a number
   * between 1 and 2 to search for items.
   * If the user inputs 1, then the program moves to the getItemWithItemNumber() method.
   * If the user inputs 2, then the program moves to the getItemWithDescription() method.
   */
  private void searchItems() {
    int choice = 0;
    while (true) {
      System.out.println("(1) Search for items based on item number.");
      System.out.println("(2) Search for items based on description.");
      try {
        choice = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException nfe) {
        System.out.println(invalidInput);
        continue;
      }
      switch (choice) {
        case 1 -> getItemWithItemNumber();
        case 2 -> getItemWithDescription();
        default -> {
          System.out.println("You must enter a number between 1 and 2.\n");
          continue;
        }
      }
      break;
    }
  }

  /**
   * This method retrieves an item from the inventory based on the item number provided by the user.
   */
  private void getItemWithItemNumber() {
    while (true) {
      getAllItemNumbers();
      System.out.print("Item number: ");
      String itemNumber = sc.nextLine();
      if (items.getItemWithItemNumber(itemNumber) != null) {
        System.out.println("Item with item number '" + itemNumber + "':\n"
            + items.getItemWithItemNumber(itemNumber).toString());
        break;
      } else {
        System.out.println("No item with item number: " + itemNumber + tryAgain);
      }
    }
  }

  /**
   * This method retrieves an item from the inventory based on the description provided by the user.
   */
  private void getItemWithDescription() {
    while (true) {
      System.out.println("Descriptions of all items in the register.");
      System.out.println(items.getAllDescriptions());
      System.out.print("\nDescription: ");
      String description = sc.nextLine();
      if (items.getItemWithDescription(description) != null) {
        System.out.println("Item whit the description '" + description + "':\n"
            + items.getItemWithDescription(description).toString());
        break;
      } else {
        System.out.println("No item with description: " + description + tryAgain);
      }
    }
  }

  /**
   * Adds a new item to the list of items.
   * Prompts the user to enter the item number, description, price,
   * brand name, weight, length, height, color, amount in stock, and category.
   * Discount percentage is also prompted and should have a value between 0 and 100.
   * Category should have a value between 1 and 4,
   * where 1 is Floor Laminates, 2 is Windows, 3 is Doors, and 4 is Lumber.
   */
  private void addItem() {
    System.out.println("Add new item:");
    String itemNumber = stringVariableForAddItem("Item number: ");
    if (items.getItemWithItemNumber(itemNumber) != null) {
      System.out.println("\nItem already exists.");
    } else {
      String description = stringVariableForAddItem("Description: ");

      int price = integerVariableForAddItem("Price: ");

      String brandName = stringVariableForAddItem("Brand name: ");

      double weight = doubleVariableForAddItem("Weight: ");

      double length = doubleVariableForAddItem("Length: ");

      double height = doubleVariableForAddItem("Height: ");

      double discountPercent = discountVariableForAddItem();

      String color = stringVariableForAddItem("Color: ");

      int amountInStock = integerVariableForAddItem("Amount in stock: ");

      int category = categoryVariableForAddItem();

      items.addItem(itemNumber, description, price, brandName, weight,
          length, height, color, amountInStock, category, discountPercent);
    }
  }

  /**
   * Helper function for addItem() that takes in a String attribute
   * and prompts the user to enter a String value for the attribute.
   * The value cannot be an empty String.
   *
   * @param attribute The attribute for which the user is prompted to enter a String value.
   * @return The String value for the attribute.
   */
  private String stringVariableForAddItem(String attribute) {
    String attributeVariable = "";
    while (true) {
      System.out.print(attribute);
      attributeVariable = sc.nextLine();
      if (!attributeVariable.isBlank()) {
        break;
      }
      System.out.println("The variable can't be blank.\nTry again!\n");
    }
    return attributeVariable;
  }

  /**
   * Helper function for addItem() that takes in a String attribute
   * and prompts the user to enter a double value for the attribute.
   * The value cannot be a negative number.
   *
   * @param attribute The attribute for which the user is prompted to enter a double value.
   * @return The double value for the attribute.
   */

  private double doubleVariableForAddItem(String attribute) {
    double attributeValue = 0;
    while (true) {
      System.out.print(attribute);
      try {
        attributeValue = Double.parseDouble(sc.nextLine());
      } catch (NumberFormatException nfe) {
        System.out.println(invalidInput);
        continue;
      }
      if (attributeValue < 0) {
        System.out.println("This value can't be a negative number.\nTry again!\n");
      } else {
        break;
      }
    }
    return attributeValue;
  }

  /**
   * Helper function for addItem() that takes in a String attribute
   * and prompts the user to enter an integer value for the attribute.
   * The value cannot be a negative number.
   *
   * @param attribute The attribute for which the user is prompted to enter an integer value.
   * @return The integer value for the attribute.
   */
  private int integerVariableForAddItem(String attribute) {
    int attributeValue = 0;
    while (true) {
      System.out.print(attribute);
      try {
        attributeValue = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException nfe) {
        System.out.println(invalidInput);
        continue;
      }
      if (attributeValue < 0) {
        System.out.println("This value can't be a negative number.\nTry again!\n");
      } else {
        break;
      }
    }
    return attributeValue;
  }

  /**
   * Helper function for addItem() that prompts the user
   * to enter a double value for the discount percentage.
   * The value must have a value between 0 and 100.
   *
   * @return The double value for the discount percentage.
   */
  private double discountVariableForAddItem() {
    double discountPercentage = 0;
    while (true) {
      System.out.print("Discount (percent): ");
      try {
        discountPercentage = Double.parseDouble(sc.nextLine());
      } catch (NumberFormatException nfe) {
        System.out.println(invalidInput);
        continue;
      }
      if (discountPercentage < 0 || discountPercentage > 100) {
        System.out.println("DiscountPercentage must have a value between 0 and 100.\nTry again!\n");
      } else {
        break;
      }
    }
    return discountPercentage;
  }

  /**
   * Helper function for addItem() that prompts the user to enter an integer value for the category.
   * The value must have a value between 1 and 4, where 1 is Floor Laminates,
   * 2 is Windows, 3 is Doors, and 4 is Lumber.
   *
   * @return The integer value for the category.
   */
  private int categoryVariableForAddItem() {
    int category = 0;
    while (true) {
      System.out.print("(1): Floor laminates\n(2): Windows\n(3): Doors\n(4): Lumber\nCategory: ");
      try {
        category = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException nfe) {
        System.out.println(invalidInput);
        continue;
      }
      if (category < 1 || category > 4) {
        System.out.println("Category must have a value between 1 and 4.\nTry again!\n");
      } else {
        break;
      }
    }
    return category;
  }
  /**
   * Deletes an item from the register given an item number.
   * This method prompts the user to enter an item number
   * and then displays a confirmation prompt. If the user confirms
   * the item is deleted from the register. Otherwise, the user is returned to the menu.
   */

  private void deleteItem() {
    int choice2 = 0;
    getAllItemNumbers();
    while (true) {
      boolean flag = true;
      System.out.println("(1): Exit to menu.");
      System.out.print("Item number of item you want to delete: ");
      String itemNumber = sc.nextLine();
      if (itemNumber.equals("1")) {
        break;
      }
      if (items.getItemWithItemNumber(itemNumber) == null) {
        System.out.println(itemNotExist);
        continue;
      }
      while (flag) {
        System.out.println("Are you sure you want to delete item: '" + itemNumber + "'?");
        System.out.println("(1): YES!");
        System.out.println("(2): NO!");
        try {
          choice2 = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException nfe) {
          System.out.println(invalidInput);
          continue;
        }

        switch (choice2) {
          case (1):
            items.deleteItem(itemNumber);
            System.out.println("'" + itemNumber + "' has been deleted from the register.");
            flag = false;
            break;
          case (2):
            flag = false;
            break;
          default:
            System.out.println("You must enter a number between 1 and 2.");
        }
      }
    }
  }



  /**
   * This method is used to increase the number of a specific item in stock.
   * It takes a user provided item number and asks how much to increase the item by.
   * If the user provides an invalid input or a negative number, they will be prompted to try again.
   * If the item number provided is valid, then the
   * amount in stock of the item is increased by the given amount.
   */
  private void increaseNumberOfAnItem() {
    boolean flag = true;
    int change = 0;
    getAllItemNumbers();
    do {
      System.out.print("Item number of the item you want to increase number of in stock: ");
      String itemNumber = sc.nextLine();
      if (items.getItemWithItemNumber(itemNumber) == null) {
        System.out.println(itemNotExist);
        continue;
      }
      while (true) {
        System.out.println(items.getItemWithItemNumber(itemNumber).toString());
        System.out.print("How much do you want to increase item '" + itemNumber + "' with: ");
        try {
          change = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException nfe) {
          System.out.println(invalidInput);
          continue;
        }
        if (change >= 0) {
          System.out.println("The amount in stock for item '" + itemNumber + "' is changed from: "
              + items.getItemWithItemNumber(itemNumber).getAmountInStock()
              + to + (items.getItemWithItemNumber(itemNumber).getAmountInStock() + change));

          items.changeAmountInStock(itemNumber, change);
          flag = false;
          break;
        }
        System.out.println("The program does not accept negative numbers for change."
            + tryAgain);
      }
    } while (flag);
  }


  /**
   * This method is used to decrease the number of a specific item in stock.
   * It takes a user provided item number and asks how much to decrease the item by.
   * If the user provides an invalid input or a negative number,
   * they will be prompted to try again. If the item number provided is valid, then the
   * amount in stock of the item is decreased by the given amount.
   * The amount in stock can not be decreased to a negative number.
   */
  private void decreaseNumberOfAnItem() {
    boolean flag = true;
    int change = 0;
    getAllItemNumbers();
    do {
      System.out.print("Item number of the item you want to decrease number of in stock: ");
      String itemNumber = sc.nextLine();
      if (items.getItemWithItemNumber(itemNumber) == null) {
        System.out.println(itemNotExist);
        continue;
      }
      while (true) {
        System.out.println(items.getItemWithItemNumber(itemNumber).toString());
        System.out.print("How much do you want to decrease item '" + itemNumber + "' by: ");
        try {
          change = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException nfe) {
          System.out.println(invalidInput);
          continue;
        }
        if (change >= 0) {
          if ((items.getItemWithItemNumber(itemNumber).getAmountInStock() - change) >= 0) {
            System.out.println("The amount in stock for item '" + itemNumber + "' is changed from: "
                + items.getItemWithItemNumber(itemNumber).getAmountInStock()
                + to + (items.getItemWithItemNumber(itemNumber).getAmountInStock() - change));
            items.changeAmountInStock(itemNumber, -change);
            flag = false;
            break;
          }
          System.out.println("Amount in stock: "
              + items.getItemWithItemNumber(itemNumber).getAmountInStock());
          System.out.println(items.getItemWithItemNumber(itemNumber).getAmountInStock()
              + " - " + change + " = "
              + (items.getItemWithItemNumber(itemNumber).getAmountInStock() - change));
          System.out.println("Amount in stock can't be a negative number.\nTry again!\n");

        }
        System.out.println("The program does not accept negative"
            + "numbers for change.\nTry again!\n");
      }
    } while (flag);
  }


  /**
   * Changes the price of an item.
   * This method will prompt the user to enter the item number
   * of the item they want to change the price of.
   * The user will then be asked to enter the new price for the item.
   * The old price is then compared to the new price,
   * and if the new price is not negative, the price is changed.
   */
  private void changePrice() {
    boolean flag = true;
    int newPrice = 0;
    getAllItemNumbers();
    do {
      System.out.print("Item number of the item you want to change price of: ");
      String itemNumber = sc.nextLine();
      if (items.getItemWithItemNumber(itemNumber) == null) {
        System.out.println(itemNotExist);
        continue;
      }
      while (true) {
        System.out.println(items.getItemWithItemNumber(itemNumber).toString());
        System.out.println("What is the new price for item '" + itemNumber + "': ");
        try {
          newPrice = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException nfe) {
          System.out.println(invalidInput);
          continue;
        }
        if (newPrice >= 0) {
          System.out.println("The price was change from: "
              + items.getItemWithItemNumber(itemNumber).getPrice() + to + newPrice);
          items.changePrice(itemNumber, newPrice);
          flag = false;
          break;
        }
        System.out.println("An item can't have a negative price\nTry again!\n");
      }
    } while (flag);
  }

  /**
   * Changes the discount of an item.
   * This method will prompt the user to enter the item number
   * of the item they want to change the discount on.
   * The user will then be asked to enter the new discount for the item in percent.
   */
  private void changeDiscount() {
    boolean flag = true;
    double newDiscount = 0;
    getAllItemNumbers();
    do {
      System.out.print("Item number of the item you want to change price of: ");
      String itemNumber = sc.nextLine();
      if (items.getItemWithItemNumber(itemNumber) == null) {
        System.out.println(itemNotExist);
        continue;
      }
      while (true) {
        System.out.println(items.getItemWithItemNumber(itemNumber).toString());
        System.out.println("What is the new discount for item '" + itemNumber + "' (in percent): ");
        try {
          newDiscount = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException nfe) {
          System.out.println(invalidInput);
          continue;
        }
        if (newDiscount > 0 && newDiscount < 100) {
          System.out.println("The discount was change from: "
              + items.getItemWithItemNumber(itemNumber).getDiscountPercentage() + to + newDiscount);
          items.changeDiscount(itemNumber, newDiscount);
          flag = false;
          break;
        }
        System.out.println("The discount needs to be between 0 and 100%\nTry again!\n");
      }
    } while (flag);
  }
}

