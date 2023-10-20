package com.coding.learning.designPatterns.structural.decorator;

class MyStringBuilder {
  private StringBuilder sb;

  public MyStringBuilder(String str) {
    this.sb = new StringBuilder(str);
  }

  public MyStringBuilder() {
    sb = new StringBuilder();
  }
}

class Bird
{
  public int age;

  public String fly()
  {
    return age < 10 ? "flying" : "too old";
  }
}

class Lizard
{
  public int age;

  public String crawl()
  {
    return (age > 1) ? "crawling" : "too young";
  }
}

class Dragon
{
  private int age;
  private Bird bird;
  private Lizard lizard;

  public Dragon() {
    this.bird = new Bird();
    this.lizard = new Lizard();
  }

  public Dragon(Bird bird, Lizard lizard) {
    this.bird = bird;
    this.lizard = lizard;
  }
  public void setAge(int age)
  {
    bird.age = age;
    lizard.age = age;
  }
  public String fly()
  {
    return bird.fly();
  }
  public String crawl()
  {
    return lizard.crawl();
  }
}
public class AdapterDecoratorDemo {

  public static void main(String[] args) {

  }
}
