import java.util.*;

public class ERTriageQueue {

    static class Patient {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        @Override
        public String toString() {
            return name + " (severity: " + severity + ")";
        }
    }

    private PriorityQueue<Patient> triageQueue;

    public ERTriageQueue() {
        triageQueue = new PriorityQueue<>((a, b) -> b.severity - a.severity);
    }

    public void addPatient(Patient p) {
        triageQueue.offer(p);
        System.out.println("Admitted: " + p);
    }

    public Patient treatNext() {
        return triageQueue.poll();
    }

    public Patient peekNext() {
        return triageQueue.peek();
    }

    public boolean isEmpty() {
        return triageQueue.isEmpty();
    }

    public int size() {
        return triageQueue.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ERTriageQueue triage = new ERTriageQueue();

        while (true) {
            System.out.println("\n1. Add patient  2. Treat next  3. Peek next  4. Size  5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 5) break;
            switch (ch) {
                case 1:
                    System.out.print("Patient name: ");
                    String name = sc.nextLine();
                    System.out.print("Severity (higher = more severe): ");
                    int sev = sc.nextInt();
                    triage.addPatient(new Patient(name, sev));
                    break;
                case 2:
                    Patient next = triage.treatNext();
                    if (next != null) System.out.println("Treating: " + next);
                    else System.out.println("No patients waiting.");
                    break;
                case 3:
                    Patient peek = triage.peekNext();
                    if (peek != null) System.out.println("Next in line: " + peek);
                    else System.out.println("No patients waiting.");
                    break;
                case 4:
                    System.out.println("Waiting: " + triage.size());
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
