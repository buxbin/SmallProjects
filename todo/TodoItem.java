import java.time.LocalDate;

public class TodoItem {
    private int id;
    private String description;
    private Prio priority;
    private LocalDate dueDate;
    private boolean isCompleted;

    public TodoItem(int id, String description, Prio priority, LocalDate dueDate, boolean isCompleted) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Prio getPriority() {
        return priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Prio priority) {
        this.priority = priority;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String toString() {
    return String.format("ID: %d | %s | %s | Due: %s | %s",
        id,
        description,
        priority,
        dueDate,
        isCompleted ? "Completed" : "Pending"
    );
}
}
