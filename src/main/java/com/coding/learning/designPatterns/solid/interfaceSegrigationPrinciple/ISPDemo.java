package com.coding.learning.designPatterns.solid.interfaceSegrigationPrinciple;

class Document {

}

interface Machine {
  void scan(Document d);
  void print(Document d);
  void fax(Document d) throws Exception;
}
// old approach
class MultifunctionPrinter implements Machine {

  @Override
  public void scan(Document d) {

  }

  @Override
  public void print(Document d) {

  }

  @Override
  public void fax(Document d) {

  }
}
// old approach
class OldMultifunctionPrinter implements Machine {

  @Override
  public void scan(Document d) {

  }

  @Override
  public void print(Document d) {

  }

  @Override
  public void fax(Document d) throws Exception {
    throw new Exception("not supported");
  }
}

// Better approach
interface Printer {
  void print(Document d);
}

interface Faxing {
  void fax(Document d);
}

interface Scanner {
  void scan(Document d);
}

// YAGNI - You Ain't Going to Need It
class JustAPrinter implements Printer {

  @Override
  public void print(Document d) {

  }
}

class Photocopier implements Printer, Scanner {

  @Override
  public void print(Document d) {

  }

  @Override
  public void scan(Document d) {

  }
}

interface MultiFunctionDevice extends Printer, Scanner {

}

class MultiFunctionMachine implements MultiFunctionDevice {
  private Printer printer;
  private Scanner scanner;
  public MultiFunctionMachine(Printer printer, Scanner scanner) {
    this.printer = printer;
    this.scanner = scanner;
  }

  @Override
  public void print(Document d) {
    printer.print(d);
  }

  @Override
  public void scan(Document d) {
    scanner.scan(d);
  }
}

public class ISPDemo {

}
