import java.util.*;

public class HospitalERTriage {

    static class Patient {
        int priority;
        String name;

        Patient(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        @Override
        public String toString() {
            return name + " (priority: " + priority + ")";
        }
    }

    private PriorityQueue<Patient> triageQueue;

    public HospitalERTriage() {
        triageQueue = new PriorityQueue<>((a, b) -> a.priority - b.priority);
    }

    public void admitPatient(Patient p) {
        triageQueue.offer(p);
        System.out.println("Admitted: " + p);
    }

    public Patient callNextPatient() {
        if (triageQueue.isEmpty()) throw new RuntimeException("No patients waiting");
        return triageQueue.poll();
    }

    public Patient peekNext() {
        if (triageQueue.isEmpty()) throw new RuntimeException("No patients waiting");
        return triageQueue.peek();
    }

    public boolean isEmpty() {
        return triageQueue.isEmpty();
    }

    public int size() {
        return triageQueue.size();
    }

    public void display() {
        if (triageQueue.isEmpty()) { System.out.println("No patients waiting."); return; }
        Object[] sorted = triageQueue.toArray();
        Arrays.sort(sorted, (a, b) -> ((Patient) a).priority - ((Patient) b).priority);
        System.out.print("Waiting room: ");
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i]);
            if (i < sorted.length - 1) System.out.print(" -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalERTriage triage = new HospitalERTriage();

        while (true) {
            System.out.println("\n1. Admit patient  2. Call next patient  3. Peek next  4. Display  5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 5) break;
            switch (ch) {
                case 1:
                    System.out.print("Patient name: ");
                    String name = sc.nextLine();
                    System.out.print("Priority (1=critical, 5=least urgent): ");
                    int prio = sc.nextInt();
                    triage.admitPatient(new Patient(prio, name));
                    break;
                case 2:
                    try { System.out.println("Calling: " + triage.callNextPatient()); }
                    catch (RuntimeException e) { System.out.println(e.getMessage()); }
                    break;
                case 3:
                    try { System.out.println("Next in line: " + triage.peekNext()); }
                    catch (RuntimeException e) { System.out.println(e.getMessage()); }
                    break;
                case 4:
                    triage.display();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
