package componenets.lock;

public class Main {

  public static void main(String[] args) {
    CommonResource commonResource = getResource(ResourceType.SYNCHRONIZED);
    Thread thread1 = new Thread(commonResource::increment);
    Thread thread2 = new Thread(commonResource::increment);

    try {
      thread1.start();
      thread2.start();
      Thread.sleep(2000);
      System.out.println("Counter = " + commonResource.getCounter());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static CommonResource getResource(ResourceType type) {
    switch (type) {
      case PROBLEM:
        return new CommonResourceProblem();
      case LOCK:
        return new CommonResourceLock();
      case SYNCHRONIZED:
        return new CommonResourceSynchronized();
    }
    return new CommonResourceSynchronized();
  }
}
