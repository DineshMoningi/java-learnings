package com.coding.learning.java8.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class SimpleDateFormatter {
  ThreadLocal<SimpleDateFormat> sf = ThreadLocal.withInitial(() -> new SimpleDateFormat("YYYY-MON-DD"));
}

class Singleton {
  private static final Singleton singleton = new Singleton();

  private Singleton() {}

  static class  ThreadSafe {

  }
  public synchronized static Singleton getSingleton() {
    if(singleton == null) {
      synchronized (Singleton.class) {
        if(singleton == null) {
          return singleton;
        }
      }
    }
    return singleton;
  }

}

public class ThreadLocalDemo {

  public static void main(String[] args) {
    System.out.println(Singleton.getSingleton());
    System.out.println(Singleton.getSingleton());
    System.out.println(Singleton.getSingleton());
  }
}
