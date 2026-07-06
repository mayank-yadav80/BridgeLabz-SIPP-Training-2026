/**
 * Abstract base class for all warehouse items
 * Demonstrates bounded type parameters and inheritance hierarchies
 */
public abstract class WarehouseItem {
    private String itemId;
    private String name;
    private double price;
    private int quantity;

    public WarehouseItem(String itemId, String name, double price, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract String getCategory();

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Price: %.2f, Quantity: %d, Category: %s",
                itemId, name, price, quantity, getCategory());
    }
}
