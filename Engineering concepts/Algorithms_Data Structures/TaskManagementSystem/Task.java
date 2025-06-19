package TaskManagementSystem;

import java.util.Scanner;

public class Task {
    String taskId;
    String taskName;
    String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }

    static class TaskNode {
        Task task;
        TaskNode next;

        public TaskNode(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    static class TaskManager {
        private TaskNode head = null;

        public void addTask(Task task) {
            TaskNode newNode = new TaskNode(task);
            if (head == null) {
                head = newNode;
            } else {
                TaskNode temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            System.out.println("Task added: " + task.taskName);
        }

        public Task searchTask(String taskId) {
            TaskNode current = head;
            while (current != null) {
                if (current.task.taskId.equals(taskId)) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        public void traverseTasks() {
            System.out.println("\n--- Task List ---");
            TaskNode current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

        public void deleteTask(String taskId) {
            if (head == null) {
                System.out.println("Task list is empty.");
                return;
            }

            if (head.task.taskId.equals(taskId)) {
                head = head.next;
                System.out.println("Task with ID " + taskId + " deleted.");
                return;
            }

            TaskNode prev = head;
            TaskNode current = head.next;

            while (current != null) {
                if (current.task.taskId.equals(taskId)) {
                    prev.next = current.next;
                    System.out.println("Task with ID " + taskId + " deleted.");
                    return;
                }
                prev = current;
                current = current.next;
            }

            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        System.out.print("Enter number of tasks to add: ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= count; i++) {
            System.out.println("Enter details for Task " + i + ":");
            System.out.print("Task ID: ");
            String id = scanner.nextLine();
            System.out.print("Task Name: ");
            String name = scanner.nextLine();
            System.out.print("Task Status: ");
            String status = scanner.nextLine();
            manager.addTask(new Task(id, name, status));
        }

        manager.traverseTasks();

        System.out.print("\nEnter Task ID to search: ");
        String searchId = scanner.nextLine();
        Task found = manager.searchTask(searchId);
        System.out.println(found != null ? found : "Task not found.");

        System.out.print("\nEnter Task ID to delete: ");
        String deleteId = scanner.nextLine();
        manager.deleteTask(deleteId);

        manager.traverseTasks();
        scanner.close();
    }
}
