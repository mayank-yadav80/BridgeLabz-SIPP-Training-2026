import java.util.*;

public class TaskQueueDeletion {

    static class Node {
        int taskId;
        Node next;

        Node(int taskId) {
            this.taskId = taskId;
            this.next = null;
        }
    }

    public static Node removeTask(Node head, int taskId) {
        if (head == null) return null;
        if (head.taskId == taskId) return head.next;

        Node prev = head, curr = head.next;
        while (curr != null && curr.taskId != taskId) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
        }
        return head;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.taskId + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();
        if (n == 0) { System.out.println("Empty queue."); return; }

        System.out.println("Enter task IDs:");
        Node head = new Node(sc.nextInt());
        Node tail = head;
        for (int i = 1; i < n; i++) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }

        System.out.print("Enter completed task ID to remove: ");
        int taskId = sc.nextInt();

        System.out.println("Before removal:");
        printList(head);

        head = removeTask(head, taskId);

        System.out.println("After removing task " + taskId + ":");
        printList(head);
    }
}
