package com.coding.learning.designPatterns.creational.factories;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.javatuples.Pair;
import org.reflections.Reflections;

interface HotDrink {

  void consume();
}

class Tea implements HotDrink {

  @Override
  public void consume() {
    System.out.println("This tea is delicious");
  }
}

class Coffee implements HotDrink {

  @Override
  public void consume() {
    System.out.println("This coffee is delicious");
  }
}

interface HotDrinkFactory {

  HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory {

  @Override
  public HotDrink prepare(int amount) {
    System.out.println("Put in the tea bag, boil water, pour " + amount + "ml , add lemon, enjoy!");
    return new Tea();
  }
}

class CoffeeFactory implements HotDrinkFactory {

  @Override
  public HotDrink prepare(int amount) {
    System.out.println(
        "Grind some beans  boil water, pour " + amount + "ml, add cream and sugar, enjoy!");
    return new Coffee();
  }
}

class HotDrinkMachine {

  private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

  public HotDrinkMachine() throws Exception {
    Set<Class<? extends HotDrinkFactory>> types = new Reflections("").getSubTypesOf(
        HotDrinkFactory.class);
    for (Class<? extends HotDrinkFactory> type : types) {
      namedFactories.add(new Pair<>(
          type.getSimpleName().replace("Factory", ""),
          type.getDeclaredConstructor().newInstance()
      ));
    }
  }

  public HotDrink makeDrink() throws Exception {
    System.out.println("Available Drinks:");
    for (int index = 0; index < namedFactories.size(); index++) {
      Pair<String, HotDrinkFactory> item = namedFactories.get(index);
      System.out.println(index + ": " + item.getValue0());
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String s;
      int i, amount;
      if ((s = br.readLine()) != null
          && (i = Integer.parseInt(s)) > 0
          && i < namedFactories.size()) {
        System.out.println("Specify amount:");
        s = br.readLine();
        if (s != null && (amount = Integer.parseInt(s)) > 0) {
          return namedFactories.get(i).getValue1().prepare(amount);
        }
      }
      System.out.println("Incorrect input, try again.");
    }
  }
}

public class AbstractFactoryDemo {

  public static void main(String[] args) throws Exception {
    HotDrinkMachine hotDrinkMachine = new HotDrinkMachine();
    HotDrink hotDrink = hotDrinkMachine.makeDrink();
    hotDrink.consume();
  }
}
