package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.util.List;

public class Order {
  private List<LineItem> lineItemList;
  private LocalDate createDate;

  public Order(List<LineItem> lineItemList,LocalDate createDate) {
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
    return getLineItems().stream().mapToDouble(LineItem::getTotalAmount).sum() + getTotalSalesTax() - getTotalDiscountAmount();
  }

  public double getTotalSalesTax() {
    return getLineItems().stream().mapToDouble(LineItem::getSalesTax).sum();
  }

  public double getTotalDiscountAmount() {
    return isDiscountDay()? getLineItems().stream().mapToDouble(LineItem::getDiscountAmount).sum() : 0;
  }

  private boolean isDiscountDay() {
    return createDate.getDayOfWeek().getValue() == 3;
  }

}
