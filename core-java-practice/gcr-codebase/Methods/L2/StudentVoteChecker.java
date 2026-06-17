import java.util.Scanner;

public class StudentVoteChecker {
    public static boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[10];
        for (int i = 0; i < ages.length; i++) {
            System.out.printf("Enter age for student %d: ", i + 1);
            ages[i] = scanner.nextInt();
        }
        for (int i = 0; i < ages.length; i++) {
            boolean canVote = canStudentVote(ages[i]);
            System.out.printf("Student %d age %d: %s%n", i + 1, ages[i], canVote ? "Can vote" : "Cannot vote");
        }
        scanner.close();
    }
}
