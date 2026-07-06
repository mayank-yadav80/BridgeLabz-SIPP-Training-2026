/**
 * VeganMeal - Implementation of MealPlan
 * No animal products whatsoever (no meat, dairy, eggs, or honey)
 */
public class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public String[] getAllowedFoods() {
        return new String[]{
            "Vegetables", "Fruits", "Grains", "Legumes", "Nuts", "Seeds", "Plant-based milk", "Tofu", "Tempeh"
        };
    }

    @Override
    public String[] getRestrictedFoods() {
        return new String[]{
            "Meat", "Poultry", "Fish", "Seafood", "Dairy", "Eggs", "Honey"
        };
    }

    @Override
    public double getCaloriesPerServing() {
        return 480;
    }

    @Override
    public String getHealthBenefit() {
        return "Ethical living, lower environmental impact, reduced risk of chronic diseases, lower saturated fat intake";
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String toString() {
        return "VeganMeal{type='" + getMealType() + "', calories=" + getCaloriesPerServing() + "}";
    }
}
