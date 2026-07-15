import java.util.Scanner;

public class RockPaperScissors {
    
    // Method to get computer's choice
    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);
        
        switch (choice) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            case 2:
                return "Scissors";
            default:
                return "Rock";
        }
    }
    
    // Method to determine winner
    public static String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equalsIgnoreCase(computerChoice)) {
            return "Draw";
        }
        
        // Rock wins against Scissors
        if (playerChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) {
            return "Player";
        }
        
        // Paper wins against Rock
        if (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock")) {
            return "Player";
        }
        
        // Scissors wins against Paper
        if (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper")) {
            return "Player";
        }
        
        return "Computer";
    }
    
    // Method to calculate win percentage
    public static String[][] calculateWinPercentage(int playerWins, int computerWins, int totalGames) {
        String[][] stats = new String[3][2];
        
        stats[0][0] = "Player Wins";
        stats[0][1] = String.valueOf(playerWins);
        
        stats[1][0] = "Computer Wins";
        stats[1][1] = String.valueOf(computerWins);
        
        double playerPercentage = (totalGames > 0) ? (playerWins * 100.0) / totalGames : 0;
        double computerPercentage = (totalGames > 0) ? (computerWins * 100.0) / totalGames : 0;
        
        stats[2][0] = "Win Percentage";
        stats[2][1] = "Player: " + String.format("%.2f", playerPercentage) + "% | Computer: " + String.format("%.2f", computerPercentage) + "%";
        
        return stats;
    }
    
    // Method to display game results
    public static void displayGameResults(String[] playerChoices, String[] computerChoices, 
                                         String[] winners, String[][] stats) {
        System.out.println("\n--- Game Results ---");
        System.out.println("Game\tPlayer\t\tComputer\tWinner");
        System.out.println("----\t------\t\t--------\t------");
        
        for (int i = 0; i < playerChoices.length; i++) {
            System.out.println((i + 1) + "\t" + playerChoices[i] + "\t\t" + computerChoices[i] + "\t\t" + winners[i]);
        }
        
        System.out.println("\n--- Game Statistics ---");
        System.out.println(stats[0][0] + ": " + stats[0][1]);
        System.out.println(stats[1][0] + ": " + stats[1][1]);
        System.out.println(stats[2][0] + ": " + stats[2][1]);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of games to play: ");
        int numberOfGames = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        String[] playerChoices = new String[numberOfGames];
        String[] computerChoices = new String[numberOfGames];
        String[] winners = new String[numberOfGames];
        
        int playerWins = 0;
        int computerWins = 0;
        
        for (int i = 0; i < numberOfGames; i++) {
            System.out.println("\n--- Game " + (i + 1) + " ---");
            System.out.print("Enter your choice (Rock/Paper/Scissors): ");
            String playerChoice = scanner.nextLine();
            
            String computerChoice = getComputerChoice();
            String winner = determineWinner(playerChoice, computerChoice);
            
            playerChoices[i] = playerChoice;
            computerChoices[i] = computerChoice;
            winners[i] = winner;
            
            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }
            
            System.out.println("Computer chose: " + computerChoice);
            System.out.println("Result: " + winner);
        }
        
        // Calculate statistics
        String[][] stats = calculateWinPercentage(playerWins, computerWins, numberOfGames);
        
        // Display results
        displayGameResults(playerChoices, computerChoices, winners, stats);
        
        scanner.close();
    }
}
