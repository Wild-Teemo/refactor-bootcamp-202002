package cc.xpbootcamp.warmup.cashier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrderReceiptTest {

  @Test
  public void shouldPrintLineItemAndSalesTaxInformation() {
    //given
    List<LineItem> lineItems = new ArrayList<LineItem>() {{
      add(new LineItem("巧克力", 21.5, 2));
      add(new LineItem("小白菜", 10.0, 1));
    }};
    OrderReceipt receipt = new OrderReceipt(new Order(lineItems));

    //when
    String output = receipt.printReceipt();
    String exceptResult =
        "===== 老王超市，值得信赖 =====\n"
            + "巧克力,21.5x2,43.0\n"
            + "小白菜,10.0x1,10.0\n"
            + "----------------------\n"
            + "税额:5.3\n"
            + "总价:58.3\n";

    //then
    assertEquals(exceptResult, output);
  }

}