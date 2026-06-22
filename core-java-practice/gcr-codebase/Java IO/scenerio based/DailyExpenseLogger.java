import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DailyExpenseLogger {
    public static void main(String[] args) {
        String expenseFile = "expenses.txt";
        try (Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter(expenseFile, true)) {
            System.out.println("Enter expense details in the format Category - Amount. Type 'exit' to stop.");
            while (true) {
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                if (input.isEmpty()) {
                    continue;
                }
                writer.write(input + System.lineSeparator());
                System.out.println("Logged: " + input);
            }
            System.out.println("Expenses appended to " + expenseFile);
        } catch (IOException e) {
            System.out.println("Unable to write expense data.");
        }
    }
}
