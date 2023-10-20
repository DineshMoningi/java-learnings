package com.coding.learning.designPatterns.structural.bridge;

interface Workshop {
  void work();
}

class Produce implements Workshop {

  @Override
  public void work() {
    System.out.print("Produce ");
  }
}

class Assemble implements Workshop {

  @Override
  public void work() {
    System.out.print("and ");
    System.out.println("Assemble");
  }
}

abstract class Vehicle {
  protected Workshop produceWorkshop;
  protected  Workshop assembleWorkshop;

  protected Vehicle(Workshop produceWorkshop,
      Workshop assembleWorkshop) {
    this.produceWorkshop = produceWorkshop;
    this.assembleWorkshop = assembleWorkshop;
  }
  abstract public void manufacture();
}

class Car extends Vehicle {

  public Car(Workshop produceWorkshop,
      Workshop assembleWorkshop) {
    super(produceWorkshop, assembleWorkshop);
  }

  @Override
  public void manufacture() {
    System.out.print("Car ");
    produceWorkshop.work();;
    assembleWorkshop.work();
  }
}

class Bike extends Vehicle {

  public Bike(Workshop produceWorkshop,
      Workshop assembleWorkshop) {
    super(produceWorkshop, assembleWorkshop);
  }

  @Override
  public void manufacture() {
    System.out.print("Bike ");
    produceWorkshop.work();
    assembleWorkshop.work();
  }

}

public class BridgeDemo {

  public static void main(String[] args) {
    final Produce produce = new Produce();
    final Assemble assemble = new Assemble();
    final Car car = new Car(produce, assemble);
    car.manufacture();
    final Bike bike = new Bike(produce, assemble);
    bike.manufacture();
  }
}
