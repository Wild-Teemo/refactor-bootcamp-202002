package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part of order. It computes
 * the total order amount (amount of individual lineItems + total sales tax) and prints it.
 */
public class OrderReceipt {

  private Order order;
  private final double TAXRATE = .10;
  double totalSaleTax = 0d;
  double totalPrice = 0d;

  public OrderReceipt(Order order) {
    this.order = order;
  }

  public String printReceipt() {
    StringBuilder output = new StringBuilder();

    printHeader(output);
    // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
    printCustomerInfo(output);
//        output.append(order.getCustomerLoyaltyNumber());
    printLineItems(output);
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
      output.append(lineItem.totalAmount());
      output.append('\n');

      // calculate sales tax @ rate of 10%
      double salesTax = calculateSalesTax(lineItem);
      totalSaleTax += salesTax;

      // calculate total amount of lineItem = price * quantity + 10 % sales tax
      totalPrice += calculateTotalPrice(lineItem, salesTax);

      printStateTax(output);
      printTotalAmount(output);

    }
  }

  private void printTotalAmount(StringBuilder output) {
    output.append("Total Amount").append('\t').append(totalPrice);
  }

  private void printStateTax(StringBuilder output) {
    output.append("Sales Tax").append('\t').append(totalSaleTax);
  }

  private double calculateTotalPrice(LineItem lineItem, double salesTax) {
    return lineItem.totalAmount() + salesTax;
  }

  private double calculateSalesTax(LineItem lineItem) {
    return lineItem.totalAmount() * TAXRATE;
  }


}