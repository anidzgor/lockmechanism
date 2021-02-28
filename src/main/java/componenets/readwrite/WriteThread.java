package componenets.readwrite;

abstract class WriteThread extends Thread {

  private ReentrantReadWriteStack stack;

  public WriteThread(ReentrantReadWriteStack stack) {
    this.stack = stack;
  }

  public ReentrantReadWriteStack getStack() {
    return stack;
  }
}
