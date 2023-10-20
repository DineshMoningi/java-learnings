package com.coding.learning.designPatterns.behavioral.chaingOfResponsibility;

import com.coding.learning.designPatterns.behavioral.chaingOfResponsibility.Query.Argument;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class Event<Args> {

  private int index = 0;
  private Map<Integer, Consumer<Args>> handlers = new HashMap<>();

  public int subscribe(Consumer<Args> handler) {
    int i = index;
    handlers.put(i++, handler);
    return i;
  }

  public void unsubscribe(int key) {
    handlers.remove(key);
  }

  public void fire(Args args) {
    for (Consumer<Args> handler : handlers.values()) {
      handler.accept(args);
    }
  }
}

class Query {

  public String creatureName;

  enum Argument {
    ATTACK, DEFENSE
  }

  public Argument argument;
  public int result;

  public Query(String creatureName,
      Argument argument, int result) {
    this.creatureName = creatureName;
    this.argument = argument;
    this.result = result;
  }
}

class Game {

  public Event<Query> queries = new Event<>();

}

class Creatures {

  private Game game;
  public String name;
  public int baseAttack, baseDefense;

  public Creatures(Game game, String name, int baseAttack, int baseDefense) {
    this.game = game;
    this.name = name;
    this.baseAttack = baseAttack;
    this.baseDefense = baseDefense;
  }

  public int getAttack() {
    final Query q = new Query(name, Argument.ATTACK, baseAttack);
    game.queries.fire(q);
    return q.result;
  }

  public int getDefense() {
    final Query q = new Query(name, Argument.DEFENSE, baseDefense);
    game.queries.fire(q);
    return q.result;
  }

  @Override
  public String toString() {
    return "Creatures{" +
        "name='" + name + '\'' +
        ", attack=" + getAttack() +
        ", defense=" + getDefense() +
        '}';
  }
}

class CreaturesModifier {

  protected Game game;
  protected Creatures creatures;

  public CreaturesModifier(
      Game game,
      Creatures creatures) {
    this.game = game;
    this.creatures = creatures;
  }
}

class DoubleAttackerModifier extends CreaturesModifier implements AutoCloseable {

  private final int token;

  public DoubleAttackerModifier(Game game, Creatures creatures) {
    super(game, creatures);
    token = game.queries.subscribe(q -> {
      if (q.creatureName.equals(creatures.name) && q.argument == Argument.ATTACK) {
        q.result *= 2;
      }
    });
  }

  @Override
  public void close() {
    game.queries.unsubscribe(token);
  }
}

//class IncreaseDefenseModifier extends CreaturesModifier implements AutoCloseable {
//
//  private final int token;
//
//  public IncreaseDefenseModifier(Game game, Creatures creatures) {
//    super(game, creatures);
//    token = game.queries.subscribe(q -> {
//      if (q.creatureName.equals(creatures.name) && q.argument == Argument.DEFENSE) {
//        q.result += 3;
//      }
//    });
//  }
//
//  @Override
//  public void close() {
//    game.queries.unsubscribe(token);
//  }
//}

class IncreasedDefenseModifier
    extends CreaturesModifier
{

  public IncreasedDefenseModifier(Game game, Creatures creature)
  {
    super(game, creature);

    game.queries.subscribe(q -> {
      if (q.creatureName.equals(creature.name)
          && q.argument == Query.Argument.DEFENSE)
      {
        q.result += 3;
      }
    });
  }
}

public class BrokerChainDemo {

  public static void main(String[] args) {
    final Game game = new Game();
    final Creatures goblin = new Creatures(game, "Strong Goblin", 2, 2);
    System.out.println(goblin);

    final IncreasedDefenseModifier increaseDefenseModifier = new IncreasedDefenseModifier(game,
        goblin);

    try (DoubleAttackerModifier doubleAttackerModifier = new DoubleAttackerModifier(game,
        goblin);) {
      System.out.println(goblin);
    }
    System.out.println(goblin);
  }
}
