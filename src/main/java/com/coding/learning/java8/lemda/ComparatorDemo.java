package com.coding.learning.java8.lemda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Book {

  private int number;
  private String name;
  private int publishedYear;

  public Book() {
  }

  public Book(int number, String name, int publishedYear) {
    this.number = number;
    this.name = name;
    this.publishedYear = publishedYear;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPublishedYear() {
    return publishedYear;
  }

  public void setPublishedYear(int publishedYear) {
    this.publishedYear = publishedYear;
  }

  @Override
  public String toString() {
    return "Book{" +
        "number=" + number +
        ", name='" + name + '\'' +
        ", publishedYear=" + publishedYear +
        '}';
  }

}

public class ComparatorDemo {

  public static List<Book> getBooks() {
    return List.of(
        new Book(1, "Java", 2002),
        new Book(2, "Spring", 2005),
        new Book(3, "Spring Boot", 2015),
        new Book(4, "React Js", 2017),
        new Book(5, "Hibernate", 2006)
    );
  }

  public static void main(String[] args) {
    final List<Book> books = getBooks().stream().collect(Collectors.toList());
    System.out.println(books);

    Collections.sort(books, Comparator.comparing(Book::getPublishedYear).reversed());
    System.out.println("Reverse: " + books);
    Collections.sort(books, (b1, b2) -> b1.getName().compareTo(b2.getName()));
    System.out.println("Ascending: " + books);
  }
}
