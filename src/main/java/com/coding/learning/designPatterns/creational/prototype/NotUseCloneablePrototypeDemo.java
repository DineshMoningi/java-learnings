package com.coding.learning.designPatterns.creational.prototype;

import java.util.Arrays;

class Address {

  public String streetAddress;
  public int houseNumber;

  public Address(String streetAddress, int houseNumber) {
    this.streetAddress = streetAddress;
    this.houseNumber = houseNumber;
  }

  @Override
  public String toString() {
    return "Address{" +
        "streetAddress='" + streetAddress + '\'' +
        ", houseNumber=" + houseNumber +
        '}';
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return new Address(streetAddress, houseNumber);
  }
}

class Person implements Cloneable{

  public String[] names;
  public Address address;

  public Person(String[] names,
      Address address) {
    this.names = names;
    this.address = address;
  }

  @Override
  public String toString() {
    return "Person{" +
        "names=" + Arrays.toString(names) +
        ", address=" + address +
        '}';
  }
  @Override
  public Object clone() throws CloneNotSupportedException {
    return new Person(names.clone(), (Address) address.clone());
  }
}

public class NotUseCloneablePrototypeDemo {

  public static void main(String[] args) throws CloneNotSupportedException {
    Person dinesh = new Person(new String[]{"dinesh", "Kumar"},
        new Address("Kumuti Steet", 12345));

    Person ritu = (Person)dinesh.clone();
    ritu.names[0] = "Ritu";
    ritu.address.houseNumber = 123456;
    System.out.println("Dinesh-" + dinesh);
    System.out.println("Ritu-" + ritu);
  }
}