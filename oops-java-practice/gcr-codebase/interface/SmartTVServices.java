public class SmartTVServices {
    public static void main(String[] args) {
        SmartTV tv = new SmartTV("MegaView 55");
        // tv.displaySubscriptionDetails();
        tv.displayAvailableContent();
    }
}

interface StreamingService {
    void streamMovie(String movieName);

    default void showSubscriptionDetails() {
        System.out.println("StreamingService subscription includes movies and series.");
    }
}

interface GamingService {
    void playGame(String gameName);

    default void showSubscriptionDetails() {
        System.out.println("GamingService subscription includes games and updates.");
    }
}

class SmartTV implements StreamingService, GamingService {
    private String model;
    private String[] movies = {"Space Adventure", "Mystery Island", "Comedy Nights"};
    private String[] games = {"Racing Pro", "Puzzle Quest", "Battle Arena"};

    public SmartTV(String model) {
        this.model = model;
    }

    @Override
    public void streamMovie(String movieName) {
        System.out.println("Streaming movie: " + movieName);
    }

    @Override
    public void playGame(String gameName) {
        System.out.println("Playing game: " + gameName);
    }

    @Override
    public void showSubscriptionDetails() {
        System.out.println("SmartTV " + model + " subscription includes streaming and gaming features.");
    }

    public void displayAvailableContent() {
        System.out.println("Available movies:");
        for (String movie : movies) {
            System.out.println("- " + movie);
        }
        System.out.println("Available games:");
        for (String game : games) {
            System.out.println("- " + game);
        }
    }
}
