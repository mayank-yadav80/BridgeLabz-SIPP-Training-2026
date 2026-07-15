import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfEmployees = 10;
        double[] salaries = new double[numberOfEmployees];
        double[] yearsOfService = new double[numberOfEmployees];
        double[] bonusAmounts = new double[numberOfEmployees];
        double[] newSalaries = new double[numberOfEmployees];
        
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;
        
        System.out.println("Enter salary and years of service for 10 employees:");
        
        for (int i = 0; i < numberOfEmployees; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("\nEmployee " + (i + 1) + " salary: ");
                double salary = scanner.nextDouble();
                
                System.out.print("Employee " + (i + 1) + " years of service: ");
                double years = scanner.nextDouble();
                
                if (salary < 0 || years < 0) {
                    System.out.println("Invalid input! Salary and years of service must be non-negative. Please try again.");
                } else {
                    salaries[i] = salary;
                    yearsOfService[i] = years;
                    validInput = true;
                }
            }
        }
        
        System.out.println("\n--- Calculating Bonuses ---");
        for (int i = 0; i < numberOfEmployees; i++) {
            double bonusPercentage;
            if (yearsOfService[i] > 5) {
                bonusPercentage = 0.05; // 5% bonus
            } else {
                bonusPercentage = 0.02; // 2% bonus
            }
            
            bonusAmounts[i] = salaries[i] * bonusPercentage;
            newSalaries[i] = salaries[i] + bonusAmounts[i];
            
            totalBonus += bonusAmounts[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }
        
        System.out.println("\n--- Employee Bonus Details ---");
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            System.out.println("  Old Salary: " + salaries[i]);
            System.out.println("  Years of Service: " + yearsOfService[i]);
            System.out.println("  Bonus: " + bonusAmounts[i]);
            System.out.println("  New Salary: " + newSalaries[i]);
        }
        
        System.out.println("\n--- Summary ---");
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
        
        scanner.close();
    }
}
