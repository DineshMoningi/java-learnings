package com.coding.learning.designPatterns.creational.builder;

import java.util.ArrayList;
import java.util.List;

class CodeBuilder
{
  class Field {
    public String name;
    public String type;
    public Field(String name, String type) {
      this.name = name;
      this.type = type;
    }
  }

  public String className;
  public List<Field> fields = new ArrayList<>();
  public CodeBuilder(String className)
  {
    this.className = className;
  }

  public CodeBuilder addField(String name, String type)
  {
    Field field = new Field(name, type);
    fields.add(field);
    return this;
  }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder(String.format("public class %s\n{\n", className));
    for(Field field: fields) {
      sb.append(String.format("  public %s %s;\n", field.name, field.type));
    }
    return sb.append("}").toString();
  }
}
public class BuilderTask {

  public static void main(String[] args) {
    CodeBuilder builder = new CodeBuilder("Person");
    builder.addField("name", "String").addField("age", "int");
    System.out.println(builder);
  }
}
