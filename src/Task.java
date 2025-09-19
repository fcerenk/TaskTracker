import java.time.LocalDate;

public class Task {
    private int id;
    private String description;
    private Status status;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = Status.TODO; //default
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;

    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {

        return updatedAt;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDate.now();
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void markAsDone() {
        this.status = Status.DONE;
        this.updatedAt = LocalDate.now();
    }

    public void markAsProgress() {
        this.status = Status.IN_PROGRESS;
        this.updatedAt = LocalDate.now();
    }


    @Override
    public String toString() {
        return "*" + id + "* " + description + " (" + status + ")";
    }


    //convert list of task to json string
    public String toJson() {
        return String.format(
                "{"
                        + "\"id\":%d,"
                        + "\"description\":\"%s\","
                        + "\"status\":\"%s\","
                        + "\"createdAt\":\"%s\","
                        + "\"updatedAt\":\"%s\""
                        + "}",
                id, description, status, createdAt, updatedAt);
    }


    //convert json string to object of Task
    public static Task fromJson(String json) {
        json = json.replace("{", "").replace("}", "").replace("\"", "");
        String[] parts = json.split(",");
        int id = 0;
        String description = "";
        Status status = Status.TODO;
        LocalDate createdAt = LocalDate.now();
        LocalDate updatedAt = LocalDate.now();
        for (String part : parts) {
            String[] partParts = part.split(":");
            switch (partParts[0].trim()) {
                case "id":
                    id = Integer.parseInt(partParts[1].trim()); //integer to string
                    break;
                case "description":
                    description = partParts[1].trim();
                    break;
                case "status":
                    status = Status.valueOf(partParts[1].trim());   //enum valueof
                    break;
                case "createdAt":
                    createdAt = LocalDate.parse(partParts[1].trim());
                    break;
                case "updatedAt":
                    updatedAt = LocalDate.parse(partParts[1].trim());
                    break;

            }
        }

        Task task = new Task(id, description);
        task.setStatus(status);
        task.setCreatedAt(createdAt);
        task.setUpdatedAt(updatedAt);
        return task;

    }
}
