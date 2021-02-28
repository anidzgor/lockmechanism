package componenets.trylock;

public class Main {

  public static void main(String[] args) {
    CommonResourceTryLock commonResource = new CommonResourceTryLock();
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

}
