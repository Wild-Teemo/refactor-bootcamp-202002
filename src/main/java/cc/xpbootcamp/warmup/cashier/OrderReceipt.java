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
    printCustomerInfo(output);
    printLineItems(output);
    printSaleTax(output);
    printTotalAmount(output);
    return output.toString();
  }

  private void printHeader(StringBuilder output) {
    output.append("======Printing Orders======\n");
  }

  private void printCustomerInfo(StringBuilder output) {
    output.append(order.getCustomerName());
    output.append(order.getCustomerAddress());
  }

  private void printLineItems(StringBuilder output) {
    for (LineItem lineItem : order.getLineItems()) {
      output.append(lineItem.getDescription());
      output.append('\t');
      output.append(lineItem.getPrice());
      output.append('\t');
      output.append(lineItem.getQuantity());
      output.append('\t');
      output.append(lineItem.getTotalAmount());
      output.append('\n');
    }
  }

  private void printTotalAmount(StringBuilder output) {
    output.append("Total Amount").append('\t').append(order.getTotalAmount());
  }

  private void printSaleTax(StringBuilder output) {
    output.append("Sales Tax").append('\t').append(order.getTotalSalesTax());
  }

}