package com.coding.learning.designPatterns.structural.decorator;

import java.util.function.Supplier;

interface IShape {

  String info();
}

class CircleImpl implements IShape {

  private float radius;

  public CircleImpl(float radius) {
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

class SquareImpl implements IShape {

  private float side;

  public SquareImpl(int side) {
    this.side = side;
  }

  @Override
  public String info() {
    return "A squre of the side " + side;
  }
}

class ColoredShapeImpl<T extends IShape> implements IShape {

  private IShape shape;
  private String color;

  public ColoredShapeImpl(Supplier<? extends T> cont, String color) {
    this.shape = cont.get();
    this.color = color;
  }

  @Override
  public String info() {
    return shape.info() + " has the color " + color;
  }
}

class TransparentShapeImpl<T extends IShape> implements IShape {

  private IShape shape;
  private int transparency;

  public TransparentShapeImpl(Supplier<? extends T> cont, int transparency) {
    this.shape = cont.get();
    this.transparency = transparency;
  }

  @Override
  public String info() {
    return shape.info() + " has the transparency " + transparency + "%";
  }
}

public class StaticDecoratorCompsitionDemo {

  public static void main(String[] args) {
    final ColoredShapeImpl<SquareImpl> coloredShape = new ColoredShapeImpl<>(
        () -> new SquareImpl(20), "blue");
    System.out.println(coloredShape.info());

    TransparentShapeImpl<ColoredShapeImpl<CircleImpl>> transparentShape = new TransparentShapeImpl<>(
        () -> new ColoredShapeImpl<>(() -> new CircleImpl(20), "red"), 50);

    System.out.println(transparentShape.info());
  }
}
