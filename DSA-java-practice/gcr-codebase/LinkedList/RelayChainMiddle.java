import java.util.*;

public class RelayChainMiddle {

    static class Node {
        int serverId;
        Node next;

        Node(int serverId) {
            this.serverId = serverId;
            this.next = null;
        }
    }

    public static Node findMiddleServer(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.serverId + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of servers in chain: ");
        int n = sc.nextInt();
        if (n == 0) { System.out.println("Empty chain."); return; }

        System.out.println("Enter server IDs:");
        Node head = new Node(sc.nextInt());
        Node tail = head;
        for (int i = 1; i < n; i++) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }

        printList(head);

        Node middle = findMiddleServer(head);
        System.out.println("Middle server (maintenance target): " + middle.serverId);
    }
}
