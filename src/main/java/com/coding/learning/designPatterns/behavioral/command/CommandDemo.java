package com.coding.learning.designPatterns.behavioral.command;

import com.coding.learning.designPatterns.behavioral.command.BankAccountCommand.Action;
import com.google.common.collect.Lists;
import java.util.List;

class BankAccount {

  private int balance;
  private int overdraftLimit = -500;

  public void deposit(int amount) {
    balance += amount;
    System.out.println("Deposited amount: " + amount + ", and balance is: " + balance);
  }

  public boolean withdraw(int amount) {
    if (balance - amount >= overdraftLimit) {
      balance -= amount;
      System.out.println("Withdrawn amount: " + amount + ", and balace is: " + balance);
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "BankAccount{" +
        "balance=" + balance +
        '}';
  }
}

interface Command {

  void call();

  void undo();
}

class BankAccountCommand implements Command {

  private BankAccount bankAccount;
  private boolean succeeded;

  @Override
  public void call() {
    switch (action) {
      case DEPOSIT:
        succeeded = true;
        bankAccount.deposit(amount);
        break;
      case WITHDRAW:
        succeeded = bankAccount.withdraw(amount);
        break;
      default:
        System.out.println("Action not matched!");
    }
  }

  @Override
  public void undo() {
    if (!succeeded) {
      return;
    }
    switch (action) {
      case DEPOSIT:
        bankAccount.withdraw(amount);
        break;
      case WITHDRAW:
        bankAccount.deposit(amount);
        break;
      default:
        System.out.println("Action not matched!");
    }
  }

  public enum Action {
    DEPOSIT,
    WITHDRAW
  }

  private Action action;
  private int amount;

  public BankAccountCommand(
      BankAccount bankAccount,
      Action action, int amount) {
    this.bankAccount = bankAccount;
    this.action = action;
    this.amount = amount;
  }
}

public class CommandDemo {

  public static void main(String[] args) {
    final BankAccount bankAccount = new BankAccount();
    System.out.println(bankAccount);

    final List<BankAccountCommand> commands = List.of(
        new BankAccountCommand(bankAccount, Action.DEPOSIT, 100),
        new BankAccountCommand(bankAccount, Action.WITHDRAW, 1000));

    for (BankAccountCommand command : commands) {
      command.call();
      System.out.println(bankAccount);
    }

    for (BankAccountCommand command : Lists.reverse(commands)) {
      command.undo();
      System.out.println(bankAccount);
    }
  }
}
