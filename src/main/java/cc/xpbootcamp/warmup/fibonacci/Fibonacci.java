package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {

  public long calculate(long position) {

    if (position > 2) {
      return calculate(position - 1) + calculate(position - 2);
    }
    return 1;
  }

}
