
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("----Welcome task tracker!----");
        System.out.print(" Please enter the name of the task: ");

        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        int nextId = 1;
        while (true) {

            System.out.println("Enter command: ");
            String command = scanner.nextLine();

            String[] splittedCommand = command.split(" ");
            String action = splittedCommand[0];
            String otherPart = String.join(" ", Arrays.copyOfRange(splittedCommand, 1, splittedCommand.length));

            switch (action) {
                case "add":
                    if (otherPart.isBlank()) {
                        System.out.println("You must enter a task name.");
                        break;
                    }
                    Task newTask = new Task(nextId++, otherPart);
                    manager.addTask(newTask);
                    break;
                case "delete":
                    if (otherPart.isBlank()) {
                        System.out.println("You must enter a task name.");
                        break;
                    }
                    try {
                        int deleteId = Integer.parseInt(otherPart) - 1;
                        manager.removeTask(deleteId);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid task id: " + otherPart);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Not found task id: " + otherPart);
                    }
                    break;
                case "list":
                    manager.listTasks();
                    break;
                case "update":
                    if (splittedCommand.length < 3) {
                        System.out.println("You must enter task name at least 3 characters.");
                        break;
                    }
                    try {
                        int upIndex = Integer.parseInt(splittedCommand[1]) - 1;
                        String newDesc = String.join(" ", Arrays.copyOfRange(splittedCommand, 2, splittedCommand.length));
                        manager.updateDescription(upIndex, newDesc);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid task id: " + splittedCommand[1]);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Not found task id: " + splittedCommand[1]);
                    }

                    break;
                case "mark-done":
                    if (otherPart.isBlank()) {
                        System.out.println("You must enter a task name.");
                        break;
                    }
                    try {
                        int doneId = Integer.parseInt(otherPart) - 1;
                        manager.markTaskAsDone(doneId);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid task id: " + otherPart);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Not found task id: " + otherPart);
                    }

                    break;
                case "mark-progress":
                    if (otherPart.isBlank()) {
                        System.out.println("You must enter a task name.");
                        break;
                    }
                    try {
                        int inProgressId = Integer.parseInt(otherPart) - 1;
                        manager.markTaskAsProgress(inProgressId);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid task id: " + otherPart);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Not found task id: " + otherPart);
                    }

                    break;
                case "exit":
                    System.out.println("Exiting task tracker!");
                    return;
                default:
                    System.out.println("Unknown command: " + action);
                    break;

            }
        }


    }


}