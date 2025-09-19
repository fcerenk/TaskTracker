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
        return "[" + id + "] " + description + " (" + status + ")";
    }
}
