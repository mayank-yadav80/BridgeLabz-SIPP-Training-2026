public class VehicleRentalSystem {
    public static void main(String[] args) {
        Car car = new Car("V1001", "Car", 2500.0);
        Bike bike = new Bike("V1002", "Bike", 700.0);
        Truck truck = new Truck("V1003", "Truck", 5400.0, 1500.0);

        int rentalDays = 5;

        System.out.println("Vehicle Rental Report");
        System.out.println("---------------------");
        car.displayVehicleDetails();
        System.out.printf("Rental Cost for %d days: %.2f%n", rentalDays, car.calculateRentalCost(rentalDays));
        System.out.println();

        bike.displayVehicleDetails();
        System.out.printf("Rental Cost for %d days: %.2f%n", rentalDays, bike.calculateRentalCost(rentalDays));
        System.out.println();

        truck.displayVehicleDetails();
        System.out.printf("Rental Cost for %d days: %.2f%n", rentalDays, truck.calculateRentalCost(rentalDays));
    }
}

abstract class Vehicle {
    private String vehicleNumber;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + vehicleType);
    }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle {
    private double dailyRate;

    public Car(String vehicleNumber, String vehicleType, double dailyRate) {
        super(vehicleNumber, vehicleType);
        this.dailyRate = dailyRate;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Bike extends Vehicle {
    private double dailyRate;

    public Bike(String vehicleNumber, String vehicleType, double dailyRate) {
        super(vehicleNumber, vehicleType);
        this.dailyRate = dailyRate;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Truck extends Vehicle {
    private double dailyRate;
    private double loadingCharge;

    public Truck(String vehicleNumber, String vehicleType, double dailyRate, double loadingCharge) {
        super(vehicleNumber, vehicleType);
        this.dailyRate = dailyRate;
        this.loadingCharge = loadingCharge;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getLoadingCharge() {
        return loadingCharge;
    }

    public void setLoadingCharge(double loadingCharge) {
        this.loadingCharge = loadingCharge;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (days * dailyRate) + loadingCharge;
    }
}
