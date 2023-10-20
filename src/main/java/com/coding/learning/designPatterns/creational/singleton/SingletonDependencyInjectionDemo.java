package com.coding.learning.designPatterns.creational.singleton;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.function.Supplier;

interface Database {

  int getPopulationCount(String name);
}

class SingletonDatabaseImpl implements Database {

  private Dictionary<String, Integer> capitals = new Hashtable<>();

  private SingletonDatabaseImpl() {
    System.out.println("Database Initialized");
    capitals.put("Tokyo", 10);
    capitals.put("Delhi", 10);
    capitals.put("Mumbai", 10);
  }

  private static SingletonDatabaseImpl INSTANCE = new SingletonDatabaseImpl();

  public static SingletonDatabaseImpl getInstance() {
    return INSTANCE;
  }

  @Override
  public int getPopulationCount(String name) {
    return capitals.get(name);
  }
}

class DummyDatabase implements Database {

  private Dictionary<String, Integer> capitals = new Hashtable<>();

  private DummyDatabase() {
    System.out.println("Database Initialized");
    capitals.put("Brazil", 20);
    capitals.put("USA", 20);
    capitals.put("LONDON", 20);
  }

  private static DummyDatabase INSTANCE = new DummyDatabase();

  public static DummyDatabase getInstance() {
    return INSTANCE;
  }

  @Override
  public int getPopulationCount(String name) {
    return capitals.get(name);
  }
}

class DatabaseConfigurable {

  private Database database;

  public DatabaseConfigurable(Database database) {
    this.database = database;
  }

  public int getTotalPopulations(List<String> names) {
    int result = 0;
    for (String name : names) {
      result += database.getPopulationCount(name);
    }
    return result;
  }
}

public class SingletonDependencyInjectionDemo {

  public static void main(String[] args) {
    Database database = DummyDatabase.getInstance();
    DatabaseConfigurable databaseConfigurable = new DatabaseConfigurable(database);
    final int totalPopulations = databaseConfigurable.getTotalPopulations(List.of("LONDON"));
    System.out.println(totalPopulations);
  }

}

