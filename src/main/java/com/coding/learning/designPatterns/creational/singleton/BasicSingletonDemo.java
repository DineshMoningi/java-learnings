package com.coding.learning.designPatterns.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class BasicSingleton implements Serializable {
  private BasicSingleton() {}

  private static final BasicSingleton INSTANCE = new BasicSingleton();

  public static BasicSingleton getInstance() {
    return INSTANCE;
  }

  private int value;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  protected Object readResolve() {
    return INSTANCE;
  }
}

public class BasicSingletonDemo {

  static void saveToFile(BasicSingleton basicSingleton, String filename) throws Exception {
    try (FileOutputStream out = new FileOutputStream(filename);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);) {
      objectOutputStream.writeObject(basicSingleton);
    }
  }

  static BasicSingleton readFromFile(String filename) throws Exception {
    try (final FileInputStream fileInputStream = new FileInputStream(filename);
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
      return (BasicSingleton)objectInputStream.readObject();
    }
  }

  public static void main(String[] args) throws Exception {
    BasicSingleton instance = BasicSingleton.getInstance();
    instance.setValue(100);


    /*
    * Disadvantages with basic singleton
    * 1. Reflection Api - we can break the singleton principle
    * 2. Serialization - While deserialization, it won't consider the private the constructor
    * #2 - to fix the issue
    * protected Object readResolve() {
    *   return INSTANCE;
    * }
    * */

    final String filename = "singleton.bin";
    saveToFile(instance, filename);
    instance.setValue(200);
    final BasicSingleton readFromFile = readFromFile(filename);
    System.out.println(instance == readFromFile);
    System.out.println(instance.getValue());
    System.out.println(readFromFile.getValue());
  }
}
