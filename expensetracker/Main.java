package expensetracker;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        double expenseAmount = 0.0;
        int year = 0;
        int month = 0;
        int day = 0;
        LocalDate date = null;
        boolean validDateEntered = false;
        ExpenseTracker tracker = new ExpenseTracker();
        System.out.println("Welcome to your Expense Tracker");
        System.out.println("How can i help you?");

        do{
            System.out.println("1: Add Expense");
            System.out.println("2: Show all Expenses");
            System.out.println("3: Show all Categories");
            System.out.println("4: Show total amount");
            System.out.println("5: Show total amount by Category");
            System.out.println("6: Delete an Expense");
            System.out.println("7: Exit");
            System.out.print("Menu point: ");
            try{
                userChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Please choose a valid menu point");
                continue;
            }

            switch(userChoice){
                case 1:
                        System.out.println("Amount of the Expense");
                        try{
                            expenseAmount = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e){
                            System.out.println("Please give a valid amount");
                        }


                        System.out.print("Name of the Expense: ");
                        String expenseName = scanner.nextLine();

                        System.out.println("Should the new Expense have today's Date?(y) or not(n)");
                        String dateChoice = scanner.nextLine();
                        if(dateChoice.equals("y")){
                            date = LocalDate.now();
                        } else {
                            do{      
                                try{
                                    System.out.print("Year of the Expense: ");
                                    year = Integer.parseInt(scanner.nextLine());

                                    System.out.print("Month of the Expense: ");
                                    month = Integer.parseInt(scanner.nextLine());
                                    
                                    System.out.print("Day of the Expense:");
                                    day = Integer.parseInt(scanner.nextLine());     
                                    
                                    date = LocalDate.of(year, month, day);
                            }  catch (Exception e){
                                System.out.println("Please give a valid date");
                                continue;
                            }
                            validDateEntered = true;
                            
                        } while(!validDateEntered);
                        }

                        System.out.print("Category of the Expense: ");
                        String categoryName = scanner.nextLine();

                        Category selectedCategory = null;
                        for(Category cat : tracker.getAllCategories()){
                            if(cat.getName().equalsIgnoreCase(categoryName)){
                                selectedCategory = cat;
                                break;
                            }
                        }

                        if(selectedCategory == null){
                            selectedCategory = new Category(categoryName);
                        }

                        Expense newExpense = new Expense(expenseAmount, expenseName, date, selectedCategory);
                        tracker.addExpense(newExpense);
                        break;
                case 2:
                        tracker.getAllExpenses().forEach(expense -> System.out.println(expense));
                        break;
                case 3:
                        tracker.getAllCategories().forEach(category -> System.out.println(category.getName()));
                        break;
                case 4:
                        System.out.println(tracker.getTotalSum());
                        break;
                case 5:
                        System.out.println("Which Category do you want to see?");
                        String amountPerCategory = scanner.nextLine();

                        if(tracker.getExpenseByCategory(amountPerCategory) == 0.0){
                            System.out.println("No Expenses in this Category or Category not found");
                        } else {
                            System.out.println(tracker.getExpenseByCategory(amountPerCategory));
                        }
                        break;
                case 6:
                        System.out.println("Which Expense do you want to delete?(Give ID)");
                        int idToRemove = Integer.parseInt(scanner.nextLine());
                        tracker.removeExpense(idToRemove);
                        break;
                case 7:
                        running = false;
                        break;
                default: 
                        System.err.println("Please give a valid ");
            }

        }while(running);

        scanner.close();
    }
}