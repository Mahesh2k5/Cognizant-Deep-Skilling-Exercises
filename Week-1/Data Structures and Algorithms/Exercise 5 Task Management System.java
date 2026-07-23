// Exercise 5: Task Management System
public class Exercise5_TaskManagementSystem {

    public static class Task {
        private String taskId;
        private String taskName;
        private String status;

        public Task(String taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public String getTaskId() { return taskId; }

        @Override
        public String toString() {
            return "Task{id='" + taskId + "', name='" + taskName + "', status='" + status + "'}";
        }
    }

    public static class Node {
        Task task;
        Node next;
        public Node(Task task) { this.task = task; this.next = null; }
    }

    public static class SinglyLinkedList {
        private Node head;

        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public Task searchTask(String taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.getTaskId().equals(taskId)) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        public void traverse() {
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

        public void deleteTask(String taskId) {
            if (head == null) return;
            if (head.task.getTaskId().equals(taskId)) {
                head = head.next;
                return;
            }
            Node current = head;
            while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addTask(new Task("T1", "Setup DB", "Pending"));
        list.addTask(new Task("T2", "Create API", "In Progress"));
        list.addTask(new Task("T3", "Write Tests", "Pending"));

        System.out.println("All Tasks:");
        list.traverse();

        System.out.println("\nSearch T2: " + list.searchTask("T2"));

        System.out.println("\nDeleting T2");
        list.deleteTask("T2");
        list.traverse();
    }
}
