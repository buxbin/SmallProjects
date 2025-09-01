package atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Account> customers = new ArrayList<>();
        boolean running = true;
        int pinValidation = 0;
        Scanner scanner = new Scanner(System.in);
        Account currentCustomer = null;

        customers.add(new Account(5000.50, "Sam Walts"));
        customers.add(new Account(100.23, "Eugene Remdo"));
        customers.add(new Account(50230.70, "Zack Merl"));

        // Don't do that in the real world
        System.out.println(customers.get(0).getPin());
        System.out.println(customers.get(1).getPin());
        System.out.println(customers.get(2).getPin());
        System.out.println();

        System.out.println("Welcome to your ATM");
        System.out.print("PIN: ");
        do {
            int tryPin = 0;

            if (pinValidation == 3) System.exit(-1);

            System.out.print("PIN: ");

            try {
                tryPin = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Only numbers as input are allowed.");
                continue;
            }

            if (tryPin < 1000 || tryPin > 9999) {
                pinValidation++;
                System.out.println("Wrong PIN. You have " + (3 - pinValidation) + " tries left");
                continue;
            }

            // for Lambda
            final int finalTryPin = tryPin;

            if (customers.stream().noneMatch(account -> account.getPin() == finalTryPin)) {
                pinValidation++;
                System.out.println("Wrong PIN. You have " + (3 - pinValidation) + " tries left");
            } else {
                currentCustomer = customers.stream()
                        .filter(account -> account.getPin() == finalTryPin)
                        .findFirst()
                        .get();
                break;
            }
        } while (pinValidation <= 3);

        do {
            System.out.println("1: Balance");
            System.out.println("2: Deposit");
            System.out.println("3: Withdraw");
            System.out.println("4: Exit");

            int userChoice = 0;

            try {
                userChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Only numbers as input are allowed.");
            }

            switch (userChoice) {
                case 1:
                    System.out.println(currentCustomer.getBalance());
                    break;
                case 2:
                    System.out.print("Amount to deposit: ");
                    double depositAmount = 0.0; 

                    try{
                        depositAmount = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e){
                         System.out.println("Only numbers as input are allowed.");
                    }

                    
                    currentCustomer.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Amount to withdraw: ");
                    double withdrawAmount = 0.0;

                    try{
                        withdrawAmount = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e){
                        System.out.println("Only numbers as input are allowed.");
                    }

                    

                    try{
                        currentCustomer.withdraw(withdrawAmount);
                    } catch (AccountBalanceException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Make sure your entries are valid.");
            }
        } while (running);

        scanner.close();
    }
}