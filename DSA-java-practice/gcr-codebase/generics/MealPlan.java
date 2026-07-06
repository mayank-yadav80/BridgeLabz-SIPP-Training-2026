/**
 * MealPlan interface for different meal plan types
 * Defines common properties for all meal plans
 */
public interface MealPlan {
    String getMealType();
    String[] getAllowedFoods();
    String[] getRestrictedFoods();
    double getCaloriesPerServing();
    String getHealthBenefit();
    boolean isValid();
}
