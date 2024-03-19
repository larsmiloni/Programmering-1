import java.util.ArrayList;

/**
 * ItemRegistry class is used to store and manage a list of items.
 * It provides methods to add, delete, and get items,
 * as well as methods to change the number of items in storage and their prices.
 *
 * @author Lars Mikkel Lødeng Nilsen
 * @since 11.12.2022
 */
public class ItemRegistry {
  private final ArrayList<Item> items;

  /**
   * Creates an instance of ItemRegistry.
   */
  public ItemRegistry() {
    this.items = new ArrayList<>();
  }

  /**
   * Returns a deep copy of the item list.
   *
   * @return a deep copy of the item list
   */
  private ArrayList<Item> getAllItems() {
    final ArrayList<Item> itemList = new ArrayList<Item>();
    for (Item item : this.items) {
      itemList.add(item.itemClone());
    }
    return itemList;
  }

  /**
   * Returns the size of the item list.
   *
   * @return the size of the item list
   */
  private int getItemsSize() {
    return getAllItems().size();
  }

  /**
   * Returns the item with the specified item number.
   *
   * @param itemNumber the item number of the item to return
   * @return the item with the specified item number
   */
  public Item getItemWithItemNumber(String itemNumber) {
    for (int i = 0; i < getItemsSize(); i++) {
      if (items.get(i).getItemNumber().equals(itemNumber)) {
        return items.get(i);
      }
    }
    return null;
  }

  /**
   * Returns the item with the specified description.
   *
   * @param description the description of the item to return
   * @return the item with the specified description
   */
  public Item getItemWithDescription(String description) {
    for (int i = 0; i < getItemsSize(); i++) {
      if (getAllItems().get(i).getDescription().equals(description)) {
        return  getAllItems().get(i);
      }
    }
    return null;
  }

  /**
   * Adds a new item to the item list.
   *
   * @param itemNumber the item number of the item
   * @param description the description of the item
   * @param price the price of the item
   * @param brandName the brand name of the item
   * @param weight the weight of the item
   * @param length the length of the item
   * @param height the height of the item
   * @param color the color of the item
   * @param amountInStock the amount of the item in stock
   * @param category the category of the item
   * @param discountPercentage the discount percentage of the item
   * @throws IllegalArgumentException if an item with the same
   item number already exists in the item list
   */
  public void addItem(String itemNumber, String description, int price,
                      String brandName, double weight, double length, double height,
                      String color, int amountInStock, int category, double discountPercentage)
      throws IllegalArgumentException {

    final Item newItem = new Item(itemNumber, description, price, brandName,
        weight, length, height, color, amountInStock, category, discountPercentage);

    if (this.items.contains(newItem)) {
      return;
    }
    // Adds newItem to itemList
    this.items.add(newItem);
  }

  /**
   * Deletes an item from the item list.
   *
   * @param itemNumber the item number of the item to delete
   */
  public void deleteItem(String itemNumber) {
    items.remove(getItemWithItemNumber(itemNumber));
  }

  /**
   * Changes the amount of an item in storage.
   *
   * @param itemNumber the item number of the item to change
   * @param change the amount to change the item's amount in storage
   */
  public void changeAmountInStock(String itemNumber, int change) {
    Item item = getItemWithItemNumber(itemNumber);
    item.setAmountInStock(item.getAmountInStock() + change);
  }

  /**
   * Changes the price of an item.
   *
   * @param itemNumber the item number of the item to change
   * @param newPrice the new price of the item
   */
  public void changePrice(String itemNumber, int newPrice) {
    getItemWithItemNumber(itemNumber).setPrice(newPrice);
  }

  public void changeDiscount(String itemNumber, double newDiscount) {
    getItemWithItemNumber(itemNumber).setDiscountPercentage(newDiscount);
  }

  /**
   * Returns a list of all item numbers in the item list.
   *
   * @return a list of all item numbers in the item list
   */
  public ArrayList<String> getAllItemNumbers() {
    ArrayList<String> itemNumbers = new ArrayList<>();
    for (int i = 0; i < getItemsSize(); i++) {
      itemNumbers.add(getAllItems().get(i).getItemNumber());
    }
    return itemNumbers;
  }

  /**
   * Returns a list of all descriptions in the item list.
   *
   * @return a list of all descriptions in the item list
   */
  public ArrayList<String> getAllDescriptions() {
    ArrayList<String> itemDescriptions = new ArrayList<>();
    for (int i = 0; i < getItemsSize(); i++) {
      itemDescriptions.add(getAllItems().get(i).getDescription());
    }
    return itemDescriptions;
  }

  /**
   * Returns a string representation of the item list.
   *
   * @return a string representation of the item list
   */

  public String toString() {
    StringBuilder allItems = new StringBuilder();
    for (int i = 0; i < getItemsSize(); i++) {
      allItems.append("\n").append(getAllItems().get(i));
    }
    return allItems.toString();
  }
}