import java.util.*;

public class SortedLogMerge {

    static class Node {
        int timestamp;
        Node next;

        Node(int timestamp) {
            this.timestamp = timestamp;
            this.next = null;
        }
    }

    public static Node mergeLogStreams(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;
        while (a != null && b != null) {
            if (a.timestamp <= b.timestamp) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.timestamp + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of logs in stream 1: ");
        int n = sc.nextInt();
        Node a = null, aTail = null;
        if (n > 0) {
            System.out.println("Enter timestamps (sorted):");
            a = new Node(sc.nextInt());
            aTail = a;
            for (int i = 1; i < n; i++) {
                aTail.next = new Node(sc.nextInt());
                aTail = aTail.next;
            }
        }

        System.out.print("Enter number of logs in stream 2: ");
        int m = sc.nextInt();
        Node b = null, bTail = null;
        if (m > 0) {
            System.out.println("Enter timestamps (sorted):");
            b = new Node(sc.nextInt());
            bTail = b;
            for (int i = 1; i < m; i++) {
                bTail.next = new Node(sc.nextInt());
                bTail = bTail.next;
            }
        }

        System.out.println("Stream 1:");
        printList(a);
        System.out.println("Stream 2:");
        printList(b);

        Node merged = mergeLogStreams(a, b);

        System.out.println("Merged sorted stream:");
        printList(merged);
    }
}
