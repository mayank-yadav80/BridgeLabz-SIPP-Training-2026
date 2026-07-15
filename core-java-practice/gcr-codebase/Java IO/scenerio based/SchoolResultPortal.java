import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SchoolResultPortal {
    public static void main(String[] args) {
        String inputFile = "student_results.txt";
        String outputFile = "report_cards.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile, true)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 2) {
                    continue;
                }
                String name = parts[0].trim();
                double total = 0;
                int count = 0;
                for (int i = 1; i < parts.length; i++) {
                    try {
                        total += Double.parseDouble(parts[i].trim());
                        count++;
                    } catch (NumberFormatException e) {
                        // Skip invalid marks
                    }
                }
                if (count > 0) {
                    double average = total / count;
                    String report = String.format("%s: Average = %.2f (%s)%n", name, average, line.substring(name.length() + 1));
                    writer.write(report);
                }
            }
            System.out.println("Report cards appended to " + outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
        } catch (IOException e) {
            System.out.println("An I/O error occurred while processing the student results.");
        }
    }
}
