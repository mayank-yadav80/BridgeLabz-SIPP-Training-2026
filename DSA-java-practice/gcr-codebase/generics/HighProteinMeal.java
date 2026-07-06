/**
 * HighProteinMeal - Implementation of MealPlan
 * High protein for muscle building and recovery
 */
public class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public String[] getAllowedFoods() {
        return new String[]{
            "Chicken", "Fish", "Lean Beef", "Eggs", "Cottage Cheese", "Greek Yogurt", "Lentils", "Beans", "Tofu", "Nuts", "Whole Grains"
        };
    }

    @Override
    public String[] getRestrictedFoods() {
        return new String[]{
            "Processed foods", "Sugary snacks", "Deep-fried items", "Alcohol"
        };
    }

    @Override
    public double getCaloriesPerServing() {
        return 550;
    }

    @Override
    public String getHealthBenefit() {
        return "Muscle development, faster recovery, increased metabolism, prolonged satiety, better body composition";
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String toString() {
        return "HighProteinMeal{type='" + getMealType() + "', calories=" + getCaloriesPerServing() + "}";
    }
}
