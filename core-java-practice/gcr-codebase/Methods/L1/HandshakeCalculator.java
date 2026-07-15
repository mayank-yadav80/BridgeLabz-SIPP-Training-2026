import java.util.Scanner;

public class HandshakeCalculator {
    public static int calculateHandshakes(int numberOfStudents) {
        return numberOfStudents * (numberOfStudents - 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int students = scanner.nextInt();
        int handshakes = calculateHandshakes(students);
        System.out.printf("Maximum number of possible handshakes among %d students is %d\n", students, handshakes);
        scanner.close();
    }
}
