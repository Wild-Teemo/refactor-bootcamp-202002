package cc.xpbootcamp.warmup.cashier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrderReceiptTest {

  @Test
  public void shouldPrintReceiptWhenIsNotWednesday() {
    //given
    List<LineItem> lineItems = new ArrayList<LineItem>() {{
      add(new LineItem("巧克力", 21.5, 2));
      add(new LineItem("小白菜", 10.0, 1));
    }};
    OrderReceipt receipt = new OrderReceipt(new Order(lineItems, LocalDate.parse("2020-02-18")));

    //when
    String output = receipt.printReceipt();
    String exceptResult =
        "===== 老王超市，值得信赖 =====\n\n"
            + "2020年2月18日,星期二\n\n"
            + "巧克力,21.5x2,43.0\n"
            + "小白菜,10.0x1,10.0\n"
            + "----------------------\n"
            + "税额:5.30\n"
            + "总价:58.30\n";

    //then
    assertEquals(exceptResult, output);
  }

  @Test
  public void shouldPrintReceiptWithDiscountWhenIsWednesday() {
    //given
    List<LineItem> lineItems = new ArrayList<LineItem>() {{
      add(new LineItem("巧克力", 21.5, 2));
      add(new LineItem("小白菜", 10.0, 1));
    }};
    OrderReceipt receipt = new OrderReceipt(new Order(lineItems, LocalDate.parse("2020-02-19")));

    //when
    String output = receipt.printReceipt();
    String exceptResult =
        "===== 老王超市，值得信赖 =====\n\n"
            + "2020年2月19日,星期三\n\n"
            + "巧克力,21.5x2,43.0\n"
            + "小白菜,10.0x1,10.0\n"
            + "----------------------\n"
            + "税额:5.30\n"
            + "折扣:1.17\n"
            + "总价:57.13\n";

    //then
    assertEquals(exceptResult, output);
  }

}