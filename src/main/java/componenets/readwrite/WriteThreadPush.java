package componenets.readwrite;

import java.util.Random;

public class WriteThreadPush extends WriteThread {

  public WriteThreadPush(ReentrantReadWriteStack stack) {
    super(stack);
  }

  @Override
  public void run() {
    try {
      int number = new Random().nextInt(50);
      getStack().push(number);
    } catch (Exception e) {
      System.out.println("Occurred problem with push to stack");
    }
  }
}
