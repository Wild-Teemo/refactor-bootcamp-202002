package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Collectors;

public class OrderReceipt {

  private Order order;
  private DecimalFormat priceFormatter = new DecimalFormat("#.00");

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
        .map(this::getLineItemDetail)
        .collect(Collectors.joining(""));
  }

  private String getLineItemDetail(LineItem lineItem) {
    return lineItem.getDescription() + ", "
        + priceFormatter.format(lineItem.getPrice()) + " x "
        + lineItem.getQuantity() + ", "
        + priceFormatter.format(lineItem.getTotalAmount()) + "\n";
  }

  private String getTotalAmount() {
    return "总价: " + priceFormatter.format(order.getTotalAmountIncludeTaxAndDiscount()) + "\n";
  }

  private String getSaleTax() {
    return "税额: " + priceFormatter.format(order.getTotalSalesTax()) + "\n";
  }

  private String getDiscount() {
    return order.getTotalDiscount() > 0 ? "折扣: " + priceFormatter
        .format(order.getTotalDiscount()) + "\n" : "";
  }

}