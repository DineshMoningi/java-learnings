package com.coding.learning.designPatterns.structural.facade;

interface Shape {
  void draw();
}

class Rectangle implements Shape {

  @Override
  public void draw() {
    System.out.println("Rectangle::draw()");
  }
}

class Square implements Shape {

  @Override
  public void draw() {
    System.out.println("Square::draw()");
  }
}

class Circle implements Shape {

  @Override
  public void draw() {
    System.out.println("Circle::draw()");
  }
}

class ShapeMakerFacade {
  private Shape circle;
  private Shape rectangle;
  private Shape square;

  public ShapeMakerFacade() {
    circle = new Circle();
    rectangle = new Rectangle();
    square = new Square();
  }

  public void drawCircle(){
    circle.draw();
  }
  public void drawRectangle(){
    rectangle.draw();
  }
  public void drawSquare(){
    square.draw();
  }
}
public class FacadeDesignPatternDemo {
    /*
    * Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.
    * This type of design pattern comes under structural pattern as this pattern adds an interface to existing system to hide its complexities.
    * This pattern involves a single class which provides simplified methods required by client and delegates calls to methods of existing system classes.
    *
    * */
  public static void main(String[] args) {
    ShapeMakerFacade shapeMaker = new ShapeMakerFacade();

    shapeMaker.drawCircle();
    shapeMaker.drawRectangle();
    shapeMaker.drawSquare();
  }
}
