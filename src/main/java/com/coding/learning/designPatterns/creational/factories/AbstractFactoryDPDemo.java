package com.coding.learning.designPatterns.creational.factories;

abstract class Computer {

  public abstract String getRAM();

  public abstract String getHDD();

  public abstract String getCPU();

  @Override
  public String toString() {
    return "Computer { RAM: " + this.getRAM() + ", HDD: " + this.getHDD() + ", CPU: "
        + this.getCPU() + " }";
  }
}

class PC extends Computer {
  private String ram;
  private String hdd;
  private String cpu;

  public PC(String ram, String hdd, String cpu) {
    this.ram = ram;
    this.hdd = hdd;
    this.cpu = cpu;
  }

  @Override
  public String getRAM() {
    return this.ram;
  }

  @Override
  public String getHDD() {
    return this.hdd;
  }

  @Override
  public String getCPU() {
    return this.cpu;
  }
}
class Server extends Computer {
  private String ram;
  private String hdd;
  private String cpu;

  public Server(String ram, String hdd, String cpu) {
    this.ram = ram;
    this.hdd = hdd;
    this.cpu = cpu;
  }

  @Override
  public String getRAM() {
    return this.ram;
  }

  @Override
  public String getHDD() {
    return this.hdd;
  }

  @Override
  public String getCPU() {
    return this.cpu;
  }
}

interface ComputerAbstractFactory {
  Computer createComputer();
}

class PCFactory implements ComputerAbstractFactory {
  private String ram;
  private String hdd;
  private String cpu;

  public PCFactory(String ram, String hdd, String cpu) {
    this.ram = ram;
    this.hdd = hdd;
    this.cpu = cpu;
  }

  @Override
  public Computer createComputer() {
    return new PC(ram, hdd, cpu);
  }
}
class ServerFactory implements ComputerAbstractFactory {
  private String ram;
  private String hdd;
  private String cpu;

  public ServerFactory(String ram, String hdd, String cpu) {
    this.ram = ram;
    this.hdd = hdd;
    this.cpu = cpu;
  }

  @Override
  public Computer createComputer() {
    return new Server(ram, hdd, cpu);
  }
}

class ComputerFactory {

  public static Computer getComputer(ComputerAbstractFactory computerAbstractFactory) {
    return computerAbstractFactory.createComputer();
  }
}

public class AbstractFactoryDPDemo {

  public static void main(String[] args) {
    Computer i5 = ComputerFactory.getComputer(new PCFactory("4 GB", "1TB", "i5"));
    Computer i10 = ComputerFactory.getComputer(new ServerFactory("8GB", "2TB", "i10"));
    System.out.println(i5);
    System.out.println(i10);
  }
}
