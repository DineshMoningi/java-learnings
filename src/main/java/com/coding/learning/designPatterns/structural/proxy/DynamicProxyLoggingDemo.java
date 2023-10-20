package com.coding.learning.designPatterns.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

interface Human {

  void walk();

  void talk();

}

class Person implements Human {

  @Override
  public void walk() {
    System.out.println("I am walking");
  }

  @Override
  public void talk() {
    System.out.println("I am talking");
  }
}

class LoggingHandler implements InvocationHandler {

  private final Object target;
  private Map<String, Integer> calls = new HashMap<>();

  public LoggingHandler(Object target) {
    this.target = target;
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    final String methodName = method.getName();
    if (methodName.contains("toString")) {
      return calls.toString();
    }
    calls.merge(methodName, 1, Integer::sum);
    return method.invoke(target, args);
  }
}

public class DynamicProxyLoggingDemo {

  @SuppressWarnings("unchecked")
  public static <T> T withLogging(T target, Class<T> intrfc) {
    return (T) Proxy.newProxyInstance(intrfc.getClassLoader(), new Class<?>[]{intrfc},
        new LoggingHandler(target));
  }

  public static void main(String[] args) {
//    final Person person = new Person();
//    final Human human = withLogging(person, Human.class);
//    human.talk();
//    human.talk();
//    human.walk();
//    System.out.println(human);
    final ResponsiblePerson responsiblePerson = new ResponsiblePerson(new Person1(16));
    System.out.println(responsiblePerson.drive());
  }
}


class Person1
{
  private int age;

  public Person1(int age)
  {
    this.age = age;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public String drink() { return "drinking"; }
  public String drive() { return "driving"; }
  public String drinkAndDrive() { return "driving while drunk"; }
}

class ResponsiblePerson extends Person1
{
  private Person1 person;

  public ResponsiblePerson(Person1 person)
  {
    super(person.getAge());
    System.out.println(person.getAge());
    this.person = person;
  }

  public String drink() {
    if(person.getAge() >= 18) {
      return super.drink();
    } else {
      return "too young";
    }

  }
  public String drive() {
    if(person.getAge() >= 16) {
      return super.drive();
    } else {
      return "too young";
    }

  }
  public String drinkAndDrive() {
    return "dead";
  }
}
