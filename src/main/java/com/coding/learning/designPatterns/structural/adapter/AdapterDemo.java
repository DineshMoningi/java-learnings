package com.coding.learning.designPatterns.structural.adapter;

interface Bird {

  void fly();

  void makeSound();
}

class Sparrow implements Bird {

  @Override
  public void fly() {
    System.out.println("Flying");
  }

  @Override
  public void makeSound() {
    System.out.println("Chirp chirp");
  }
}

interface ToyDuck {

  void squeak();
}

class PlasticDuck implements ToyDuck {

  @Override
  public void squeak() {
    System.out.println("squeak...");
  }
}

class BirdAdapter implements ToyDuck {

  private Bird bird;

  public BirdAdapter(Bird bird) {
    this.bird = bird;
  }

  @Override
  public void squeak() {
    bird.makeSound();
  }
}


public class AdapterDemo {
  /* if client sending different type object and server expecting different type.
  * The client makes a request to the adapter by calling a method on it using the target interface.
    The adapter translates that request on the adaptee using the adaptee interface.
    Client receive the results of the call and is unaware of adapter’s presence.
  * */


  public static void main(String[] args) {
    final Sparrow sparrow = new Sparrow();
    final PlasticDuck plasticDuck = new PlasticDuck();

    final BirdAdapter birdAdapter = new BirdAdapter(sparrow);
    birdAdapter.squeak();
  }
}
