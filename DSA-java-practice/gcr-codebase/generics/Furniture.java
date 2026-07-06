/**
 * Furniture item class extending WarehouseItem
 * Represents furniture with material and assembly information
 */
public class Furniture extends WarehouseItem {
    private String material;
    private boolean requiresAssembly;

    public Furniture(String itemId, String name, double price, int quantity, String material, boolean requiresAssembly) {
        super(itemId, name, price, quantity);
        this.material = material;
        this.requiresAssembly = requiresAssembly;
    }

    public String getMaterial() {
        return material;
    }

    public boolean isRequiresAssembly() {
        return requiresAssembly;
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Material: %s, Assembly Required: %s", 
                material, requiresAssembly ? "Yes" : "No");
    }
}
