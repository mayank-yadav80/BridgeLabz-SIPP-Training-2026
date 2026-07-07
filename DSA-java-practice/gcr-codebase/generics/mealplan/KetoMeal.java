package mealplan;

/**
 * KetoMeal - Implementation of MealPlan
 * High fat, moderate protein, very low carbohydrates
 */
public class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public String[] getAllowedFoods() {
        return new String[]{
            "Meat", "Fish", "Eggs", "Cheese", "Butter", "Nuts", "Seeds", "Avocado", "Olive Oil", "Low-carb Vegetables"
        };
    }

    @Override
    public String[] getRestrictedFoods() {
        return new String[]{
            "Bread", "Pasta", "Rice", "Sugar", "Fruits (except berries)", "Grains", "Legumes", "Milk"
        };
    }

    @Override
    public double getCaloriesPerServing() {
        return 650;
    }

    @Override
    public String getHealthBenefit() {
        return "Rapid weight loss, improved mental clarity, better blood sugar control, sustained energy levels";
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String toString() {
        return "KetoMeal{type='" + getMealType() + "', calories=" + getCaloriesPerServing() + "}";
    }
}
