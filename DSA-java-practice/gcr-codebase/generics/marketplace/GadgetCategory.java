package marketplace;

/**
 * GadgetCategory - Implementation of ProductCategory
 * Defines price range and characteristics for gadgets
 */
public class GadgetCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }

    @Override
    public double getMinPrice() {
        return 2000;
    }

    @Override
    public double getMaxPrice() {
        return 200000;
    }

    @Override
    public String getDescription() {
        return "Electronic gadgets and accessories";
    }
}
