package componenets.readwrite;

public class WriteThreadPop extends WriteThread {

  public WriteThreadPop(ReentrantReadWriteStack stack) {
    super(stack);
  }

  @Override
  public void run() {
    getStack().pop();
  }
}
