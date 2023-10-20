package com.coding.learning.designPatterns.creational.singleton;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import com.google.common.collect.Iterables;

class SingletonDatabase {
  private Dictionary<String, Integer> capitals = new Hashtable<>();
  private static int instanceCount = 0;

  public static int getInstanceCount() {
    return instanceCount;
  }

  private SingletonDatabase() {
    instanceCount++;
    System.out.println("Initializing database");

    try {
      final File file = new File(
          SingletonDatabase.class.getProtectionDomain().getCodeSource().getLocation().getPath());
      final Path path = Paths.get(file.getPath(), "capitals.txt");
      final List<String> lines = Files.readAllLines(path);

      Iterables.partition(lines, 2).forEach(kv -> {
        capitals.put(kv.get(0).trim(), Integer.parseInt(kv.get(1)));
      });
    } catch(Exception e) {

    }
  }
  private static SingletonDatabase INSTANCE = new SingletonDatabase();
  public static SingletonDatabase getInstance() {
    return INSTANCE;
  }

  public int getPopulation(String name) {
    return capitals.get(name);
  }
}

class SingletonRecordFinder {
  public int getTotalPopulationCount(List<String> names) {
    int result = 0;
    for(String name: names)
        result += SingletonDatabase.getInstance().getPopulation(name);
    return  result;
  }
}

public class TestabilityIssuesDemo {

  public static void main(String[] args) {
    SingletonRecordFinder singletonRecordFinder = new SingletonRecordFinder();
    final int totalPopulationCount = singletonRecordFinder.getTotalPopulationCount(
        List.of("Mumbai", "Delhi"));
    System.out.println(totalPopulationCount == (55000000 + 65000000));
  }
}
