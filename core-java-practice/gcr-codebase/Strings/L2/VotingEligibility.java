import java.util.Scanner;

public class VotingEligibility {
    
    // Method to generate random ages for students
    public static int[] generateRandomAges(int numberOfStudents) {
        int[] ages = new int[numberOfStudents];
        
        for (int i = 0; i < numberOfStudents; i++) {
            ages[i] = (int)(Math.random() * 81) + 10; // Random age between 10 and 90
        }
        
        return ages;
    }
    
    // Method to check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] votingData = new String[ages.length][2];
        
        for (int i = 0; i < ages.length; i++) {
            votingData[i][0] = String.valueOf(ages[i]);
            
            if (ages[i] < 0) {
                votingData[i][1] = "Invalid";
            } else if (ages[i] >= 18) {
                votingData[i][1] = "Can Vote";
            } else {
                votingData[i][1] = "Cannot Vote";
            }
        }
        
        return votingData;
    }
    
    // Method to display 2D array in tabular format
    public static void displayResults(String[][] votingData) {
        System.out.println("\n--- Voting Eligibility Check ---");
        System.out.println("Student\tAge\tEligibility");
        System.out.println("-------\t---\t-----------");
        
        for (int i = 0; i < votingData.length; i++) {
            System.out.println((i + 1) + "\t" + votingData[i][0] + "\t" + votingData[i][1]);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfStudents = 10;
        
        // Generate random ages
        int[] ages = generateRandomAges(numberOfStudents);
        
        // Check voting eligibility
        String[][] votingData = checkVotingEligibility(ages);
        
        // Display results
        displayResults(votingData);
        
        scanner.close();
    }
}
