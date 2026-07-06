/**
 * Groceries item class extending WarehouseItem
 * Represents food/grocery items with expiration and storage type information
 */
public class Groceries extends WarehouseItem {
    private String expirationDate;
    private String storageType; // e.g., "Refrigerated", "Freezer", "Shelf"

    public Groceries(String itemId, String name, double price, int quantity, String expirationDate, String storageType) {
        super(itemId, name, price, quantity);
        this.expirationDate = expirationDate;
        this.storageType = storageType;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getStorageType() {
        return storageType;
    }

    @Override
    public String getCategory() {
        return "Groceries";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Expiration: %s, Storage: %s", expirationDate, storageType);
    }
}
