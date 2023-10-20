package com.coding.learning.designPatterns.creational.factories;

import com.coding.learning.designPatterns.creational.factories.PointClass.Factory;

class PointClass {
  private double x, y;

  private PointClass(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static class Factory {
    public static PointClass newCartesianPoint(double x, double y) {
      return new PointClass(x, y);
    }

    public static PointClass newPolarPoint(double rho, double theta) {
      return new PointClass(rho * Math.cos(theta),
          rho * Math.sin(theta));
    }
  }
}

public class StaticFactoryDemo {

  public static void main(String[] args) {
    PointClass point = Factory.newCartesianPoint(10, 20);
  }
}
