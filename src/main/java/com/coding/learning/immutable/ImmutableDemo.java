package com.coding.learning.immutable;

final class Employee {
  private final String name;
  private final int age;
  private final Address address;

  public Employee(String name, int age, Address address) {
    this.name = name;
    this.age = age;
    this.address = address;
  }
  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Address getAddress() throws CloneNotSupportedException {
    final Address clone = (Address) address.clone();
    System.out.println("clone object " + clone);
    return clone;
  }

//  public Address getAddress() {
//    return address;
//  }
}

class Address implements Cloneable {
  public String type;
  public String address;
  public String city;

  public Address(String type, String address, String city) {
    this.type = type;
    this.address = address;
    this.city = city;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override
  public String toString() {
    return "Address{" +
        "type='" + type + '\'' +
        ", address='" + address + '\'' +
        ", city='" + city + '\'' +
        '}';
  }
}
public class ImmutableDemo {

  public static void main(String[] args) throws CloneNotSupportedException {
    final Address address = new Address("office", "waverock", "Hyd");
    final Employee employee = new Employee("Dinesh", 35, address);
    System.out.println(employee.getAddress());
    System.out.println(employee.getAddress().hashCode());
    employee.getAddress().setAddress("one west");
    System.out.println(employee.getAddress());
    System.out.println(employee.getAddress().hashCode());
    System.out.println(employee.getAddress().getAddress());
    employee.getAddress().setType("home");
    System.out.println(employee.getAddress());
  }
}
