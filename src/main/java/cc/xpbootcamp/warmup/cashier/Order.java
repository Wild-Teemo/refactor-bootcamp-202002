package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
  private List<LineItem> lineItemList;

  public Order(List<LineItem> lineItemList) {
    this.lineItemList = lineItemList;
  }


  public List<LineItem> getLineItems() {
    return lineItemList;
  }

  public double getTotalAmount() {
    return getLineItems().stream().mapToDouble(LineItem::getTotalAmount).sum() + getTotalSalesTax();
  }

  public double getTotalSalesTax() {
    return getLineItems().stream().mapToDouble(LineItem::getSalesTax).sum();
  }
}
