package warehouse;

/**
 * Smart Warehouse Management System - Demo
 * Showcases the use of Generics with Type Safety
 */
public class SmartWarehouseDemo {
    public static void main(String[] args) {
        System.out.println("\n" + "█".repeat(80));
        System.out.println("SMART WAREHOUSE MANAGEMENT SYSTEM");
        System.out.println("█".repeat(80));

        // Create separate storage units for different item types
        Storage<Electronics> electronicsStorage = new Storage<>(5);
        Storage<Groceries> groceriesStorage = new Storage<>(10);
        Storage<Furniture> furnitureStorage = new Storage<>(8);

        // Add electronics
        System.out.println("\n--- Adding Electronics ---");
        electronicsStorage.addItem(new Electronics("E001", "Laptop", 50000, 3, "Dell", 24));
        electronicsStorage.addItem(new Electronics("E002", "Mobile Phone", 20000, 5, "Samsung", 12));
        electronicsStorage.addItem(new Electronics("E003", "Headphones", 5000, 10, "Sony", 12));

        // Add groceries
        System.out.println("\n--- Adding Groceries ---");
        groceriesStorage.addItem(new Groceries("G001", "Rice", 500, 100, "2025-12-31", "Shelf"));
        groceriesStorage.addItem(new Groceries("G002", "Milk", 80, 50, "2025-01-15", "Refrigerated"));
        groceriesStorage.addItem(new Groceries("G003", "Ice Cream", 200, 30, "2025-06-30", "Freezer"));

        // Add furniture
        System.out.println("\n--- Adding Furniture ---");
        furnitureStorage.addItem(new Furniture("F001", "Office Chair", 5000, 2, "Leather", true));
        furnitureStorage.addItem(new Furniture("F002", "Study Desk", 8000, 3, "Wood", true));
        furnitureStorage.addItem(new Furniture("F003", "Bookshelf", 4000, 4, "Metal", false));

        // Display all items
        electronicsStorage.displayAllItems();
        groceriesStorage.displayAllItems();
        furnitureStorage.displayAllItems();

        // Display inventory statistics
        System.out.println("\n--- Inventory Statistics ---");
        System.out.println(String.format("Electronics - Total Value: ₹%.2f, Total Units: %d, Capacity: %d/%d",
                electronicsStorage.getTotalInventoryValue(),
                electronicsStorage.getTotalQuantity(),
                electronicsStorage.getItemCount(),
                electronicsStorage.getCapacity()));
        
        System.out.println(String.format("Groceries - Total Value: ₹%.2f, Total Units: %d, Capacity: %d/%d",
                groceriesStorage.getTotalInventoryValue(),
                groceriesStorage.getTotalQuantity(),
                groceriesStorage.getItemCount(),
                groceriesStorage.getCapacity()));
        
        System.out.println(String.format("Furniture - Total Value: ₹%.2f, Total Units: %d, Capacity: %d/%d",
                furnitureStorage.getTotalInventoryValue(),
                furnitureStorage.getTotalQuantity(),
                furnitureStorage.getItemCount(),
                furnitureStorage.getCapacity()));

        // Update quantity
        System.out.println("\n--- Updating Quantities ---");
        electronicsStorage.updateQuantity("E001", 5);
        groceriesStorage.updateQuantity("G002", 75);

        // Remove item
        System.out.println("\n--- Removing Items ---");
        furnitureStorage.removeItemById("F003");

        // Final display
        System.out.println("\n--- Final Inventory Status ---");
        electronicsStorage.displayAllItems();
        groceriesStorage.displayAllItems();
        furnitureStorage.displayAllItems();

        System.out.println("\n" + "█".repeat(80));
        System.out.println("Generics Benefits Demonstrated:");
        System.out.println("✓ Type Safety: No ClassCastException");
        System.out.println("✓ Compile-time Type Checking");
        System.out.println("✓ Bounded Type Parameters: <T extends WarehouseItem>");
        System.out.println("✓ Upper Bounded Wildcards: List<? extends WarehouseItem>");
        System.out.println("█".repeat(80) + "\n");
    }
}
