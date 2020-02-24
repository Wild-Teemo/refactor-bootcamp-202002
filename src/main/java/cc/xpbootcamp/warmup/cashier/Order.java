package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.util.List;

public class Order {

  private static final double DISCOUNT_RATE = 0.02;
  private static final int DISCOUNT_DAY = 3;
  private List<LineItem> lineItemList;
  private LocalDate createDate;

  public Order(List<LineItem> lineItemList, LocalDate createDate) {
    this.lineItemList = lineItemList;
    this.createDate = createDate;
  }

  public List<LineItem> getLineItems() {
    return lineItemList;
  }

  public LocalDate getCreateDate() {
    return createDate;
  }

  public double getTotalAmount() {
    return getLineItems().stream().mapToDouble(LineItem::getTotalAmount).sum();
  }

  public double getTotalAmountIncludeTaxAndDiscount() {
    return getTotalAmount() + getTotalSalesTax() - getTotalDiscount();
  }

  public double getTotalSalesTax() {
    return getLineItems().stream().mapToDouble(LineItem::getSalesTax).sum();
  }

  public double getTotalDiscount() {
    return isDiscountDay() ? (getTotalSalesTax() + getTotalAmount()) * DISCOUNT_RATE : 0;
  }

  private boolean isDiscountDay() {
    return createDate.getDayOfWeek().getValue() == DISCOUNT_DAY;
  }

}
