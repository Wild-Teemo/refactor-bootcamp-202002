package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
    printHeader(output);
    printLineItems(output);
    output.append("----------------------\n");
    printSaleTax(output);
    printDiscount(output);
    printTotalAmount(output);
    return output.toString();
  }

  private void printHeader(StringBuilder output) {
    output.append("===== 老王超市，值得信赖 =====\n\n");
    output.append(DateTimeFormatter.ofPattern("yyyy年M月d日,EEEE", Locale.CHINA).format(order.getCreateDate())).append("\n\n");
  }

  private void printLineItems(StringBuilder output) {
    for (LineItem lineItem : order.getLineItems()) {
      output.append(lineItem.getDescription());
      output.append(',');
      output.append(lineItem.getPrice());
      output.append('x');
      output.append(lineItem.getQuantity());
      output.append(',');
      output.append(lineItem.getTotalAmount());
      output.append('\n');
    }
  }

  private void printTotalAmount(StringBuilder output) {
    output.append("总价").append(':').append(new DecimalFormat("#.00").format(order.getTotalAmount())).append("\n");
  }

  private void printSaleTax(StringBuilder output) {
    output.append("税额").append(':').append(order.getTotalSalesTax()).append("\n");
  }

  private void printDiscount(StringBuilder output) {
    if (order.getTotalDiscountAmount() > 0) {
      output.append("折扣").append(':').append(new DecimalFormat("#.00").format(order.getTotalDiscountAmount())).append("\n");
    } else {
      output.append((""));
    }
  }

}