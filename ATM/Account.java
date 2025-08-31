package bankautomat;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private final int PIN;
    private String name;
    private static List<Integer> pinDatabase = new ArrayList<>();

    {
        int tempPin;

        do {
            tempPin = (int) (Math.random() * 9000 + 1000);
        } while (pinDatabase.contains(tempPin));

        PIN = tempPin;
        pinDatabase.add(PIN);
    }

    public Account(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPin() {
        return PIN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void withdraw(double amount) throws AccountBalanceException {
    if (balance - amount < 0) {
        throw new AccountBalanceException("Your account does not have sufficient funds for this transaction.");
    }
    balance -= amount;
}

    public void deposit(double amount) {
        balance += amount;
    }
}