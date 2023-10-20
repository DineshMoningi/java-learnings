package com.coding.learning.datastructures.hashtable;

import java.util.ArrayList;
import java.util.List;

class HashTable {

  private int size = 7;

  class Node {

    String key;
    int value;
    Node next;

    public Node(String key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private Node[] dataMap;

  public HashTable() {
    this.dataMap = new Node[size];
  }

  public void printTable() {
    for (int i = 0; i < dataMap.length; i++) {
      System.out.println(i + ":");
      Node temp = dataMap[i];
      while (temp != null) {
        System.out.println("\t{" + temp.key + "=" + temp.value + "}");
        temp = temp.next;
      }
    }
  }

  private int getHash(String key) {
    int hash = 0;
    final char[] chars = key.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      int asciiValue = chars[i];
      hash = (hash + asciiValue * 23) % dataMap.length;
    }
    return hash;
  }

  public void set(String key, int value) {
    final Node newNode = new Node(key, value);

    final int hashValue = getHash(key);
    if (dataMap[hashValue] == null) {
      dataMap[hashValue] = newNode;
    } else {
      Node temp = dataMap[hashValue];
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
  }

  public int get(String key) {
    final int index = getHash(key);
    Node temp = dataMap[index];

    while (temp != null) {
      if (temp.key.equals(key)) {
        return temp.value;
      }
      temp = temp.next;
    }
    return 0;
  }

  public List<String> getKeys() {
    List<String> keys = new ArrayList<>();
    for (int i = 0; i < dataMap.length; i++) {
      Node temp = dataMap[i];

      while(temp != null) {
        keys.add(temp.key);
        temp = temp.next;
      }
    }
    return keys;
  }
}

public class HashTableDemo {

  public static void main(String[] args) {
    final HashTable hashTable = new HashTable();
    hashTable.set("nails", 100);
    hashTable.set("tile", 10);
    hashTable.set("lumber", 200);
    hashTable.set("bolts", 140);
    hashTable.set("screws", 300);
    hashTable.printTable();

    System.out.println(hashTable.get("bolts"));
    System.out.println(hashTable.getKeys());
  }
}
