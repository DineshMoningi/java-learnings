package com.coding.learning.designPatterns.creational.singleton;


import java.io.File;
import java.io.IOException;

class StaticBlockSingleton {
  private StaticBlockSingleton() throws IOException {
    System.out.println("Created singleton object");
    final File test = File.createTempFile("test", ".txt");
    System.out.println(test.getAbsolutePath());
  }

  private static StaticBlockSingleton INSTANCE;

  static {
    try {
      INSTANCE = new StaticBlockSingleton();
    } catch (IOException e) {
      System.err.println("Failed to create singleton");
    }
  }

  public static StaticBlockSingleton getInstance() {
    return INSTANCE;
  }
}

public class StaticBlockSingletonDemo {

  public static void main(String[] args) {
    final StaticBlockSingleton instance = StaticBlockSingleton.getInstance();

    System.out.println(StaticBlockSingleton.getInstance());
    System.out.println(StaticBlockSingleton.getInstance());
    System.out.println(StaticBlockSingleton.getInstance());
    System.out.println(StaticBlockSingleton.getInstance());
  }
}
