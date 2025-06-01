// This program is a simple to-do list manager that allows users to add, complete, and view tasks from a text-based menu.


// ==============================
// Task.java
// Class that defines a single task for the to-do list
// ==============================

public class Task {

    // ==============================
    // INSTANCE VARIABLES
    // Stores the description of the task
    // And whether or not the task is completed
    // ==============================
    private String description;
    private boolean completed;

    // ==============================
    // CONSTRUCTOR
    // Called when a new Task object is created
    // Sets the task description and marks it as incomplete by default
    // ==============================
    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    // ==============================
    // GETTER METHOD
    // Returns the task description as a String
    // ==============================
    public String getDescription() {
        return description;
    }

    // ==============================
    // GETTER METHOD
    // Returns whether the task is completed (true/false)
    // ==============================
    public boolean isCompleted() {
        return completed;
    }

    // ==============================
    // ACTION METHOD
    // Sets the task status to completed (true)
    // Called when the user marks a task as complete
    // ==============================
    public void markCompleted() {
        completed = true;
    }
}
