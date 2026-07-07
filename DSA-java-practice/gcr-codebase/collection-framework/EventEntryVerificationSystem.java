import java.util.*;

public class EventEntryVerificationSystem {
    private HashSet<String> registeredEmails;

    public EventEntryVerificationSystem() {
        registeredEmails = new HashSet<>();
    }

    public boolean registerParticipant(String email) {
        if (registeredEmails.contains(email)) {
            System.out.println("Duplicate registration rejected: " + email);
            return false;
        }
        registeredEmails.add(email);
        System.out.println("Participant registered: " + email);
        System.out.println("Total registered: " + registeredEmails.size());
        return true;
    }

    public void displayParticipants() {
        if (registeredEmails.isEmpty()) {
            System.out.println("No participants registered.");
            return;
        }
        System.out.println("Registered Participants (" + registeredEmails.size() + "):");
        int i = 1;
        for (String email : registeredEmails) {
            System.out.println(i++ + ". " + email);
        }
    }

    public void showTotal() {
        System.out.println("Total unique attendees eligible: " + registeredEmails.size());
    }

    public static void main(String[] args) {
        EventEntryVerificationSystem event = new EventEntryVerificationSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Event Entry Verification ---");
            System.out.println("1. Register Participant");
            System.out.println("2. Display All Participants");
            System.out.println("3. Show Total Attendees");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1 -> { System.out.print("Email: "); event.registerParticipant(sc.nextLine()); }
                case 2 -> event.displayParticipants();
                case 3 -> event.showTotal();
                case 4 -> { System.out.println("Bye."); return; }
                default -> System.out.println("Invalid.");
            }
        }
    }
}
