package cc.xpbootcamp.warmup.cashier;

public class LineItem {

  private static final double TAX_RATE = 0.10;
  private String description;
  private double price;
  private int quantity;

  public LineItem(String description, double price, int quantity) {
    super();
    this.description = description;
    this.price = price;
    this.quantity = quantity;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getTotalAmount() {
    return price * quantity;
  }

  public double getSalesTax() {
    return getTotalAmount() * TAX_RATE;
  }
}