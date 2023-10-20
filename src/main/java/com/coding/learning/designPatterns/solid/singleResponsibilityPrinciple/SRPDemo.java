package com.coding.learning.designPatterns.solid.singleResponsibilityPrinciple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SRPDemo {
  public static void main(String[] args) throws FileNotFoundException {
    Journal journal = new Journal();
    journal.addEntry("I cried today");
    journal.addEntry("I ate bug");
    System.out.println(journal);
    PersistentJournal persistentJournal = new PersistentJournal();
    persistentJournal.save(journal, "test.txt", false);
  }
}

class Journal {

  private final List<String> entries = new ArrayList<>();
  private int count = 0;

  public void addEntry(String text) {
    entries.add((++count) + ": " + text);
  }

  public void removeEntry(int index) {
    entries.remove(index);
  }

  @Override
  public String toString() {
    return String.join(System.lineSeparator(), entries);
  }

//  public void save(String filename) throws FileNotFoundException {
//    try (PrintStream out = new PrintStream(filename)) {
//      out.println(toString());
//    }
//  }
//
//  public void load(String filename) {}
//  public void load(URL url) {}
}

class PersistentJournal {

  public void save(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
    if(overwrite || new File(filename).exists()) {
      try (PrintStream out = new PrintStream(filename)) {
        out.println(toString());
      }
    }
  }

  public Journal load(String filename) {
    // add logic here
    return null;
  }

  public Journal load(URL url) {
    // add logic here
    return null;
  }
}
