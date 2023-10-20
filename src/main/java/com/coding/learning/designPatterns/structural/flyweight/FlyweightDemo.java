package com.coding.learning.designPatterns.structural.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Sentence {

  private String[] words;
  private Map<Integer, WordToken> tokens = new HashMap<>();

  public Sentence(String plainText) {
    words = plainText.split(" ");
  }

  public WordToken getWord(int index) {
    WordToken wt = new WordToken();
    tokens.put(index, wt);
    return tokens.get(index);
  }

  @Override
  public String toString() {
    List<String> ws = new ArrayList<>();
    for (int i = 0; i < words.length; ++i) {
      String w = words[i];
      if (tokens.containsKey(i) && tokens.get(i).capitalize) {
        w = w.toUpperCase();
      }
      ws.add(w);
    }
    return String.join(" ", ws);
  }

  class WordToken {

    public boolean capitalize;
  }
}

public class FlyweightDemo {

  /*
   *Flyweight pattern is one of the structural design patterns as this pattern provides ways to decrease object count thus improving application required objects structure.
   * Flyweight pattern is used when we need to create a large number of similar objects (say 105).
   * One important feature of flyweight objects is that they are immutable. This means that they cannot be modified once they have been constructed.
   *
   * */
  public static void main(String[] args) {
    Sentence s = new Sentence("alpha beta gamma");
    s.getWord(1).capitalize = true;
    System.out.println(s);
  }
}
