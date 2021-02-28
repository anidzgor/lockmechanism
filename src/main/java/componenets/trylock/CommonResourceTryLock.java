package componenets.trylock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CommonResourceTryLock {

  private int counter = 0;
  private final Lock lock = new ReentrantLock();

  public void increment() {
    try {
      boolean isLockAcquired = lock.tryLock();
      //boolean isLockAcquired = lock.tryLock(1, TimeUnit.SECONDS);
      if (isLockAcquired) {
        for (int i = 0; i < 1000000; i++) {
          counter++;
        }
        lock.unlock();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public int getCounter() {
    return counter;
  }
}
