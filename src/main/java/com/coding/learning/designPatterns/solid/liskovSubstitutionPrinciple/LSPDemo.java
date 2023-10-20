package com.coding.learning.designPatterns.solid.liskovSubstitutionPrinciple;

class Rectangle {

  protected int height;
  protected int width;

  public Rectangle() {
  }

  public Rectangle(int height, int width) {
    this.height = height;
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getArea() {
    return width * height;
  }

  @Override
  public String toString() {
    return "Rectangle{" +
        "height=" + height +
        ", width=" + width +
        '}';
  }

  public boolean isSquare() {
    return this.height == this.width;
  }
}

class Square extends Rectangle {

  private int size;

  public Square() {
  }

  public Square(int size) {
    this.width = size;
    this.height = size;
  }

  @Override
  public void setHeight(int height) {
    // violated liskov substitution principle
    super.setHeight(height);
    super.setWidth(height);
  }

  @Override
  public void setWidth(int width) {
    // violated liskov substitution principle
    super.setWidth(width);
    super.setHeight(width);
  }
}

class RectangleFactory {

  public static Rectangle newRectangle(int width, int height) {
    return new Rectangle(width, height);
  }

  public static Rectangle newSquare(int side) {
    return new Rectangle(side, side);
  }
}

public class LSPDemo {

  public static void useIt(Rectangle r) {
    int width = r.getWidth();
    r.setHeight(10);

    System.out.println("Expected area of " + (width * 10) + ", got " + r.getArea());
  }

  public static void main(String[] args) {
    Rectangle rectangle = new Rectangle(2, 3);
    useIt(rectangle);

    // violated liskov substitution principle
    Square square = new Square();
    square.setWidth(5);
    useIt(square);
    /* this can be avoid with factory design pattern or simple boolean method to check square or not */
  }
}
