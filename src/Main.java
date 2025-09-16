
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


        String command = scanner.nextLine();
        System.out.println("Input command: " + command);
        String[] splittedCommand = command.split(" ");
        String action = splittedCommand[0];
        String otherPart = String.join(" ", Arrays.copyOfRange(splittedCommand,1,splittedCommand.length));

        switch (action) {
                case "add":
                    manager.addTask(otherPart);
                    break;
                case "delete":
                    manager.removeTask(otherPart);
                    break;
                    case "list":
                       manager.listTasks();
                        break;
            case "update":
                int index = Integer.parseInt(splittedCommand[1]) - 1;
                String newTask = String.join(" ", Arrays.copyOfRange(splittedCommand, 2, splittedCommand.length));
                manager.updateTask(index, newTask);
                System.out.println("Updating " + otherPart);
                break;
            default:
                System.out.println("Unknown command: " + action);
                break;

        }


    }



}