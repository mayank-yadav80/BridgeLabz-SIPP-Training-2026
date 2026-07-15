public class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    public static void main(String[] args) {
        String[] passengerNames = {"Riya Patel", "Samir Gupta", "Nina Bose"};
        String[] passportNumbers = {"A1234567", "INVALID1", "B8901234"};
        String[] luggageDescriptions = {"1 suitcase", "2 bags, liquids", "1 backpack"};

        AirportSecuritySystem system = new AirportSecuritySystem();
        system.showBoardingStatus(passengerNames, passportNumbers, luggageDescriptions);
    }

    private void showBoardingStatus(String[] names, String[] passports, String[] luggage) {
        for (int i = 0; i < names.length; i++) {
            System.out.println("Passenger: " + names[i]);
            displaySecurityGuidelines();
            boolean passportValid = verifyPassport(passports[i]);
            boolean luggageClear = scanLuggage(luggage[i]);
            if (passportValid && luggageClear) {
                System.out.println("Status: Can board the flight.\n");
            } else {
                System.out.println("Status: Cannot board the flight.\n");
            }
        }
    }

    @Override
    public boolean scanLuggage(String luggageDetails) {
        return luggageDetails != null && !luggageDetails.toLowerCase().contains("prohibited") && !luggageDetails.toLowerCase().contains("explosive");
    }

    @Override
    public boolean verifyPassport(String passportNo) {
        return PassportVerifier.isPassportNumberValid(passportNo);
    }

    @Override
    public void displaySecurityGuidelines() {
        System.out.println("Airport Security Guidelines: Follow all scanner and passport verification rules.");
    }
}

interface LuggageScanner {
    boolean scanLuggage(String luggageDetails);

    default void displaySecurityGuidelines() {
        System.out.println("LuggageScanner: Keep liquids under 100ml and no prohibited items.");
    }
}

interface PassportVerifier {
    boolean verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("PassportVerifier: Passport must be valid and match passenger details.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.matches("[A-Z][0-9]{7}");
    }
}

