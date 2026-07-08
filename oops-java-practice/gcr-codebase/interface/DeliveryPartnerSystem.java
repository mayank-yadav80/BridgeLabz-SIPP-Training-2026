public class DeliveryPartnerSystem {
    public static void main(String[] args) {
        String[] customers = {"Vikram", "Meera", "Riya"};
        DeliveryExecutive executive = new DeliveryExecutive("Arjun");

        for (String customer : customers) {
            executive.trackOrder(customer);
            executive.deliverFood(customer);
            executive.deliverGrocery(customer);
            System.out.println();
        }
    }
}

interface FoodDelivery {
    void deliverFood(String customerName);

    default void trackOrder(String customerName) {
        System.out.println("FoodDelivery: Tracking food order for " + customerName);
    }
}

interface GroceryDelivery {
    void deliverGrocery(String customerName);

    default void trackOrder(String customerName) {
        System.out.println("GroceryDelivery: Tracking grocery order for " + customerName);
    }

    static String generateDeliveryCode() {
        return "DLV-" + System.currentTimeMillis();
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
    private String name;

    public DeliveryExecutive(String name) {
        this.name = name;
    }

    @Override
    public void deliverFood(String customerName) {
        System.out.println(name + " delivered food to " + customerName + ". Code: " + GroceryDelivery.generateDeliveryCode());
    }

    @Override
    public void deliverGrocery(String customerName) {
        System.out.println(name + " delivered groceries to " + customerName + ". Code: " + GroceryDelivery.generateDeliveryCode());
    }

    @Override
    public void trackOrder(String customerName) {
        System.out.println("Combined tracking for " + customerName + ": food and grocery orders are on the way.");
    }
}
