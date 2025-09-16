
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TaskManager {
    List<String> tasks = new ArrayList<>();
    //adding
    public void addTask(String task){
        tasks.add(task);
        System.out.println("Adding " + task);

    }

    //listAll
    public void listTasks(){
        for(String task : tasks) {
            System.out.println(task);
        }
    }
    //deleting
    public void removeTask(String task){
        tasks.remove(task);
        System.out.println("Deleting " + task);

    }

    //updating
    public  void updateTask(int index,String newTask) {
        try {
            tasks.set(index, newTask);
            System.out.println("Updated task " + (index + 1) + " to: " + newTask);
        } catch (Exception e) {
            System.out.println("Invalid command or task number");
        }
    }

}
