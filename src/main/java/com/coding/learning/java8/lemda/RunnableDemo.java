package com.coding.learning.java8.lemda;


public class RunnableDemo {

  public static void main(String[] args) {
    Runnable iRun = () -> {
      final long startTime = System.currentTimeMillis();
      for (int i = 1; i < 100; i++) {
        System.out.println("i:" + i);
      }
      System.out.println("Time taken to complete: " + (System.currentTimeMillis() - startTime));
    };
    Runnable jRun = () -> {
      final long startTime = System.currentTimeMillis();
      for (int i = 1; i < 100; i++) {
        System.out.println("j:" + i);
      }
      System.out.println("Time taken to complete: " + (System.currentTimeMillis() - startTime));
    };

    final Thread threadI = new Thread(iRun);
    final Thread threadJ = new Thread(jRun);

    threadI.start();
    threadJ.start();

//    iRun.run();
//    jRun.run();

  }
}
