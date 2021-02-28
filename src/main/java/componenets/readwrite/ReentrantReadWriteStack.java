package componenets.readwrite;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteStack<T> {

  private List<T> container;
  private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

  public ReentrantReadWriteStack(List<T> container) {
    this.container = container;
  }

  public void push(T value) {
    Lock writeLock = readWriteLock.writeLock();
    writeLock.lock();
    try {
      System.out.println("Write push thread: " + Thread.currentThread().getName() + ", value = " + value);
      container.add(0, value);
    } finally {
      writeLock.unlock();
    }
  }

  public T pop() {
    Lock writeLock = readWriteLock.writeLock();
    writeLock.lock();
    T value = null;
    try {
      if(container.size() > 0) {
        value = container.remove(0);
        System.out.println("Write pop thread: " + Thread.currentThread().getName() + ", value = " + value);
      }
    } finally {
      writeLock.unlock();
    }
    return value;
  }

  public void showStack() {
    Lock readLock = readWriteLock.readLock();
    readLock.lock();
    try {
      System.out.println("Read thread: " + Thread.currentThread().getName() + ", stack: " + container.toString());
    } finally {
      readLock.unlock();
    }
  }
}
