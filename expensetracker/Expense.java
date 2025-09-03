package expensetracker;

import java.time.LocalDate;

public class Expense {
    private String name;
    private final int ID;
    private double amount;
    private LocalDate date;
    private Category category;
    private static int nextId = 1;

    public Expense(double amount, String name ,LocalDate date, Category category){
        this.name = name;
        this.ID = nextId++;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public Expense(double amount, String name ,Category category){
        this.name = name;
        this.ID = nextId++;
        this.amount = amount;
        this.date = LocalDate.now();
        this.category = category;
    }

    public int getID() {
        return ID;
    }
    public double getAmount() {
        return amount;
    }
    public LocalDate getDate() {
        return date;
    }
    public Category getCategory() {
        return category;
    }
    public String getName(){
        return name;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Expense [name=" + name + ", ID=" + ID + ", amount=" + amount + ", date=" + date + ", category="
                + category + "]";
    }
    
    
}