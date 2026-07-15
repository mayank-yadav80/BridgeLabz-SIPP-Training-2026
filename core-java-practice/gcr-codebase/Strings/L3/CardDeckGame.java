import java.util.Scanner;

public class CardDeckGame {
    
    // Method to initialize the deck
    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }
        
        return deck;
    }
    
    // Method to shuffle the deck
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        String[] shuffledDeck = new String[n];
        
        // Copy original deck
        for (int i = 0; i < n; i++) {
            shuffledDeck[i] = deck[i];
        }
        
        // Shuffle using Fisher-Yates algorithm
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            
            // Swap
            String temp = shuffledDeck[i];
            shuffledDeck[i] = shuffledDeck[randomCardNumber];
            shuffledDeck[randomCardNumber] = temp;
        }
        
        return shuffledDeck;
    }
    
    // Method to distribute cards to players
    public static String[][] distributeCards(String[] deck, int numberOfPlayers, int cardsPerPlayer) {
        int totalCardsNeeded = numberOfPlayers * cardsPerPlayer;
        
        if (totalCardsNeeded > deck.length) {
            System.out.println("Error: Not enough cards to distribute!");
            return null;
        }
        
        String[][] players = new String[numberOfPlayers][cardsPerPlayer];
        int cardIndex = 0;
        
        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }
        
        return players;
    }
    
    // Method to print player cards
    public static void printPlayerCards(String[][] players) {
        System.out.println("\n--- Player Cards ---");
        
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + (j + 1) + ". " + players[i][j]);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Define suits and ranks
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
        // Initialize deck
        String[] deck = initializeDeck(suits, ranks);
        System.out.println("Total cards in deck: " + deck.length);
        
        // Shuffle deck
        String[] shuffledDeck = shuffleDeck(deck);
        
        System.out.print("Enter number of players: ");
        int numberOfPlayers = scanner.nextInt();
        
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = scanner.nextInt();
        
        // Distribute cards
        String[][] players = distributeCards(shuffledDeck, numberOfPlayers, cardsPerPlayer);
        
        if (players != null) {
            // Print player cards
            printPlayerCards(players);
        }
        
        scanner.close();
    }
}
