package com.coding.learning.designPatterns.creational.builder;

class PersonDetails {

  // Address
  public String streetAddress, postcode, city;
  // Employment
  public String companyName, position;
  public double annualIncome;

  @Override
  public String toString() {
    return "Person{" +
        "streetAddress='" + streetAddress + '\'' +
        ", postcode='" + postcode + '\'' +
        ", city='" + city + '\'' +
        ", companyName='" + companyName + '\'' +
        ", position='" + position + '\'' +
        ", annualIncome=" + annualIncome +
        '}';
  }
}

// Builder facade
class PersonDetailsBuilder {

  protected PersonDetails person = new PersonDetails();

  public PersonAddressBuilder lives() {
    return new PersonAddressBuilder(person);
  }

  public PersonJobBuilder works() {
    return new PersonJobBuilder(person);
  }

  public PersonDetails build() {
    return person;
  }
}

class PersonAddressBuilder extends PersonDetailsBuilder {

  public PersonAddressBuilder(PersonDetails person) {
    this.person = person;
  }

  public PersonAddressBuilder at(String streetAddress) {
    person.streetAddress = streetAddress;
    return this;
  }

  public PersonAddressBuilder withPostCode(String postCode) {
    person.postcode = postCode;
    return this;

  }

  public PersonAddressBuilder in(String city) {
    person.city = city;
    return this;
  }
}

class PersonJobBuilder extends PersonDetailsBuilder {

  public PersonJobBuilder(PersonDetails person) {
    this.person = person;
  }

  public PersonJobBuilder at(String companyName) {
    person.companyName = companyName;
    return this;
  }

  public PersonJobBuilder asA(String position) {
    person.position = position;
    return this;
  }

  public PersonJobBuilder earning(double income) {
    person.annualIncome = income;
    return this;
  }

}

public class PersonSingleBuilderDemo {

  public static void main(String[] args) {
    PersonDetailsBuilder pdb = new PersonDetailsBuilder();
    PersonDetails person = pdb
        .lives()
        .at("Datha Sai colony")
        .in("Hyderabad")
        .withPostCode("500049")
        .works()
        .at("Gap Inc.")
        .asA("Engineer")
        .earning(1000000)
        .build();
    System.out.println(person);
  }
}
