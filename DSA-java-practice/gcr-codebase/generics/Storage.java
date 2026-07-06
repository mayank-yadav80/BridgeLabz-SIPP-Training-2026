import java.util.*;

/**
 * Generic Storage class for managing warehouse items
 * Demonstrates:
 * - Bounded type parameters: <T extends WarehouseItem>
 * - Upper bounded wildcards for read-only operations: List<? extends WarehouseItem>
 * - Type safety preventing ClassCastException
 */
public class Storage<T extends WarehouseItem> {
    private List<T> items;
    private int capacity;

    public Storage(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    /**
     * Add an item to storage
     * Type-safe: only items of type T can be added
     */
    public void addItem(T item) {
        if (items.size() < capacity) {
            items.add(item);
            System.out.println("✓ Item added: " + item.getName());
        } else {
            System.out.println("✗ Storage is full! Cannot add: " + item.getName());
        }
    }

    /**
     * Add multiple items to storage
     */
    public void addItems(List<T> itemList) {
        for (T item : itemList) {
            addItem(item);
        }
    }

    /**
     * Retrieve an item by ID
     */
    public T getItemById(String itemId) {
        for (T item : items) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Remove an item by ID
     */
    public boolean removeItemById(String itemId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemId().equals(itemId)) {
                T removed = items.remove(i);
                System.out.println("✓ Item removed: " + removed.getName());
                return true;
            }
        }
        System.out.println("✗ Item not found with ID: " + itemId);
        return false;
    }

    /**
     * Update quantity of an item
     */
    public void updateQuantity(String itemId, int newQuantity) {
        T item = getItemById(itemId);
        if (item != null) {
            item.setQuantity(newQuantity);
            System.out.println("✓ Quantity updated for: " + item.getName());
        } else {
            System.out.println("✗ Item not found with ID: " + itemId);
        }
    }

    /**
     * Get all items in storage
     * Uses upper bounded wildcard for flexible read-only access
     */
    public List<? extends WarehouseItem> getAllItems() {
        return new ArrayList<>(items);
    }

    /**
     * Display all items in storage using wildcards
     * Demonstrates upper bounded wildcard (? extends WarehouseItem)
     */
    public void displayAllItems() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("Storage Contents - Total Items: " + items.size() + "/" + capacity);
        System.out.println("=".repeat(80));
        
        if (items.isEmpty()) {
            System.out.println("Storage is empty!");
            return;
        }

        for (WarehouseItem item : getAllItems()) {
            System.out.println("• " + item);
        }
        System.out.println("=".repeat(80));
    }

    /**
     * Get total value of inventory
     */
    public double getTotalInventoryValue() {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    /**
     * Get total number of items (quantity)
     */
    public int getTotalQuantity() {
        return items.stream()
                .mapToInt(WarehouseItem::getQuantity)
                .sum();
    }

    /**
     * Get count of items in storage
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Get storage capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Check if storage has space
     */
    public boolean hasSpace() {
        return items.size() < capacity;
    }
}
