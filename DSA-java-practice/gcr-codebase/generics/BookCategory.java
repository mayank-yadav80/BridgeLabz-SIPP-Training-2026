/**
 * BookCategory - Implementation of ProductCategory
 * Defines price range and characteristics for books
 */
public class BookCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Books";
    }

    @Override
    public double getMinPrice() {
        return 100;
    }

    @Override
    public double getMaxPrice() {
        return 5000;
    }

    @Override
    public String getDescription() {
        return "Educational and entertainment books";
    }
}
