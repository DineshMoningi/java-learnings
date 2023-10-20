package com.coding.learning.designPatterns.structural.proxy;

interface Drivable {

  void drive();
}

class Driver {

  public int age;

  public Driver(int age) {
    this.age = age;
  }
}

class Car implements Drivable {

  private Driver driver;

  public Car(Driver driver) {
    this.driver = driver;
  }

  @Override
  public void drive() {
    System.out.println("Car moving");
  }
}

class CarProxy extends Car {

  private Driver driver;

  public CarProxy(Driver driver) {
    super(driver);
    this.driver = driver;
  }

  @Override
  public void drive() {
    if (driver.age >= 16) {
      super.drive();
    } else {
      System.out.println("Driver is too young");
    }
  }
}

public class ProxyDemo {

  /*
   * Proxy pattern is used to do any additional validation or any stuff, at that we are going to use this pattern
   * */
  public static void main(String[] args) {
    final CarProxy proxy = new CarProxy(new Driver(13));
    proxy.drive();
  }
}
