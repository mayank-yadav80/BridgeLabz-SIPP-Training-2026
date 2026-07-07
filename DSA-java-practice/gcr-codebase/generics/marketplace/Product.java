package marketplace;

/**
 * Generic Product class with bounded type parameters
 * Demonstrates:
 * - Type Parameters: <T extends ProductCategory>
 * - Generic Methods for applying discounts
 * - Type safety while supporting multiple product categories
 */
public class Product<T extends ProductCategory> {
    private String productId;
    private String productName;
    private double price;
    private int stock;
    private T category;
    private double discount; // discount percentage

    public Product(String productId, String productName, double price, int stock, T category) {
        if (price < category.getMinPrice() || price > category.getMaxPrice()) {
            throw new IllegalArgumentException(
                String.format("Price %.2f is outside the valid range [%.2f - %.2f] for %s",
                    price, category.getMinPrice(), category.getMaxPrice(), 
                    category.getCategoryName())
            );
        }
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.discount = 0;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double getFinalPrice() {
        return price * (1 - discount / 100);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public T getCategory() {
        return category;
    }

    public double getDiscount() {
        return discount;
    }

    /**
     * Generic method to apply discount - demonstrates type parameter usage
     * Ensures discount is applied safely with bounds checking
     */
    public <P extends Product<T>> void applyDiscount(P product, double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        product.discount = percentage;
        System.out.println(String.format("✓ Applied %.2f%% discount to %s", percentage, product.productName));
    }

    /**
     * Apply bulk discount based on quantity ordered
     * Demonstrates composition of generic methods
     */
    public void applyBulkDiscount(int quantityOrdered) {
        if (quantityOrdered >= 10) {
            discount = 15; // 15% for bulk orders
        } else if (quantityOrdered >= 5) {
            discount = 10; // 10% for medium orders
        } else {
            discount = 0; // no discount for small orders
        }
    }

    /**
     * Calculate total cost with discount
     */
    public double calculateTotalCost(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Insufficient stock. Available: " + stock);
        }
        return quantity * getFinalPrice();
    }

    @Override
    public String toString() {
        return String.format(
            "Product{ID='%s', Name='%s', Category='%s', Price=₹%.2f, FinalPrice=₹%.2f, Discount=%.2f%%, Stock=%d}",
            productId, productName, category.getCategoryName(), price, getFinalPrice(), discount, stock
        );
    }
}
