package com.coding.learning.designPatterns.creational.singleton;

import java.util.HashMap;
import java.util.Map;

enum SubSystem {
  PRIMARY,
  AUXILIARY,
  FALLBACK
}
class Printer {
  private static int instancesCount = 0;
  private Printer() {
    instancesCount ++;
    System.out.println("A total of " + instancesCount + " instances created so far.");
  }
  private static Map<SubSystem, Printer> instances = new HashMap<>();
  public static Printer get(SubSystem subSystem) {
    if(instances.containsKey(subSystem)) {
      return instances.get(subSystem);
    }
    final Printer printer = new Printer();
    instances.put(subSystem, printer);
    return printer;
  }
}
public class MultitonDemo {

  public static void main(String[] args) {
    final Printer primary = Printer.get(SubSystem.PRIMARY);
    final Printer aux = Printer.get(SubSystem.AUXILIARY);
    final Printer aux2 = Printer.get(SubSystem.AUXILIARY);
//    Printer.get(SubSystem.FALLBACK);
  }
}
