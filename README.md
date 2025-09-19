# TaskTracker

A simple CLI-based Task Tracker application that stores tasks in a JSON file. Users can:

- Add, update, and delete tasks
- Mark a task as in progress or done
- List all tasks
- List tasks by status: done, todo, in-progress

## Usage

After running the application, you can enter the following commands:

- `add <task description>` → Adds a new task
    - Example: `add Buy groceries`
- `delete <task id>` → Deletes a task by its ID
    - Example: `delete 2`
- `update <task id> <new description>` → Updates a task description
    - Example: `update 1 Finish homework`
- `mark-done <task id>` → Marks a task as done
    - Example: `mark-done 1`
- `mark-progress <task id>` → Marks a task as in progress
    - Example: `mark-progress 3`
- `list` → Lists all tasks

## Credits

This project idea was inspired by [roadmap.sh - Task Tracker Project](https://roadmap.sh/projects/task-tracker). Thank you for the guidance!
