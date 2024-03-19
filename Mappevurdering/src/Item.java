/**
 * This class represents an Item that is stored in the warehouse.
 * All items have an item number, description, brand name, color, amount in stock,
 * price, weight, length, height and category.
 * An Item also has a discount percentage that can be used to lower the price.
 *
 * @author Lars Mikkel Lødeng Nilsen
 * @since 11.12.2022
 */

public class Item {

  /**
   * The item number of the Item.
   */
  private final String itemNumber;
  /**
   * The description of the Item.
   */
  private final String description;
  /**
   * The brand name of the Item.
   */
  private final String brandName;
  /**
   * The color of the Item.
   */
  private final String color;
  /**
   * The amount of the Item in stock.
   */
  private int amountInStock;
  /**
   * The price of the Item.
   */
  private int price;
  /**
   * The weight of the Item.
   */
  private final double weight;
  /**
   * The length of the Item.
   */
  private final double length;
  /**
   * The height of the Item.
   */
  private final double height;
  /**
   * The category of the Item.
   */
  private final Category category;
  /**
   * The discount percentage of the Item.
   */
  private double discountPercentage = 0;

  /**
   * Constructs a new Item based on given parameters.
   *
   * @param itemNumber         the item number of the Item.
   * @param description        the description of the Item.
   * @param price              the price of the Item.
   * @param brandName          the brand name of the Item.
   * @param weight             the weight of the Item.
   * @param length             the length of the Item.
   * @param height             the height of the Item.
   * @param color              the color of the Item.
   * @param amountInStock      the amount of the Item in stock.
   * @param category           the category of the Item.
   * @param discountPercentage the discount percentage of the Item.
   * @throws IllegalArgumentException if itemNumber, description, color, price,
    brandName, weight, length, height, amountInStock or discountPercentage is not valid.
   */
  Item(String itemNumber, String description, int price, String brandName, double weight,
       double length, double height, String color, int amountInStock,
       int category, double discountPercentage)
      throws IllegalArgumentException {
    if (itemNumber.isBlank()) {
      throw new IllegalArgumentException("An item needs to be registered with a item number.");
    }
    if (description.isBlank()) {
      throw new IllegalArgumentException("An item needs to be registered with a description.");
    }
    if (color.isBlank()) {
      throw new IllegalArgumentException("An item needs to be registered with a color");
    }
    if (category < 1 || category > 4) {
      throw new IllegalArgumentException("A category can only have a value from 1 to 4");
    }
    if (price < 0) {
      throw new IllegalArgumentException("Price needs to be a positive number.");
    }
    if (brandName.isBlank()) {
      throw new IllegalArgumentException("An item needs a brand.");
    }
    if (weight <= 0) {
      throw new IllegalArgumentException("Weight needs to be a positive number.");
    }
    if (length <= 0) {
      throw new IllegalArgumentException("Length needs to be a positive number.");
    }
    if (height <= 0) {
      throw new IllegalArgumentException("Height need to be a positive number.");
    }
    if (amountInStock < 0) {
      throw new IllegalArgumentException("Amount in stock needs to be a positive number.");
    }
    if (discountPercentage < 0 || discountPercentage > 100) {
      throw new IllegalArgumentException("Discount can only be a value between 0 and 100;");
    }

    this.itemNumber = itemNumber;
    this.description = description;
    this.price = price;
    this.brandName = brandName;
    this.weight = weight;
    this.length = length;
    this.height = height;
    this.color = color;
    this.amountInStock = amountInStock;
    this.category = Category.fromInteger(category);
    this.discountPercentage = discountPercentage;
  }

  /**
   * Returns the item number of the Item.
   *
   * @return the item number of the Item.
   */
  public String getItemNumber() {
    return this.itemNumber;
  }

  /**
   * Returns the description of the Item.
   *
   * @return the description of the Item.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Returns the price of the Item.
   *
   * @return the price of the Item.
   */
  public int getPrice() {
    return this.price;
  }

  /**
   * Returns the brand name of the Item.
   *
   * @return the brand name of the Item.
   */
  public String getBrandName() {
    return this.brandName;
  }

  /**
   * Returns the weight of the Item.
   *
   * @return the weight of the Item.
   */
  public double getWeight() {
    return this.weight;
  }

  /**
   * Returns the length of the Item.
   *
   * @return the length of the Item.
   */
  public double getLength() {
    return this.length;
  }

  /**
   * Returns the height of the Item.
   *
   * @return the height of the Item.
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Returns the color of the Item.
   *
   * @return the color of the Item.
   */
  public String getColor() {
    return this.color;
  }

  /**
   * Returns the amount of the Item in stock.
   *
   * @return the amount of the Item in stock.
   */
  public int getAmountInStock() {
    return this.amountInStock;
  }

  /**
   * Returns the category of the Item.
   *
   * @return the category of the Item.
   */
  public Category getCategory() {
    return this.category;
  }

  /**
   * Returns the discount price of the Item.
   *
   * @return the discount price of the Item.
   */
  public double getDiscountPrice() {
    return this.price - this.price * (this.discountPercentage / 100);
  }

  /**
   * Returns the discount percentage of the Item.
   *
   * @return the discount percentage of the Item.
   */
  public double getDiscountPercentage() {
    return this.discountPercentage;
  }

  /**
   * Sets the price of the Item.
   *
   * @param price the new price of the Item.
   */
  public void setPrice(int price) {
    this.price = price;
  }

  /**
   * Sets the amount of the Item in stock.
   *
   * @param amountInStock the new amount of the Item in stock.
   */
  public void setAmountInStock(int amountInStock) {
    this.amountInStock = amountInStock;
  }

  /**
   * Sets the discount percentage of the item.
   *
   * @param discountPercentage The discount percentage of the item.
   */
  public void setDiscountPercentage(double discountPercentage) {
    this.discountPercentage = discountPercentage;
  }

  /**
   * Creates a clone of the current item.
   *
   * @return The cloned item.
   */
  public Item itemClone() {
    Item item = this;
    return new Item(item.getItemNumber(), item.getDescription(), item.getPrice(),
      item.getBrandName(), item.getWeight(), item.getLength(), item.getHeight(),
      item.getColor(), item.getAmountInStock(), item.getCategory().ordinal() + 1,
      item.getDiscountPercentage());
  }

  /**
   * Returns a string representation of the item.
   *
   * @return The string representation of the item.
   */
  public String toString() {
    return "Item{ "
      + "Item number: " + this.itemNumber + " || "
      + "description: " + this.description + " || "
      + "brandName: " + this.brandName + " || "
      + "color: " + this.color + " || "
      + "price before discount: " + this.price + "kr || "
      + "discount: " + this.discountPercentage + "% ||\n"
      + "price after discount: " + getDiscountPrice() + "kr ||"
      + "amountInStock: " + this.amountInStock + " ||"
      + "category: " + this.category + " || "
      + "weight: " + this.weight + "kg || "
      + "length: " + this.length + "m || "
      + "height: " + this.height + "m }\n";
  }
}