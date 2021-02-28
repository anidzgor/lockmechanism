package componenets.lock;

public class CommonResourceProblem implements CommonResource {

  private int counter = 0;

  @Override
  public void increment() {
    for (int i = 0; i < 1000000; i++) {
      counter++;
    }
  }

  @Override
  public int getCounter() {
    return counter;
  }
}
