package com.coding.learning.designPatterns.creational.singleton;

class ChiefExecutiveOfficer {
  private static String name;
  private static int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    ChiefExecutiveOfficer.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    ChiefExecutiveOfficer.age = age;
  }

  @Override
  public String toString() {
    return "ChiefExecutiveOfficer{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}

public class MonoStateDesignPatternDemo {

  public static void main(String[] args) {
    final ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
    ceo.setAge(55);
    ceo.setName("Dinesh Kumar");
    final ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
    System.out.println(ceo2);
  }
}
