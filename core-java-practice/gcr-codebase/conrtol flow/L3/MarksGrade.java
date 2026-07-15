import java.util.Scanner;

class MarksGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Physics marks: ");
        double p = input.nextDouble();
        System.out.print("Enter Chemistry marks: ");
        double c = input.nextDouble();
        System.out.print("Enter Maths marks: ");
        double m = input.nextDouble();

        double total = p + c + m;
        double percentage = total / 3.0;

        String grade;
        String remarks;
        if (percentage >= 90) {
            grade = "A";
            remarks = "Excellent";
        } else if (percentage >= 75) {
            grade = "B";
            remarks = "Very Good";
        } else if (percentage >= 60) {
            grade = "C";
            remarks = "Good";
        } else if (percentage >= 40) {
            grade = "D";
            remarks = "Needs Improvement";
        } else {
            grade = "F";
            remarks = "Fail";
        }

        System.out.println("Average Mark: " + String.format("%.2f", percentage));
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
        input.close();
    }
}
