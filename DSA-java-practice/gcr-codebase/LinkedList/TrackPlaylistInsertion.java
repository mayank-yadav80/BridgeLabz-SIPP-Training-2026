import java.util.*;

public class TrackPlaylistInsertion {

    static class Node {
        int trackId;
        Node next;

        Node(int trackId) {
            this.trackId = trackId;
            this.next = null;
        }
    }

    public static void insertAfter(Node current, int trackId) {
        Node newNode = new Node(trackId);
        newNode.next = current.next;
        current.next = newNode;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.trackId + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tracks in playlist: ");
        int n = sc.nextInt();
        if (n == 0) { System.out.println("Empty playlist."); return; }

        System.out.println("Enter track IDs:");
        Node head = new Node(sc.nextInt());
        Node tail = head;
        for (int i = 1; i < n; i++) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }

        System.out.print("Enter index of currently playing track (0-based): ");
        int idx = sc.nextInt();
        Node current = head;
        for (int i = 0; i < idx && current != null; i++) current = current.next;

        System.out.print("Enter new track ID to insert: ");
        int trackId = sc.nextInt();

        System.out.println("Before insertion:");
        printList(head);

        insertAfter(current, trackId);

        System.out.println("After inserting " + trackId + " after index " + idx + ":");
        printList(head);
    }
}
