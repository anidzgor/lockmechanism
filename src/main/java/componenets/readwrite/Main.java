package componenets.readwrite;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    ReentrantReadWriteStack<Integer> stack = new ReentrantReadWriteStack<>(
        new ArrayList<>(Arrays.asList(1, 5, 10, 17, 28)));

    for (int i = 0; i < 10; i++) {
      if(i % 2 == 0) {
        new WriteThreadPush(stack).start();
      }
      new ReadThread(stack).start();
      if(i % 3 == 0) {
        new WriteThreadPop(stack).start();
      }
    }
  }
}
