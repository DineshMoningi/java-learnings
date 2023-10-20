package com.coding.learning.designPatterns.creational.factories;

enum CoordinateSystem {
  CARTESIAN,
  POLAR
}

class Point {

  private double x, y;

  private Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /* with constructor we can implement factory but looks much complicated */
  /*
  public Point(double a, double b, CoordinateSystem co) {
    switch (co) {
      case CARTESIAN -> {
        this.x = a;
        this.y = b;
      }
      case POLAR -> {
        x = a * Math.cos(b);
        y = a * Math.sin(b);
      }
    }
  }
  */

  public static Point newCartesianPoint(double x, double y) {
    return new Point(x, y);
  }

  public static Point newPolarPoint(double rho, double theta) {
    return new Point(rho * Math.cos(theta),
        rho * Math.sin(theta));
  }
}

public class FactoryDesignPatternDemo {

  public static void main(String[] args) {
    Point point = Point.newCartesianPoint(10, 20);
  }
}
