public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle electric = new ElectricVehicle("Tesla Model 3", 225);
        PetrolVehicle petrol = new PetrolVehicle("Honda Civic", 180);

        electric.displayDetails();
        electric.charge();
        System.out.println();

        petrol.displayDetails();
        petrol.refuel();
    }
}

class Vehicle {
    private String model;
    private int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void displayDetails() {
        System.out.println("Vehicle Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void charge() {
        System.out.println(getModel() + " is charging its battery.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    @Override
    public void refuel() {
        System.out.println(getModel() + " is refueling with petrol.");
    }
}
