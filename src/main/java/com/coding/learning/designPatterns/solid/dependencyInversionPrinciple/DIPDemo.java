package com.coding.learning.designPatterns.solid.dependencyInversionPrinciple;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.javatuples.Triplet;

enum Relationship {
  PARENT,
  CHILD,
  SIBLING
}

class Person {

  public String name;

  public Person(String name) {
    this.name = name;
  }
}

interface RelationshipBrowser {

  List<Person> findAllChildrenOf(String name);
}

class Relationships implements
    RelationshipBrowser { // Low-level module because it just stores the data

  private List<Triplet<Person, Relationship, Person>> relationships = new ArrayList<>();

  public List<Triplet<Person, Relationship, Person>> getRelationships() {
    return relationships;
  }

  public void addParentAndChild(Person parent, Person child) {
    relationships.add(new Triplet<>(parent, Relationship.PARENT, child));
    relationships.add(new Triplet<>(child, Relationship.CHILD, parent));
  }

  @Override
  public List<Person> findAllChildrenOf(String name) {
    return relationships.stream().filter(
            p -> Objects.equals(p.getValue0().name, name) && Relationship.PARENT == p.getValue1())
        .map(Triplet::getValue2).collect(Collectors.toList());
  }
}

class Research { // high-level module as it have the business logic to process

//  public Research(Relationships relationships) {
//    List<Triplet<Person, Relationship, Person>> relations = relationships.getRelationships();
//    relations.stream()
//        .filter(x -> x.getValue0().name.equals("Jhon") && x.getValue1() == Relationship.PARENT)
//        .forEach(ch -> System.out.println("Jhon has a child called " + ch.getValue2().name));
//  }

  public Research(RelationshipBrowser relationshipBrowser) {
    List<Person> children = relationshipBrowser.findAllChildrenOf("Jhon");
    for (Person child : children) {
      System.out.println("Jhon has a child called " + child.name);
    }
  }
}

/*
 * A.  High level modules should not depend on low level modules
 *     Both should depend on abstractions
 * B.  Abstractions should not depend on details.
 *     Details should depend on abstractions
 * */
public class DIPDemo {

  public static void main(String[] args) {
    Person jhon = new Person("Jhon");
    Person chris = new Person("Chris");
    Person matt = new Person("Matt");

    Relationships relationships = new Relationships();
    relationships.addParentAndChild(jhon, chris);
    relationships.addParentAndChild(jhon, matt);

    new Research(relationships);
  }
}
