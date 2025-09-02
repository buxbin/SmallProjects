import java.time.LocalDate;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        boolean running = true;
        TodoList appList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        FileHandler handle = new FileHandler();
        System.out.println("To-Do Manager Lite");
        appList =  handle.loadFromFile("logs/saveTodo.csv");

        while(running){
            System.out.println("1: Add Todo");
            System.out.println("2: Show all Todo");
            System.out.println("3: Remove a Todo");
            System.out.println("4: Mark as complete");
            System.out.println("5: Exit");
            System.out.print("What do you want to do: ");

            try {
                int task = Integer.parseInt(scanner.nextLine());
                System.out.println();
                switch(task){
                    case 1: 
                    System.out.println("Description: ");
                    String description = scanner.nextLine();
    
                    System.out.println("Priority(low/medium/high): ");
                    Prio priority = Prio.valueOf(scanner.nextLine().toUpperCase());
    
                    System.out.println("Year: ");
                    int year = Integer.parseInt(scanner.nextLine());
    
                    System.out.println("Month: ");
                    int month = Integer.parseInt(scanner.nextLine());
    
                    System.out.println("Day: ");
                    int day = Integer.parseInt(scanner.nextLine());
    
                    LocalDate dueDate = LocalDate.of(year, month, day);
    
                    TodoItem item = new TodoItem(appList.getNextId(), description, priority, dueDate, false);
                    appList.addTodo(item);
    
                    System.out.println("New Todo added! ID: " + item.getId());
                    break;
                case 2:
                    if(appList.getAllTodos().isEmpty()){
                        System.out.println("No Todos found.");
                        System.out.println();
                    } else {
                        for(TodoItem itemInList : appList.getAllTodos()){
                            System.out.println(itemInList);
                        }
                        System.out.println();
                    }
    
                    break;
                case 3:
                    System.out.print("ID of the Todo: ");
                    int removeId = Integer.parseInt(scanner.nextLine());
                    appList.removeTodo(removeId);
                    break;
                case 4:
                    System.out.print("ID of the Todo: ");
                    int completedId = Integer.parseInt(scanner.nextLine());
                    appList.markAsCompleted(completedId);
                    break;
                case 5:
                    handle.saveToFile(appList, "logs/saveTodo.csv");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Option! Pick only 1-5");
                }
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid number!");
            }

            

        }

        scanner.close();
    }
}