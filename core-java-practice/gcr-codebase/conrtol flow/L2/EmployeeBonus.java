import java.util.Scanner;

class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter salary: ");
        double salary = input.nextDouble();
        System.out.print("Enter years of service: ");
        int yearsOfService = input.nextInt();

        if (salary < 0 || yearsOfService < 0) {
            System.out.println("Please enter valid non-negative salary and years of service.");
        } else {
            double bonus = 0.0;
            if (yearsOfService > 5) {
                bonus = salary * 0.05;
            }
            System.out.println("Bonus amount: " + bonus);
        }
        input.close();
    }
}
