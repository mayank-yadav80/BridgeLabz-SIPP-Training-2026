public class FoodDeliverySystem {
    public static void main(String[] args) {
        VegItem vegItem = new VegItem("Paneer Tikka", 240.0, 2);
        NonVegItem nonVegItem = new NonVegItem("Chicken Biryani", 320.0, 1, 50.0);

        System.out.println("Food Delivery Order Report");
        System.out.println("--------------------------");
        vegItem.displayItemDetails();
        System.out.printf("Total Price: %.2f%n%n", vegItem.calculateTotalPrice());

        nonVegItem.displayItemDetails();
        System.out.printf("Total Price: %.2f%n", nonVegItem.calculateTotalPrice());
    }
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Unit: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {
    private double serviceCharge;

    public NonVegItem(String itemName, double price, int quantity, double serviceCharge) {
        super(itemName, price, quantity);
        this.serviceCharge = serviceCharge;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + serviceCharge;
    }
}
