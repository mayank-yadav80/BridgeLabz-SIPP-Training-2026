import java.util.*;

public class BrowserHistoryReverse {

    static class Node {
        int pageId;
        Node next;

        Node(int pageId) {
            this.pageId = pageId;
            this.next = null;
        }
    }

    public static Node reverseHistory(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.pageId + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of pages in history: ");
        int n = sc.nextInt();
        if (n == 0) { System.out.println("Empty history."); return; }

        System.out.println("Enter page IDs (most recent first):");
        Node head = new Node(sc.nextInt());
        Node tail = head;
        for (int i = 1; i < n; i++) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }

        System.out.println("Before reversing:");
        printList(head);

        head = reverseHistory(head);

        System.out.println("After reversing:");
        printList(head);
    }
}
