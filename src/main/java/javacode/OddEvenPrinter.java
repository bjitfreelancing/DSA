package javacode;

/**
 * Implementing a Java program where two threads print odd and even numbers respectively,
 * and ensuring the output is sequentially ordered (1, 2, 3, 4, ...) involves careful coordination between the threads.
 * This can be achieved using wait() and notify() methods to control the execution flow of the threads.
 */
public class OddEvenPrinter {
  private final int limit;
  private Integer counter = 1;

  public OddEvenPrinter(int limit) {
    this.limit = limit;
  }

  public void printOddNumber() {
    synchronized (this) {
      while (counter < limit) {
        while (counter % 2 == 0) { // If number is even, odd thread waits
          try {
            wait();
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Odd thread interrupted "+e);
          }
        }
        System.out.println(Thread.currentThread().getName() + ":" + counter++);
        notifyAll();
      }
    }
  }

  public void printEvenNumber() {
    synchronized (this) {
      while (counter < limit) {
        while (counter % 2 == 1) { // If number is odd, even thread waits
          try {
            wait();
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Even thread interrupted "+e);
          }
        }
        System.out.println(Thread.currentThread().getName() + ":" + counter++);
        notifyAll();
      }
    }
  }

  public static void main(String[] args) {
    OddEvenPrinter oddEvenPrinter = new OddEvenPrinter(20);

    Thread t1 = new Thread(oddEvenPrinter::printOddNumber, "Odd no");
    Thread t2 = new Thread(oddEvenPrinter::printEvenNumber, "Even no");

    t1.start();
    t2.start();
  }
}
