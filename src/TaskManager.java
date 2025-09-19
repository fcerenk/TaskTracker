
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TaskManager {
    List<Task> tasks = new ArrayList<>();
    private static final String FILE_NAME = "tasks.json";


    public void saveTasksToFile() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(tasks.get(i).toJson());
            if (i < tasks.size() - 1) {
                sb.append(",\n");
            }
        }
        sb.append("]");
        String jsonArrayString = sb.toString();


        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(jsonArrayString);
        } catch (IOException ex) {
            System.out.println("Error writing tasks to file: " + ex.getMessage());
        }
    }

    public void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String content = sb.toString().trim();

            if (content.isEmpty() || content.equals("[]")) return;

            content = content.substring(1, content.length() - 1);

            String[] taskStrings = content.split("},\\s*\\{");
            for (int i = 0; i < taskStrings.length; i++) {
                String taskStr = taskStrings[i];
                if (i != 0) taskStr = "{" + taskStr;
                if (i != taskStrings.length - 1) taskStr = taskStr + "}";
                Task task = Task.fromJson(taskStr);
                tasks.add(task);
            }

        } catch (IOException e) {
            System.out.println("Error reading tasks file: " + e.getMessage());
        }
    }


    //adding
    public void addTask(Task task) {
        tasks.add(task);
        saveTasksToFile();
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
        saveTasksToFile();
        System.out.println("Deleting " + task);

    }

    //updating
    public void updateDescription(int index, String newDescription) {
        Task task = tasks.get(index);
        task.setDescription(newDescription);
        saveTasksToFile();
        System.out.println("Updating " + task);
    }

    //mark as done
    public void markTaskAsDone(int index) {
        Task task = tasks.get(index);
        task.markAsDone();
        saveTasksToFile();
        System.out.println("Marking " + task);
    }

    //mark in progress
    public void markTaskAsProgress(int index) {
        Task task = tasks.get(index);
        task.markAsProgress();
        saveTasksToFile();
        System.out.println("Marking " + task);
    }


}
