import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GroceryBillReader {
    public static void main(String[] args) {
        String billFile = "bill.txt";
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(billFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }
            System.out.println("Total lines: " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("Bill file not found: " + billFile);
        } catch (IOException e) {
            System.out.println("Error reading the bill file.");
        }
    }
}
