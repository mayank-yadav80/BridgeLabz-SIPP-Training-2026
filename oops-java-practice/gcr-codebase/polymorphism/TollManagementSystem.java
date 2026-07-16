public class TollManagementSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new TollCar("CAR-101", "Amit Sharma"),
            new TollBus("BUS-201", "Raj Travels"),
            new TollTruck("TRK-301", "Cargo Inc.")
        };

        System.out.println("Total revenue: " + calculateTotalRevenue(vehicles));
        System.out.println("Vehicle with highest toll: " + findHighestTollVehicle(vehicles).getVehicleNumber());
        countVehiclesByType(vehicles);
        String searchNumber = "BUS-201";
        Vehicle found = searchVehicle(vehicles, searchNumber);
        System.out.println("Search " + searchNumber + ": " + (found != null ? found.getOwnerName() : "Not found"));
    }

    public static double calculateTotalRevenue(Vehicle[] vehicles) {
        double total = 0;
        for (Vehicle vehicle : vehicles) {
            total += vehicle.calculateToll();
        }
        return total;
    }

    public static Vehicle searchVehicle(Vehicle[] vehicles, String vehicleNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return vehicle;
            }
        }
        return null;
    }

    public static Vehicle findHighestTollVehicle(Vehicle[] vehicles) {
        Vehicle highest = vehicles[0];
        for (Vehicle vehicle : vehicles) {
            if (vehicle.calculateToll() > highest.calculateToll()) {
                highest = vehicle;
            }
        }
        return highest;
    }

    public static void countVehiclesByType(Vehicle[] vehicles) {
        int cars = 0, buses = 0, trucks = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof TollCar) cars++;
            if (vehicle instanceof TollBus) buses++;
            if (vehicle instanceof TollTruck) trucks++;
        }
        System.out.println("Cars: " + cars + ", Buses: " + buses + ", Trucks: " + trucks);
    }
}

abstract class Vehicle {
    private String vehicleNumber;
    private String ownerName;

    public Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public abstract double calculateToll();
}

class TollCar extends Vehicle {
    public TollCar(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 150.0;
    }
}

class TollBus extends Vehicle {
    public TollBus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 300.0;
    }
}

class TollTruck extends Vehicle {
    public TollTruck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 450.0;
    }
}
