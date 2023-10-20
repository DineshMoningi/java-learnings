package com.coding.learning.designPatterns.creational.prototype;
class EmployeeAddress {
  public String city;
  public String postCode;

  public EmployeeAddress(String city, String postCode) {
    this.city = city;
    this.postCode = postCode;
  }

  public EmployeeAddress(EmployeeAddress other) {
    this.city = other.city;
    this.postCode = other.postCode;
  }
  @Override
  public String toString() {
    return "EmployeeAddress{" +
        "city='" + city + '\'' +
        ", postCode='" + postCode + '\'' +
        '}';
  }
}

class Employee {
  public String name;
  public EmployeeAddress employeeAddress;

  public Employee(String name,
      EmployeeAddress employeeAddress) {
    this.name = name;
    this.employeeAddress = employeeAddress;
  }

  public Employee(Employee other) {
    name = other.name;
    employeeAddress = new EmployeeAddress(other.employeeAddress);
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", employeeAddress=" + employeeAddress +
        '}';
  }
}

public class CopyConstructorDemo {

  public static void main(String[] args) {
    Employee dinesh = new Employee("Dinesh", new EmployeeAddress("Hyd", "500049"));
    Employee ritu = new Employee(dinesh);
    ritu.name = "ritu";
    ritu.employeeAddress.city = "Gnpr";
    System.out.println(dinesh);
    System.out.println(ritu);
  }
}
