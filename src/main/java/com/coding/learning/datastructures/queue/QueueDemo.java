package com.coding.learning.datastructures.queue;

class Queue {
  class Node {
    int value;
    Node next;
    public Node(int value) {
      this.value = value;
    }
  }
  int length;
  Node first;
  Node last;

  public Queue(int value) {
    Node newNode = new Node(value);
    first = newNode;
    last = newNode;
    length=1;
  }

  public void getFirst() {
    System.out.println("First node: " + first.value);
  }

  public void getLast() {
    System.out.println("Last node: " + last.value);
  }

  public void getLength() {
    System.out.println("Queue length: " + length);
  }

  public void printQueue() {
    Node temp = first;
    System.out.print("Queue element(s): ");
    while(temp != null) {
      System.out.print(temp.value + "\t");
      temp = temp.next;
    }
    System.out.println();
  }

  public void enqueue(int value) {
    final Node newNode = new Node(value);
    if(length == 0) {
      first = newNode;
      last = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    length++;
  }
}
public class QueueDemo {

  public static void main(String[] args) {
    final Queue queue = new Queue(10);

  }
}
