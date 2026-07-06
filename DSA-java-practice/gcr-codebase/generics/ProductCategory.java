/**
 * ProductCategory interface for marketplace categories
 * Defines common properties for all product categories
 */
public interface ProductCategory {
    String getCategoryName();
    double getMinPrice();
    double getMaxPrice();
    String getDescription();
}
