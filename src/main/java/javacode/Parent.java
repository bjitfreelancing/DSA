package javacode;

public class Parent implements Runnable{

  @Override
  public void run() {
    System.out.println("started");
    System.out.println("eneded");

  }

  private void runWithRunner() {
    Parent runner = new Parent();
    Thread thread = new Thread(runner);
    Math.ceil(20/3);
    thread.start();
    System.out.println("started");
    try {
      thread.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("ended");
  }

  public static void main(String[] args) {
    Parent parent = new Parent();

    parent.runWithRunner();
  }
}
