package expensetracker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExpenseTracker {
    private List<Expense> allExpenses;
    private List<Category> allCategories;
    
    public ExpenseTracker(){
        allExpenses = new ArrayList<>();
        allCategories = new ArrayList<>();
    }

    public void removeExpense(int id){
        Expense expenseToRemove = null;
        Iterator<Expense> iterator = allExpenses.iterator();

        while(iterator.hasNext()){
            Expense ex = iterator.next();
            if(ex.getID() == id){
                expenseToRemove = ex;
                iterator.remove();
                break;
            }
        }

        if(expenseToRemove != null){
                Category category = expenseToRemove.getCategory();
                iterator = category.getExpenseList().iterator();

                while(iterator.hasNext()){
                    Expense ex = iterator.next();
                    if(ex.getID()== id){
                        iterator.remove();
                        break;
                    }
            }
        }

        if(expenseToRemove != null){
            System.out.println("Expense with ID: " + id + " deleted");
        } else {
            System.out.println("Expense with ID: " + id + " not found");
        }
    }

    public void addExpense(Expense ex){
        allExpenses.add(ex);
        if(!allCategories.contains(ex.getCategory())){
            allCategories.add(ex.getCategory());
        }

        ex.getCategory().addExpense(ex);
    }

    public List<Expense> getAllExpenses(){
        return allExpenses;
    }

    public List<Category> getAllCategories(){
        return allCategories;
    }

    public double getTotalSum(){
        return allExpenses.stream()
                          .mapToDouble(Expense::getAmount)
                          .sum();
    }

    public double getExpenseByCategory(String name){
        double result = 0.0;

        for(Category cat : allCategories){
            if(cat.getName().toLowerCase().equals(name.toLowerCase())){
                result = cat.getCategoryTotal();
            }
        }

        return result;
    }

}