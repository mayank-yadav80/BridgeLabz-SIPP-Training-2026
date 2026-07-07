import java.util.*;

public class SmartClassroomAttendanceTracker {
    private HashMap<String, ArrayList<String>> attendanceMap;

    public SmartClassroomAttendanceTracker() {
        attendanceMap = new HashMap<>();
    }

    public void markAttendance(String subject, String studentName) {
        ArrayList<String> students = attendanceMap.get(subject);
        if (students == null) {
            students = new ArrayList<>();
            attendanceMap.put(subject, students);
        }
        if (students.contains(studentName)) {
            System.out.println("Duplicate attendance rejected: " + studentName + " already marked for " + subject);
            return;
        }
        students.add(studentName);
        System.out.println("Attendance marked: " + studentName + " for " + subject);
    }

    public void displayAttendance() {
        if (attendanceMap.isEmpty()) {
            System.out.println("No attendance records.");
            return;
        }
        for (Map.Entry<String, ArrayList<String>> entry : attendanceMap.entrySet()) {
            String subject = entry.getKey();
            ArrayList<String> students = entry.getValue();
            System.out.println("Subject: " + subject + " (Total: " + students.size() + ")");
            if (students.isEmpty()) continue;
            for (int i = 0; i < students.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + students.get(i));
            }
        }
    }

    public void showTotalBySubject(String subject) {
        ArrayList<String> students = attendanceMap.get(subject);
        int total = (students == null) ? 0 : students.size();
        System.out.println("Students present in " + subject + ": " + total);
    }

    public static void main(String[] args) {
        SmartClassroomAttendanceTracker tracker = new SmartClassroomAttendanceTracker();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Smart Classroom Attendance Tracker ---");
            System.out.println("1. Mark Attendance");
            System.out.println("2. Display Attendance");
            System.out.println("3. Show Total for Subject");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print("Subject: "); String s = sc.nextLine();
                    System.out.print("Student Name: "); String n = sc.nextLine();
                    tracker.markAttendance(s, n);
                }
                case 2 -> tracker.displayAttendance();
                case 3 -> {
                    System.out.print("Subject: "); String s = sc.nextLine();
                    tracker.showTotalBySubject(s);
                }
                case 4 -> { System.out.println("Bye."); return; }
                default -> System.out.println("Invalid.");
            }
        }
    }
}
