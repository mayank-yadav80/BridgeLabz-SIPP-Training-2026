import java.util.*;

public class CircularPacketBuffer {

    private int[] data;
    private int front, count;
    private int capacity;

    public CircularPacketBuffer(int capacity) {
        data = new int[capacity];
        front = 0;
        count = 0;
        this.capacity = capacity;
    }

    public boolean enqueue(int packetId) {
        if (count == data.length) return false;
        data[(front + count) % data.length] = packetId;
        count++;
        return true;
    }

    public int dequeue() {
        if (count == 0) throw new RuntimeException("Buffer empty");
        int val = data[front];
        front = (front + 1) % data.length;
        count--;
        return val;
    }

    public int peek() {
        if (count == 0) throw new RuntimeException("Buffer empty");
        return data[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == data.length;
    }

    public int size() {
        return count;
    }

    public void display() {
        if (isEmpty()) { System.out.println("[ ]"); return; }
        System.out.print("[ ");
        for (int i = 0; i < count; i++) {
            System.out.print(data[(front + i) % data.length]);
            if (i < count - 1) System.out.print(", ");
        }
        System.out.println(" ] (front -> rear)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter buffer capacity: ");
        int capacity = sc.nextInt();

        CircularPacketBuffer buffer = new CircularPacketBuffer(capacity);

        while (true) {
            System.out.println("\n1. Enqueue (packet arrives)  2. Dequeue (packet processed)  3. Peek  4. Display  5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 5) break;
            switch (ch) {
                case 1:
                    System.out.print("Enter packet ID: ");
                    int pid = sc.nextInt();
                    if (buffer.enqueue(pid)) System.out.println("Packet " + pid + " enqueued.");
                    else System.out.println("Buffer full! Packet rejected.");
                    break;
                case 2:
                    try { System.out.println("Processed packet: " + buffer.dequeue()); }
                    catch (RuntimeException e) { System.out.println(e.getMessage()); }
                    break;
                case 3:
                    try { System.out.println("Next packet: " + buffer.peek()); }
                    catch (RuntimeException e) { System.out.println(e.getMessage()); }
                    break;
                case 4:
                    buffer.display();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
