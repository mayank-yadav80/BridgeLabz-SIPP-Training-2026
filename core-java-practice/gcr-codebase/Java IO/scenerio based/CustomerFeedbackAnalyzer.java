import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter 5 feedback messages:");
            int goodCount = 0;
            for (int i = 0; i < 5; i++) {
                String feedback = reader.readLine();
                if (feedback != null && feedback.toLowerCase().contains("good")) {
                    goodCount++;
                }
            }
            System.out.println("Good Feedback Count = " + goodCount);
        } catch (IOException e) {
            System.out.println("Error reading feedback messages.");
        }
    }
}
