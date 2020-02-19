package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part of order. It computes
 * the total order amount (amount of individual lineItems + total sales tax) and prints it.
 */
public class OrderReceipt {

  private Order order;

  public OrderReceipt(Order order) {
    this.order = order;
  }

  public String printReceipt() {
    StringBuilder output = new StringBuilder();
    output.append(getHeader());
    output.append(getLineItems());
    output.append("----------------------\n");
    output.append(getSaleTax());
    output.append(getDiscount());
    output.append(getTotalAmount());
    return output.toString();
  }

  private String getHeader() {
    return "===== 老王超市, 值得信赖 =====\n\n" + DateTimeFormatter
        .ofPattern("yyyy年M月d日, EEEE", Locale.CHINA).format(order.getCreateDate()) + "\n\n";
  }

  private String getLineItems() {
    return order.getLineItems().stream()
        .map(this::getOrderItemDetail)
        .collect(Collectors.joining(""));
  }

  private String getOrderItemDetail(LineItem lineItem) {
    return lineItem.getDescription() + ", "
        + lineItem.getPrice() + " x "
        + lineItem.getQuantity() + ", "
        + lineItem.getTotalAmount() + "\n";
  }

  private String getTotalAmount() {
    return "总价: " + new DecimalFormat("#.00").format(order.getTotalAmount()) + "\n";
  }

  private String getSaleTax() {
    return "税额: " + new DecimalFormat("#.00").format(order.getTotalSalesTax()) + "\n";
  }

  private String getDiscount() {
    return order.getTotalDiscountAmount() > 0 ? "折扣: " + new DecimalFormat("#.00")
        .format(order.getTotalDiscountAmount()) + "\n" : "";
  }

}