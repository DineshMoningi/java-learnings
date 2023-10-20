package com.coding.learning.designPatterns.behavioral.interpreter;

import com.coding.learning.designPatterns.behavioral.interpreter.Token.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Token {

  public enum Type {
    INTEGER,
    PLUS,
    MINUS,
    LPAREN,
    RPAREN
  }

  private Type type;
  private String text;

  public Token(Type type, String text) {
    this.type = type;
    this.text = text;
  }

  @Override
  public String toString() {
    return "`" + text + "`";
  }
}

public class InterpreterDemo {

  static List<Token> lex(String input) {
    List<Token> tokens = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      switch (input.charAt(i)) {
        case '+':
          tokens.add(new Token(Type.PLUS, input.charAt(i) + ""));
          break;
        case '-':
          tokens.add(new Token(Type.MINUS, input.charAt(i) + ""));
          break;
        case '(':
          tokens.add(new Token(Type.LPAREN, input.charAt(i) + ""));
          break;
        case ')':
          tokens.add(new Token(Type.RPAREN, input.charAt(i) + ""));
          break;
        default:
          StringBuilder sb = new StringBuilder("" + input.charAt(i));
          for (int j = i + 1; j < input.length(); j++) {
            if (Character.isDigit(input.charAt(j))) {
              sb.append(input.charAt(j));
              ++i;
            } else {
              tokens.add(new Token(Type.INTEGER, sb.toString()));
              break;
            }
          }
          break;
      }
    }
    return tokens;
  }

  interface Element {
    int eval();
  }

  class Integer implements Element {
    private int value;

    public Integer(int value) {
      this.value = value;
    }

    @Override
    public int eval() {
      return value;
    }
  }

  class BinaryOperation implements Element {
    private Element left, right;
    public enum Type {
      ADD,
      SUB
    }

    private Type type;


    @Override
    public int eval() {
      switch (type) {
        case ADD:
          return left.eval() + right.eval();
        case SUB:
          return left.eval() - right.eval();
      }
      return 0;
    }
  }

  public static void main(String[] args) {
    String input = "(12+4)-(3+4)";
    List<Token> tokens = lex(input);

    System.out.println(tokens.stream().map(t -> t.toString()).collect(Collectors.joining("\t")));
  }
}
