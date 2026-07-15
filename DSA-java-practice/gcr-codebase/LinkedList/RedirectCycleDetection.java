import java.util.*;

public class RedirectCycleDetection {

    static class Node {
        int urlId;
        Node next;

        Node(int urlId) {
            this.urlId = urlId;
            this.next = null;
        }
    }

    public static boolean hasRedirectLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.urlId + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of URLs in redirect chain: ");
        int n = sc.nextInt();
        if (n == 0) { System.out.println("Empty chain."); return; }

        System.out.println("Enter URL IDs:");
        Node head = new Node(sc.nextInt());
        Node tail = head;
        for (int i = 1; i < n; i++) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }

        System.out.print("Enter index to create cycle (0-based, -1 for no cycle): ");
        int cycleIdx = sc.nextInt();
        if (cycleIdx >= 0 && cycleIdx < n) {
            Node cycleNode = head;
            for (int i = 0; i < cycleIdx; i++) cycleNode = cycleNode.next;
            tail.next = cycleNode;
        }

        boolean hasLoop = hasRedirectLoop(head);
        System.out.println(hasLoop ? "Redirect loop detected!" : "No redirect loop found.");
    }
}
