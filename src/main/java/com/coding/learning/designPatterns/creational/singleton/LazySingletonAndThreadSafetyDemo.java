package com.coding.learning.designPatterns.creational.singleton;

class LazySingleton {

  private LazySingleton() {
    System.out.println("Initializing lazy singleton");
  }

  private static LazySingleton INSTANCE;

//  public static synchronized LazySingleton getInstance() {
//    if (INSTANCE == null) {
//      return new LazySingleton();
//    }
//    return INSTANCE;
//  }

  // Double-checked locking
  public static synchronized LazySingleton getInstance() {
    if(INSTANCE == null) {
      synchronized (LazySingleton.class) {
        if(INSTANCE == null) {
          return new LazySingleton();
        }
      }
    }
    return INSTANCE;
  }
}

public class LazySingletonAndThreadSafetyDemo {

  public static void main(String[] args) {
    System.out.println(LazySingleton.getInstance());
    System.out.println(LazySingleton.getInstance());
    System.out.println(LazySingleton.getInstance());
  }
}
