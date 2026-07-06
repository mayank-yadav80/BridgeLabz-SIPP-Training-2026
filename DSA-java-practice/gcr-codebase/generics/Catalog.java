import java.util.*;

/**
 * Generic Catalog for managing products of different categories
 * Demonstrates handling multiple product types safely
 */
public class Catalog<T extends ProductCategory> {
    private String catalogName;
    private List<Product<T>> products;

    public Catalog(String catalogName) {
        this.catalogName = catalogName;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product<T> product) {
        products.add(product);
        System.out.println("✓ Added to catalog: " + product.getProductName());
    }

    public void addProducts(List<Product<T>> productList) {
        products.addAll(productList);
    }

    public Product<T> findProduct(String productId) {
        return products.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    public List<Product<T>> getProductsByPriceRange(double minPrice, double maxPrice) {
        return products.stream()
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .toList();
    }

    public void displayCatalog() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("CATALOG: " + catalogName + " | Total Products: " + products.size());
        System.out.println("=".repeat(100));
        
        if (products.isEmpty()) {
            System.out.println("Catalog is empty!");
            return;
        }

        for (Product<T> product : products) {
            System.out.println("• " + product);
        }
        System.out.println("=".repeat(100));
    }

    public double getTotalInventoryValue() {
        return products.stream()
                .mapToDouble(p -> p.getPrice() * p.getStock())
                .sum();
    }

    public int getTotalProductCount() {
        return products.size();
    }
}
