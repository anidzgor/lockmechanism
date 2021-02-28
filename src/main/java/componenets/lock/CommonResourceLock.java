package componenets.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CommonResourceLock implements CommonResource {

  private int counter = 0;
  private final Lock lock = new ReentrantLock();

  @Override
  public void increment() {
    lock.lock();
    for (int i = 0; i < 1000000; i++) {
      counter++;
    }
    lock.unlock();
  }

  @Override
  public int getCounter() {
    return counter;
  }
}
