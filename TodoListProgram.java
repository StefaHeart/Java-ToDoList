// This program is a simple to-do list manager that allows users to add, complete, and view tasks from a text-based menu.


// ==============================
// TodoListProgram.java
// Main driver program for the To-Do List application
// Handles user input and manages task interactions
// ==============================

import java.util.ArrayList; // Imports the ArrayList class to store tasks
import java.util.Scanner;   // Imports Scanner for reading user input

// ==============================
// MAIN PROGRAM CLASS
// ==============================
public class TodoListProgram {
    public static void main(String[] args) {

        // ==============================
        // INITIALIZE INPUT AND TASK LIST
        // ==============================
        Scanner scanner = new Scanner(System.in); // Used to read user input
        ArrayList<Task> tasks = new ArrayList<>(); // List to store Task objects
        boolean running = true; // Controls the main loop

        // ==============================
        // MAIN MENU LOOP
        // Continues until user chooses to exit
        // ==============================
        while (running) {
            // === DISPLAY MENU OPTIONS ===
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Complete Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            // === READ AND VALIDATE MENU CHOICE ===
            String input = scanner.nextLine(); // Read user input as a string
            int choice;

            try {
                choice = Integer.parseInt(input); // Try to convert to integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 4.");
                continue; // Restart loop if input is invalid
            }

            // === PROCESS MENU CHOICE ===
            switch (choice) {
                case 1:
                    // === ADD TASK ===
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine(); // Read the task description
                    tasks.add(new Task(description)); // Create and add new Task
                    System.out.println("Task added!");
                    break;

                case 2:
                    // === COMPLETE TASK ===
                    System.out.print("Enter task number to mark as completed: ");
                    String taskInput = scanner.nextLine(); // Read task number input
                    int taskNumber;
                    try {
                        taskNumber = Integer.parseInt(taskInput); // Try to convert to integer
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid task number.");
                        break; // Exit case if invalid
                    }

                    // Check if task number is within valid range
                    if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                        tasks.get(taskNumber - 1).markCompleted(); // Mark task as completed
                        System.out.println("Task marked as completed!");
                    } else {
                        System.out.println("Invalid task number."); // Handle out-of-range input
                    }
                    break;

                case 3:
                    // === VIEW TASKS ===
                    System.out.println("\nYour Tasks:");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available."); // Let user know if list is empty
                    } else {
                        // Loop through tasks and display their status
                        for (int i = 0; i < tasks.size(); i++) {
                            Task task = tasks.get(i);
                            String status = task.isCompleted() ? "[X]" : "[ ]"; // Mark completed with [X]
                            System.out.println((i + 1) + ". " + status + " " + task.getDescription());
                        }
                    }
                    break;

                case 4:
                    // === EXIT PROGRAM ===
                    System.out.println("Goodbye!");
                    running = false; // End the loop and program
                    break;

                default:
                    // === HANDLE INVALID MENU CHOICE ===
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        // === CLEANUP ===
        scanner.close(); // Close scanner to free system resources
    }
}
