package com.coding.learning.designPatterns.creational.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

enum EnumBasedSingleton {
  INSTANCE;
  private int value;
  EnumBasedSingleton() {
    value = 42;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}

public class EnumBasedSingletonDemo {
  public static void saveToFile(EnumBasedSingleton singleton, String filename)
      throws IOException {
    try (FileOutputStream fileOut = new FileOutputStream(filename);
        final ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
      out.writeObject(singleton);
    }
  }

  public static EnumBasedSingleton readFromFile(String filename)
      throws IOException, ClassNotFoundException {
    try (final FileInputStream fileIn = new FileInputStream(filename);
        final ObjectInputStream in = new ObjectInputStream(fileIn)) {
      return (EnumBasedSingleton) in.readObject();
    }
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
//    final EnumBasedSingleton instance = EnumBasedSingleton.INSTANCE;
//    instance.setValue(100);
    String filename = "enum-based-singleton.bin";
//    saveToFile(instance, filename);

    final EnumBasedSingleton instance2 = readFromFile(filename);
    /*if comment serialization code also it is initializing with default value 42 not stored 100 value*/
//    instance2.setValue(200);
//    System.out.println(instance == instance2);
//    System.out.println(instance.getValue());
    System.out.println(instance2.getValue());

  }
}
