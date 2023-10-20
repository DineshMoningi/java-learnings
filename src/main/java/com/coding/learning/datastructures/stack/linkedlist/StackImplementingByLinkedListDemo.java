package com.coding.learning.datastructures.stack.linkedlist;

class Stack {

  class Node {
    int value;
    Node next;
    public Node(int value) {
      this.value = value;
    }
  }

  private int height;
  private Node top;

  public Stack(int value) {
    Node newNode = new Node(value);
    top = newNode;
    height = 1;
  }

  public Node getTop() {
    return top;
  }

  public int getHeight() {
    return height;
  }

  public void printStack() {
    Node temp = top;
    System.out.print("Stack element(s): ");
    while(temp != null) {
      System.out.print(temp.value + "\t");
      temp = temp.next;
    }
    System.out.println();
  }

  public void push(int value) {
    Node newNode = new Node(value);
    if(height == 0) {
      top = newNode;
    } else {
      newNode.next = top;
      top = newNode;
    }
    height++;
  }

  public Node pop() {
    Node temp = null;
    if(height == 0) {
      return temp;
    } else if(height == 1){
      top = null;
    } else {
      temp = top;
      top = top.next;
      temp.next = null;
    }
    height--;
    return temp;
  }
}
public class StackImplementingByLinkedListDemo {

  public static void main(String[] args) {
    final Stack stack = new Stack(10);
    stack.printStack();
    System.out.println("Height: " + stack.getHeight());
    System.out.println("Top: " + stack.getTop().value);
    stack.push(9);
    stack.push(8);
    stack.printStack();
    stack.pop();
    stack.printStack();
    stack.pop();
    stack.printStack();
  }

}
