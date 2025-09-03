package expensetracker;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Expense> expenseList;

    public Category(String name){
        this.name = name;
        expenseList = new ArrayList<>();
    }

    public void addExpense(Expense ex){
        expenseList.add(ex);
    }

    public double getCategoryTotal(){
        double result = 0.0;
        for(Expense ex : expenseList){
                result += ex.getAmount();
            }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public String toString(){
        return name;
    }
}