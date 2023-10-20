package com.coding.learning.designPatterns.structural.decorator;

interface Shape {
  String info();
}

class Circle implements Shape {
  private float radius;

  public Circle(float radius) {
    this.radius = radius;
  }

  public void resize(float factor) {
    radius *= factor;
  }

  @Override
  public String info() {
    return "A circle of radius " + radius;
  }
}

class Square implements Shape {
  private float side;

  public Square(int side) {
    this.side = side;
  }

  @Override
  public String info() {
    return null;
  }
}

class ColoredShape implements Shape {
  private Shape shape;
  private String color;

  public ColoredShape(Shape shape, String color) {
    this.shape = shape;
    this.color = color;
  }

  @Override
  public String info() {
    return shape.info() + " has color " + color;
  }
}

class TransparentShape implements Shape {
  private Shape shape;
  private int transparency;

  public TransparentShape(Shape shape, int transparency) {
    this.shape = shape;
    this.transparency = transparency;
  }

  @Override
  public String info() {
    return shape.info() + " has " + transparency + "% transparency.";
  }
}
public class DynamicDecoratorCompositionDemo {

  public static void main(String[] args) {
    final Circle circle = new Circle(10);
    System.out.println(circle.info());
    final ColoredShape blue = new ColoredShape(circle, "blue");
    System.out.println(blue.info());
    final TransparentShape transparentShape = new TransparentShape(new ColoredShape(new Circle(5), "red"), 50);
    System.out.println(transparentShape.info());
  }
}
