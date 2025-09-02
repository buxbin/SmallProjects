import java.util.ArrayList;
import java.util.Iterator;

public class TodoList {
    private ArrayList<TodoItem> todoList = new ArrayList<>();

    public void addTodo(TodoItem item){
        todoList.add(item);
    }

    public void removeTodo(int id){
        Iterator<TodoItem> iterator = todoList.iterator();
        TodoItem item;
        while(iterator.hasNext()){
            item = iterator.next();
            if(item.getId() == id){
                iterator.remove();
                return;
            }
        }
    }

    public ArrayList<TodoItem> getAllTodos(){
        return todoList;
    }


    public TodoItem getTodoById(int id) {
        for (TodoItem item : todoList) {
            if (item.getId() == id) return item;
    }
    return null;
}

    public void markAsCompleted(int id) {
        for (TodoItem item : todoList) {
             if (item.getId() == id) {
                item.setCompleted(true);
                return;
        }
    }
}

   public int getNextId() {
    int maxId = 0; 
    for (TodoItem item : todoList) {
        if (item.getId() > maxId) {
            maxId = item.getId();
        }
    }
    return maxId + 1; 
}

    public int getSize(){
        return todoList.size();
    }
}