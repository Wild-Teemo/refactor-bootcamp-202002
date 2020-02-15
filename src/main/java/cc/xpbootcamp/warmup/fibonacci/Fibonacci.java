package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {

  public long calculate(long position) {

    if (position <= 0) {
      throw new RuntimeException();
    } else if (position > 2) {
      return calculate(position - 1) + calculate(position - 2);
    } else {
      return 1;
    }
  }

}
