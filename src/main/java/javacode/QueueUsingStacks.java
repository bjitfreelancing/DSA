package javacode;

import java.util.Queue;
import java.util.Stack;

// Queue - FIFO, Stack - LILO
public class QueueUsingStacks {
  Queue<Integer> queue;
  Stack<Integer> stack;
  Stack<Integer> stack1;
  Stack<Integer> stack2;

  public QueueUsingStacks() {
    stack = new Stack<>();
    stack1 = new Stack<>();
    stack2 = new Stack<>();
  }
  void push(int x) {
    stack.push(x);
  }

  void enqueue(int x) {
    stack1.push(x);
  }

  public void costlyEnqueue(int x) {
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
    stack1.push(x);
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }
  }

  public int dequeue() {
    if (stack1.isEmpty() && stack2.isEmpty()) {
      System.out.println("Empty Queue");
      System.exit(0);
    }
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty())
        stack2.push(stack1.pop());
    }
    return stack2.pop();
  }

  public int optimisedDequeue() {
    if (stack1.isEmpty()) {
      System.out.println("Empty Queue");
      System.exit(0);
    }
    return stack1.pop();
  }

  public int pop() {
    return stack.pop();
  }

  public static void main(String[] args) {
    QueueUsingStacks queueUsingStacks = new QueueUsingStacks();
    queueUsingStacks.push(1);
    queueUsingStacks.push(2);
    queueUsingStacks.push(3);
    System.out.println("Popping from stack: " + queueUsingStacks.pop());
    System.out.println("Popping from stack: " + queueUsingStacks.pop());
    System.out.println("Popping from stack: " + queueUsingStacks.pop());
    queueUsingStacks.enqueue(1);
    queueUsingStacks.enqueue(2);
    queueUsingStacks.enqueue(3);
    System.out.println("Dequeu from queueu: " + queueUsingStacks.dequeue());
    System.out.println("Dequeu from queueu: " + queueUsingStacks.dequeue());
    queueUsingStacks.enqueue(4);
    queueUsingStacks.enqueue(5);
    System.out.println("Dequeu from queueu: " + queueUsingStacks.dequeue());
    System.out.println("Dequeu from queueu: " + queueUsingStacks.dequeue());
    System.out.println("Dequeu from queueu: " + queueUsingStacks.dequeue());
    System.out.println("**** Optimised queueing****");
    queueUsingStacks.costlyEnqueue(1);
    queueUsingStacks.costlyEnqueue(2);
    queueUsingStacks.costlyEnqueue(3);
    System.out.println("Dequeu from queueu: " + queueUsingStacks.optimisedDequeue());
    System.out.println("Dequeu from queueu: " + queueUsingStacks.optimisedDequeue());
    queueUsingStacks.costlyEnqueue(4);
    queueUsingStacks.costlyEnqueue(5);
    System.out.println("Dequeu from queueu: " + queueUsingStacks.optimisedDequeue());
    System.out.println("Dequeu from queueu: " + queueUsingStacks.optimisedDequeue());
    System.out.println("Dequeu from queueu: " + queueUsingStacks.optimisedDequeue());
  }
}
