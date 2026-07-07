public class FleetManagementSystem {
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Car("CAR-001", "Sedan", 90),
            new Bus("BUS-101", "City Bus", 220),
            new Bike("BIKE-12", "Sport Bike", 75),
            new ElectricCar("EVC-501", "Electric Sedan", 70)
        };

        double distance = 120.0;
        for (Vehicle vehicle : fleet) {
            if (vehicle instanceof ElectricCar) {
                ElectricCar electricCar = (ElectricCar) vehicle;
                System.out.println("ElectricCar " + electricCar.getVehicleNumber() + " cost: " + electricCar.fuelCost(distance));
            } else if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                System.out.println("Car " + car.getVehicleNumber() + " cost: " + car.fuelCost(distance));
            } else if (vehicle instanceof Bus) {
                Bus bus = (Bus) vehicle;
                System.out.println("Bus " + bus.getVehicleNumber() + " cost: " + bus.fuelCost(distance));
            } else if (vehicle instanceof Bike) {
                Bike bike = (Bike) vehicle;
                System.out.println("Bike " + bike.getVehicleNumber() + " cost: " + bike.fuelCost(distance));
            }
        }
    }
}

abstract class Vehicle {
    private String vehicleNumber;
    private String model;

    public Vehicle(String vehicleNumber, String model) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public abstract double fuelCost(double kilometers);
}

class Car extends Vehicle {
    private double pricePerLiter = 110.0;
    private double efficiencyKmPerLiter = 15.0;

    public Car(String vehicleNumber, String model, double pricePerLiter) {
        super(vehicleNumber, model);
        this.pricePerLiter = pricePerLiter;
    }

    @Override
    public double fuelCost(double kilometers) {
        return (kilometers / efficiencyKmPerLiter) * pricePerLiter;
    }
}

class Bus extends Vehicle {
    private double pricePerLiter = 120.0;
    private double efficiencyKmPerLiter = 5.0;

    public Bus(String vehicleNumber, String model, double pricePerLiter) {
        super(vehicleNumber, model);
        this.pricePerLiter = pricePerLiter;
    }

    @Override
    public double fuelCost(double kilometers) {
        return (kilometers / efficiencyKmPerLiter) * pricePerLiter;
    }
}

class Bike extends Vehicle {
    private double pricePerLiter = 90.0;
    private double efficiencyKmPerLiter = 40.0;

    public Bike(String vehicleNumber, String model, double pricePerLiter) {
        super(vehicleNumber, model);
        this.pricePerLiter = pricePerLiter;
    }

    @Override
    public double fuelCost(double kilometers) {
        return (kilometers / efficiencyKmPerLiter) * pricePerLiter;
    }
}

class ElectricCar extends Car {
    private double chargingCostPerKm = 0.8;

    public ElectricCar(String vehicleNumber, String model, double chargingCostPerKm) {
        super(vehicleNumber, model, 0);
        this.chargingCostPerKm = chargingCostPerKm;
    }

    @Override
    public double fuelCost(double kilometers) {
        return kilometers * chargingCostPerKm;
    }
}
