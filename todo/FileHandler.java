import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class FileHandler{

    public void saveToFile(TodoList items, String fileName){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for(TodoItem item : items.getAllTodos()){
                String line = 
                item.getId() + "," +
                item.getDescription() + ","
                 + item.getPriority() + ","
                  + item.getDueDate() + ","
                   + item.isCompleted();

                writer.write(line);
                writer.newLine();
            }

            System.out.println("Saved to " + fileName);
        } catch (IOException e){
            System.out.println("Error while saving!" + e.getMessage());
            e.getStackTrace();
        }
    }

    public TodoList loadFromFile(String fileName) {
        TodoList todoList = new TodoList();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                        TodoItem item = new TodoItem(
                            Integer.parseInt(parts[0]), 
                            parts[1],                  
                            Prio.valueOf(parts[2]),    
                            LocalDate.parse(parts[3]), 
                            Boolean.parseBoolean(parts[4]) 
                        );
                        todoList.addTodo(item);
            }
            System.out.println("Loaded data from " + fileName);
        } catch (IOException e) {
            System.out.println("Error while reading: " + e.getMessage());
        }
        return todoList;
    }
}