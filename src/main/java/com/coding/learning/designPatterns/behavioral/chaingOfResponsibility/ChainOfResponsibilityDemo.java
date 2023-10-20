package com.coding.learning.designPatterns.behavioral.chaingOfResponsibility;

class Creature {

  public String name;
  public int attack, defense;

  public Creature(String name, int attack, int defense) {
    this.name = name;
    this.attack = attack;
    this.defense = defense;
  }

  @Override
  public String toString() {
    return "Creature{" +
        "name='" + name + '\'' +
        ", attack=" + attack +
        ", deffense=" + defense +
        '}';
  }
}

class CreatureModifier {

  protected Creature creature;
  protected CreatureModifier next;

  public CreatureModifier(Creature creature) {
    this.creature = creature;
  }

  public void add(CreatureModifier creatureModifier) {
    if (next != null) {
      next.add(creatureModifier);
    } else {
      next = creatureModifier;
    }
  }

  public void handle() {
    if (next != null) {
      next.handle();
    }
  }
}

class DoubleAttackModifier extends CreatureModifier {

  public DoubleAttackModifier(
      Creature creature) {
    super(creature);
  }

  @Override
  public void handle() {
    System.out.println("Doubling " + creature.name + "'s attack");
    creature.attack *= 2;
    super.handle();
  }
}
class IncreaseDefenceModifier extends CreatureModifier {

  public IncreaseDefenceModifier(
      Creature creature) {
    super(creature);
  }

  @Override
  public void handle() {
    System.out.println("Increasing " + creature.name + "'s attack");
    creature.defense += 3;
    super.handle();
  }
}
public class ChainOfResponsibilityDemo {

  public static void main(String[] args) {
    final Creature goblin = new Creature("Goblin", 2, 2);
    final CreatureModifier root = new CreatureModifier(goblin);
    System.out.println("Let's double goblin's attack...");

    root.add(new DoubleAttackModifier(goblin));

    System.out.println("Let's increase goblin's defence...");
    root.add(new IncreaseDefenceModifier(goblin));

    root.handle();
    System.out.println(goblin);
  }
}
