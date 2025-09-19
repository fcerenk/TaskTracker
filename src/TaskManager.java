
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TaskManager {
    List<Task> tasks = new ArrayList<>();


    //adding
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Adding " + task);

    }

    //listAll
    public void listTasks() {
        for (Task task : tasks) {
            System.out.println("Listing of all tasks: " + task);
        }
    }

    //deleting
    public void removeTask(int index) {
        Task task = tasks.remove(index);

        System.out.println("Deleting " + task);

    }

    //updating
    public void updateDescription(int index, String newDescription) {
        Task task = tasks.get(index);
        task.setDescription(newDescription);
        System.out.println("Updating " + task);
    }

    //mark as done
    public void markTaskAsDone(int index) {
        Task task = tasks.get(index);
        task.markAsDone();
        System.out.println("Marking " + task);
    }

    //mark in progress
    public void markTaskAsProgress(int index) {
        Task task = tasks.get(index);
        task.markAsProgress();
        System.out.println("Marking " + task);
    }


}
