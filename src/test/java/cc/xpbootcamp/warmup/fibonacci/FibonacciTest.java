package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

  @Test
  public void should_return_1_when_calculate_fibonacci_given_position_is_1() {
    //when
    Fibonacci fibonacci = new Fibonacci();
    //given
    long result = fibonacci.calculate(1);
    //then
    Assert.assertEquals(1, result);
  }

  @Test
  public void should_return_1_when_calculate_fibonacci_given_position_is_2() {
    //when
    Fibonacci fibonacci = new Fibonacci();
    //given
    long result = fibonacci.calculate(2);
    //then
    Assert.assertEquals(1, result);
  }

  @Test
  public void should_return_2_when_calculate_fibonacci_given_position_is_3() {
    //when
    Fibonacci fibonacci = new Fibonacci();
    //given
    long result = fibonacci.calculate(3);
    //then
    Assert.assertEquals(2, result);
  }
}
