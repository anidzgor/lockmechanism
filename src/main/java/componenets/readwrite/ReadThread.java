package componenets.readwrite;

public class ReadThread extends Thread {

  private ReentrantReadWriteStack stack;

  public ReadThread(ReentrantReadWriteStack stack) {
    this.stack = stack;
  }

  @Override
  public void run() {
    stack.showStack();
  }
}
