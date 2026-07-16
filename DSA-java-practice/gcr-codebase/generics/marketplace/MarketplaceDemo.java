package marketplace;

/**
 * Dynamic Online Marketplace - Demo
 * Demonstrates Generic Methods and Bounded Type Parameters
 */
public class MarketplaceDemo {
    public static void main(String[] args) {
        System.out.println("\n" + "█".repeat(100));
        System.out.println("DYNAMIC ONLINE MARKETPLACE - GENERIC PRODUCT CATALOG");
        System.out.println("█".repeat(100));

        // Create catalogs for different categories
        Catalog<BookCategory> bookCatalog = new Catalog<>("Books Store");
        Catalog<ClothingCategory> clothingCatalog = new Catalog<>("Fashion Boutique");
        Catalog<GadgetCategory> gadgetCatalog = new Catalog<>("Tech World");

        // Add books
        System.out.println("\n--- Adding Books to Catalog ---");
        Product<BookCategory> book1 = new Product<>("B001", "Java Programming", 1500, 50, new BookCategory());
        Product<BookCategory> book2 = new Product<>("B002", "Data Structures", 1200, 30, new BookCategory());
        Product<BookCategory> book3 = new Product<>("B003", "Advanced Algorithms", 2000, 20, new BookCategory());

        bookCatalog.addProduct(book1);
        bookCatalog.addProduct(book2);
        bookCatalog.addProduct(book3);

        // Add clothing items
        System.out.println("\n--- Adding Clothing to Catalog ---");
        Product<ClothingCategory> clothing1 = new Product<>("C001", "Casual T-Shirt", 500, 100, new ClothingCategory());
        Product<ClothingCategory> clothing2 = new Product<>("C002", "Denim Jeans", 2000, 75, new ClothingCategory());
        Product<ClothingCategory> clothing3 = new Product<>("C003", "Formal Shirt", 1500, 60, new ClothingCategory());

        clothingCatalog.addProduct(clothing1);
        clothingCatalog.addProduct(clothing2);
        clothingCatalog.addProduct(clothing3);

        // Add gadgets
        System.out.println("\n--- Adding Gadgets to Catalog ---");
        Product<GadgetCategory> gadget1 = new Product<>("G001", "Wireless Earbuds", 5000, 40, new GadgetCategory());
        Product<GadgetCategory> gadget2 = new Product<>("G002", "Smart Watch", 15000, 25, new GadgetCategory());
        Product<GadgetCategory> gadget3 = new Product<>("G003", "Portable Charger", 3000, 80, new GadgetCategory());

        gadgetCatalog.addProduct(gadget1);
        gadgetCatalog.addProduct(gadget2);
        gadgetCatalog.addProduct(gadget3);

        // Display catalogs
        bookCatalog.displayCatalog();
        clothingCatalog.displayCatalog();
        gadgetCatalog.displayCatalog();

        // Apply discounts using generic methods
        System.out.println("\n--- Applying Discounts (Using Generic Methods) ---");
        
        Product<BookCategory> discountedBook = book1;
        discountedBook.applyDiscount(discountedBook, 10);
        
        Product<ClothingCategory> discountedClothing = clothing2;
        discountedClothing.applyDiscount(discountedClothing, 15);
        
        Product<GadgetCategory> discountedGadget = gadget1;
        discountedGadget.applyDiscount(discountedGadget, 20);

        // Apply bulk discounts
        System.out.println("\n--- Applying Bulk Discounts ---");
        book2.applyBulkDiscount(12);
        System.out.println("✓ Applied bulk discount to " + book2.getProductName());
        
        clothing3.applyBulkDiscount(8);
        System.out.println("✓ Applied bulk discount to " + clothing3.getProductName());

        // Display updated catalogs
        System.out.println("\n--- Catalogs After Discounts ---");
        bookCatalog.displayCatalog();
        clothingCatalog.displayCatalog();
        gadgetCatalog.displayCatalog();

        // Calculate order totals
        System.out.println("\n--- Order Calculations ---");
        System.out.println(String.format("Book order (5 units of '%s'): ₹%.2f", 
            book1.getProductName(), book1.calculateTotalCost(5)));
        
        System.out.println(String.format("Clothing order (3 units of '%s'): ₹%.2f", 
            clothing2.getProductName(), clothing2.calculateTotalCost(3)));
        
        System.out.println(String.format("Gadget order (2 units of '%s'): ₹%.2f", 
            gadget1.getProductName(), gadget1.calculateTotalCost(2)));

        // Display inventory statistics
        System.out.println("\n--- Inventory Statistics ---");
        System.out.println(String.format("Books Catalog - Total Value: ₹%.2f, Total Products: %d",
            bookCatalog.getTotalInventoryValue(), bookCatalog.getTotalProductCount()));
        
        System.out.println(String.format("Clothing Catalog - Total Value: ₹%.2f, Total Products: %d",
            clothingCatalog.getTotalInventoryValue(), clothingCatalog.getTotalProductCount()));
        
        System.out.println(String.format("Gadgets Catalog - Total Value: ₹%.2f, Total Products: %d",
            gadgetCatalog.getTotalInventoryValue(), gadgetCatalog.getTotalProductCount()));

        System.out.println("\n" + "█".repeat(100));
        System.out.println("Generics Benefits Demonstrated:");
        System.out.println("✓ Type Parameters: <T extends ProductCategory>");
        System.out.println("✓ Generic Methods: applyDiscount method");
        System.out.println("✓ Bounded Type Parameters: Ensures only valid categories");
        System.out.println("✓ Type Safety: No ClassCastException");
        System.out.println("█".repeat(100) + "\n");
    }
}
