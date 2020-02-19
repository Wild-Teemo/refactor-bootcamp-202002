package cc.xpbootcamp.warmup.cashier;

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
    printTotalAmount(output);
    return output.toString();
  }

  private void printHeader(StringBuilder output) {
    output.append("===== 老王超市，值得信赖 =====\n");
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
    output.append("总价").append(':').append(order.getTotalAmount()).append("\n");
  }

  private void printSaleTax(StringBuilder output) {
    output.append("税额").append(':').append(order.getTotalSalesTax()).append("\n");
  }

}