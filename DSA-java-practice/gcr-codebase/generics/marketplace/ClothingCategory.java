package marketplace;

/**
 * ClothingCategory - Implementation of ProductCategory
 * Defines price range and characteristics for clothing
 */
public class ClothingCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }

    @Override
    public double getMinPrice() {
        return 500;
    }

    @Override
    public double getMaxPrice() {
        return 50000;
    }

    @Override
    public String getDescription() {
        return "Apparel and accessories for men, women, and children";
    }
}
