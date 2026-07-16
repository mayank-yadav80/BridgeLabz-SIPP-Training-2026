package mealplan;

/**
 * VegetarianMeal - Implementation of MealPlan
 * No meat, but includes dairy and eggs
 */
public class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public String[] getAllowedFoods() {
        return new String[]{
            "Vegetables", "Fruits", "Grains", "Legumes", "Dairy", "Eggs", "Nuts", "Seeds", "Honey"
        };
    }

    @Override
    public String[] getRestrictedFoods() {
        return new String[]{
            "Meat", "Poultry", "Fish", "Seafood"
        };
    }

    @Override
    public double getCaloriesPerServing() {
        return 500;
    }

    @Override
    public String getHealthBenefit() {
        return "Lower cholesterol, reduced risk of heart disease, easier to maintain healthy weight";
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String toString() {
        return "VegetarianMeal{type='" + getMealType() + "', calories=" + getCaloriesPerServing() + "}";
    }
}
