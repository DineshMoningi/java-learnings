package com.coding.learning.designPatterns.solid.openClosePrinciple;

import java.util.List;
import java.util.stream.Stream;

enum Size {
  SMALL,
  MEDIUM,
  LARGE
}

enum Color {
  GREEN,
  BLUE,
  RED,
  HUGE
}

class Product {

  public String name;
  public Color color;
  public Size size;

  public Product(String name, Color color, Size size) {
    this.name = name;
    this.size = size;
    this.color = color;
  }


}

class ProductFilter {

  public Stream<Product> filterByColor(List<Product> products, Color color) {
    return products.stream().filter(p -> p.color == color);
  }

  public Stream<Product> filterBySize(List<Product> products, Size size) {
    return products.stream().filter(p -> p.size == size);
  }

  public Stream<Product> filterByColorAndSize(List<Product> products, Color color, Size size) {
    return products.stream().filter(p -> p.size == size && p.color == color);
  }
}

interface Specification<T> {

  boolean isSatisfied(T item);
}

interface Filter<T> {

  Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product> {

  private Color color;

  public ColorSpecification(Color color) {
    this.color = color;
  }

  @Override
  public boolean isSatisfied(Product item) {
    return item.color == color;
  }
}

class SizeSpecification implements Specification<Product> {

  private Size size;

  public SizeSpecification(Size size) {
    this.size = size;
  }


  @Override
  public boolean isSatisfied(Product item) {
    return item.size == size;
  }
}

class BetterFilter implements Filter<Product> {

  @Override
  public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
    return items.stream().filter(p -> spec.isSatisfied(p));
  }
}

class AndSpecification<T> implements Specification<T> {

  private Specification<T> first;
  private Specification<T> second;

  public AndSpecification(Specification first, Specification second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public boolean isSatisfied(T item) {
    return first.isSatisfied(item) && second.isSatisfied(item);
  }
}

public class OCPDemo {

  public static void main(String[] args) {
    Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
    Product watermelon = new Product("Watermalon", Color.GREEN, Size.MEDIUM);
    Product jackfruit = new Product("Jackfruit", Color.BLUE, Size.LARGE);

    List<Product> products = List.of(apple, watermelon, jackfruit);

    ProductFilter productFilter = new ProductFilter();
    System.out.println("Filtering the data with old approach");
    productFilter.filterByColor(products, Color.GREEN)
        .forEach(p -> System.out.println(" - " +p.name + " is in green color"));
    productFilter.filterBySize(products, Size.MEDIUM)
        .forEach(p -> System.out.println(" - " +p.name + " is medium size"));
    productFilter.filterByColorAndSize(products, Color.BLUE, Size.LARGE)
        .forEach(p -> System.out.println(" - " +p.name + " is in blue color and large size"));

    System.out.println("Filtering the data with new approach");

    BetterFilter betterFilter = new BetterFilter();
    betterFilter.filter(products, new ColorSpecification(Color.GREEN))
        .forEach(p -> System.out.println(" - " +p.name + " is in green color"));

    betterFilter.filter(products, new SizeSpecification(Size.MEDIUM))
        .forEach(p -> System.out.println(" - " +p.name + " is medium size"));

    betterFilter.filter(products, new AndSpecification<>(
        new ColorSpecification(Color.BLUE), new SizeSpecification(Size.LARGE)
    )).forEach(p -> System.out.println(" - " + p.name + " is in blue color and large size"));

  }
}
