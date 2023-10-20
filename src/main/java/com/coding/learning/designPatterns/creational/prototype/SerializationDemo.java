package com.coding.learning.designPatterns.creational.prototype;

import java.io.Serializable;
import org.apache.commons.lang3.SerializationUtils;

class Foo implements Serializable {

  public String stuff;
  public String whatever;

  public Foo(String stuff, String whatever) {
    this.stuff = stuff;
    this.whatever = whatever;
  }

  @Override
  public String toString() {
    return "Foo{" +
        "stuff='" + stuff + '\'' +
        ", whatever='" + whatever + '\'' +
        '}';
  }
}

public class SerializationDemo {

  public static void main(String[] args) {
    Foo foo1 = new Foo("test", "code");
    Foo foo2 = SerializationUtils.roundtrip(foo1);
    foo2.stuff = "added";
    System.out.println(foo1);
    System.out.println(foo2);
  }
}
