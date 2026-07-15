import java.util.*;

public class PrintQueueRush {

    private Deque<Integer> printQueue;

    public PrintQueueRush() {
        printQueue = new ArrayDeque<>();
    }

    public void submitJob(int jobId) {
        printQueue.addLast(jobId);
        System.out.println("Normal job " + jobId + " submitted.");
    }

    public void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId);
        System.out.println("Urgent job " + jobId + " pushed to front.");
    }

    public int printNextJob() {
        if (printQueue.isEmpty()) throw new RuntimeException("No jobs in queue");
        return printQueue.removeFirst();
    }

    public int peekNext() {
        if (printQueue.isEmpty()) throw new RuntimeException("No jobs in queue");
        return printQueue.peekFirst();
    }

    public boolean isEmpty() {
        return printQueue.isEmpty();
    }

    public int size() {
        return printQueue.size();
    }

    public void display() {
        if (printQueue.isEmpty()) { System.out.println("[ ]"); return; }
        System.out.print("[ ");
        int i = 0;
        for (int job : printQueue) {
            System.out.print(job);
            if (i < printQueue.size() - 1) System.out.print(", ");
            i++;
        }
        System.out.println(" ] (front -> rear)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintQueueRush queue = new PrintQueueRush();

        while (true) {
            System.out.println("\n1. Submit normal job  2. Submit urgent job  3. Print next job  4. Peek  5. Display  6. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 6) break;
            switch (ch) {
                case 1:
                    System.out.print("Enter job ID: ");
                    queue.submitJob(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter urgent job ID: ");
                    queue.submitUrgentJob(sc.nextInt());
                    break;
                case 3:
                    try { System.out.println("Printing job: " + queue.printNextJob()); }
                    catch (RuntimeException e) { System.out.println(e.getMessage()); }
                    break;
                case 4:
                    try { System.out.println("Next job: " + queue.peekNext()); }
                    catch (RuntimeException e) { System.out.println(e.getMessage()); }
                    break;
                case 5:
                    queue.display();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
