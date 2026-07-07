import java.util.*;

public class SmartParkingSlotManager {
    private ArrayList<String> parkedVehicles;
    private static final int MAX_SLOTS = 50;

    public SmartParkingSlotManager() {
        parkedVehicles = new ArrayList<>();
    }

    public boolean enterVehicle(String regNumber) {
        if (parkedVehicles.size() >= MAX_SLOTS) {
            System.out.println("Parking full!");
            return false;
        }
        if (parkedVehicles.contains(regNumber)) {
            System.out.println("Vehicle already parked.");
            return false;
        }
        parkedVehicles.add(regNumber);
        System.out.println("Vehicle " + regNumber + " entered. Slots used: " + parkedVehicles.size() + "/" + MAX_SLOTS);
        return true;
    }

    public boolean exitVehicle(String regNumber) {
        if (!parkedVehicles.remove(regNumber)) {
            System.out.println("Vehicle not found.");
            return false;
        }
        System.out.println("Vehicle " + regNumber + " exited. Slots used: " + parkedVehicles.size() + "/" + MAX_SLOTS);
        return true;
    }

    public boolean searchVehicle(String regNumber) {
        boolean found = parkedVehicles.contains(regNumber);
        System.out.println(found ? "Vehicle " + regNumber + " is parked." : "Vehicle " + regNumber + " not found.");
        return found;
    }

    public void displayAll() {
        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles parked.");
            return;
        }
        System.out.println("Parked Vehicles (" + parkedVehicles.size() + "/" + MAX_SLOTS + " slots occupied):");
        for (int i = 0; i < parkedVehicles.size(); i++) {
            System.out.println("Slot " + (i + 1) + ": " + parkedVehicles.get(i));
        }
    }

    public static void main(String[] args) {
        SmartParkingSlotManager parking = new SmartParkingSlotManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Smart Parking Slot Manager ---");
            System.out.println("1. Vehicle Entry");
            System.out.println("2. Vehicle Exit");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Display All");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1 -> { System.out.print("Reg Number: "); parking.enterVehicle(sc.nextLine()); }
                case 2 -> { System.out.print("Reg Number: "); parking.exitVehicle(sc.nextLine()); }
                case 3 -> { System.out.print("Reg Number: "); parking.searchVehicle(sc.nextLine()); }
                case 4 -> parking.displayAll();
                case 5 -> { System.out.println("Bye."); return; }
                default -> System.out.println("Invalid.");
            }
        }
    }
}
