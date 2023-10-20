package com.coding.learning.designPatterns.creational.singleton;

class InnerStaticSingleton {
  private InnerStaticSingleton(){}

  private static class Impl {
    public static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
  }

  public static InnerStaticSingleton getInstance() {
    return Impl.INSTANCE;
  }
}

public class InnerStaticSingletonDemo {

  public static void main(String[] args) {
    // It is much simpler and thread safety as compared to Lazy & double-checked locking
    final InnerStaticSingleton instance = InnerStaticSingleton.getInstance();
  }
}
