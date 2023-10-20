package com.coding.learning.java8.functional;


import java.util.List;
import java.util.function.Consumer;

class Employee {

  private String name;
  private int age;

  public Employee(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}

public class ConsumerDemo {
  /*
  * Consumer Functional Interface used in forEach
  * */
  public static void main(String[] args) {
    Consumer<Employee> consumer = (employee) -> {
      System.out.println("Employee Name = " + employee.getName());
    };

    final Employee dinesh = new Employee("Dinesh", 20);
    consumer.accept(dinesh);
//    List.of(dinesh).forEach();
  }
}
