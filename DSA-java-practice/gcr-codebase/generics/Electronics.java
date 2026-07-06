/**
 * Electronics item class extending WarehouseItem
 * Represents electronics with warranty and brand information
 */
public class Electronics extends WarehouseItem {
    private String brand;
    private int warrantyMonths;

    public Electronics(String itemId, String name, double price, int quantity, String brand, int warrantyMonths) {
        super(itemId, name, price, quantity);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    public String getBrand() {
        return brand;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Brand: %s, Warranty: %d months", brand, warrantyMonths);
    }
}
