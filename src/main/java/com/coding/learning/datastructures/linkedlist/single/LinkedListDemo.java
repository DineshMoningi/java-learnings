package com.coding.learning.datastructures.linkedlist.single;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Node {

  int value;
  Node next;

  public Node(int value) {
    this.value = value;
  }
}

class LinkedList {

  private Node head;
  private Node tail;
  private int length;

  public LinkedList(int value) {
    Node node = new Node(value);
    this.head = this.tail = node;
    this.length = 1;
  }

  public void printList() {
    Node temp = head;
    System.out.println("Elements in linkedlist: ");
    while (temp != null) {
      System.out.print(temp.value + "\t");
      temp = temp.next;
    }
    System.out.println();
  }

  public void getHead() {
    System.out.println("Head: " + head.value);
  }

  public void getTail() {
    System.out.println("Tail: " + tail.value);
  }

  public void getLength() {
    System.out.println("Length: " + length);
  }

  public void append(int value) {
    final Node newNode = new Node(value);
    if (length == 0) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      this.tail = newNode;
    }
    this.length++;
  }

  public Node removeLast() {
    if (length == 0) {
      System.out.println("No element found to remove");
      return null;
    } else if (length == 1) {
      head = tail = null;
    } else {
      Node temp = head;
      Node prev = temp;
      while (temp.next != null) {
        prev = temp;
        temp = temp.next;
      }
      tail = prev;
      tail.next = null;
      length--;
      return tail;
    }
    return null;
  }

  public void prepend(int value) {
    final Node newNode = new Node(value);
    if (length == 0) {
      head = tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {
    if (length == 0) {
      System.out.println("No elements founds to remove");
      return null;
    }
    if (length == 1) {
      head = tail = null;
    } else {
      Node temp = head;
      head = head.next;
      temp.next = null;
      length--;
      return temp;
    }
    return null;
  }

  public Node get(int index) {
    if (index < 0 || index >= length) {
      System.out.println("Wrong index value!");
      return null;
    }
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  public boolean set(int index, int value) {
    Node temp = get(index);
    if (temp != null) {
      temp.value = value;
      return true;
    }
    return false;
  }

  public boolean insert(int index, int value) {
    if (index < 0 || index > length) {
      System.out.println("Failed to insert due to wrong index value!");
      return false;
    }

    if (index == 0) {
      prepend(value);
      return true;
    }

    if (index == length) {
      append(value);
      return true;
    }

    final Node newNode = new Node(value);
    final Node temp = get(index - 1);
    newNode.next = temp.next;
    temp.next = newNode;
    length++;
    return true;
  }

  public Node remove(int index) {
    if (index < 0 || index >= length) {
      System.out.println("Wrong index value!");
      return null;
    }
    if (index == 0) {
      return removeFirst();
    } else if (index == length - 1) {
      return removeLast();
    } else {
      Node prev = get(index - 1);
      Node temp = prev.next;
      prev.next = temp.next;
      temp.next = null;
      length--;
      return temp;
    }
  }

  public void reverse() {
    Node temp = head;
    head = tail;
    tail = temp;
    Node after = null;
    Node before = null;
    for (int i = 0; i < length; i++) {
      after = temp.next;
      temp.next = before;
      before = temp;
      temp = after;
    }
  }
}

public class LinkedListDemo {

  public static void main(String[] args) {
    final LinkedList linkedList = new LinkedList(5);
    linkedList.printList();
    linkedList.getHead();
    linkedList.getTail();
    linkedList.getLength();
    linkedList.append(6);
    linkedList.printList();
    linkedList.getLength();
    linkedList.removeLast();
    linkedList.printList();
    linkedList.prepend(4);
    linkedList.append(6);
    linkedList.printList();
    linkedList.getLength();
    linkedList.removeFirst();
    linkedList.printList();
    System.out.println(linkedList.get(1).value);
    linkedList.set(0, 4);
    linkedList.printList();
    linkedList.insert(2, 7);
    linkedList.insert(1, 5);
    linkedList.printList();
//    substrings("abceed");
    linkedList.remove(2);
    linkedList.printList();
    linkedList.reverse();
    linkedList.printList();
    linkedList.printList();
  }

//  public static void substrings(String str) {
//    Map<String, Integer> substrings = new HashMap<>();
//    System.out.println(str.substring(0, str.length()));
//    for (int i = 0; i <= str.length(); i++) {
//      for (int j = i + 1; j <= str.length(); j++) {
//        String substring = str.substring(i, j);
//        final Set<Character> characters = Lists.charactersOf(substring).stream()
//            .collect(Collectors.toSet());
//        if (substring.toCharArray().length == characters.size()) {
//          substrings.put(substring, characters.size());
//        }
//      }
//    }
//    final OptionalInt max = substrings.entrySet().stream().mapToInt(e -> e.getKey().length()).max();
//    if(max.isPresent()) {
//      System.out.println("max string - "+ max.getAsInt());
//    }
//    System.out.println(substrings.size());
//  }
}
