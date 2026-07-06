import java.util.*;

/**
 * Generic Meal class with bounded type parameters
 * Demonstrates:
 * - Type Parameters: <T extends MealPlan>
 * - Validation and generation methods
 * - Type safety for meal planning
 */
public class Meal<T extends MealPlan> {
    private String mealId;
    private String mealName;
    private T mealPlan;
    private List<String> ingredients;
    private String instructions;
    private double preparationTime; // in minutes
    private int servings;

    public Meal(String mealId, String mealName, T mealPlan, int servings) {
        if (!mealPlan.isValid()) {
            throw new IllegalArgumentException("Invalid meal plan provided");
        }
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealPlan = mealPlan;
        this.ingredients = new ArrayList<>();
        this.servings = servings;
        this.preparationTime = 0;
    }

    public String getMealId() {
        return mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public void addIngredient(String ingredient) {
        if (isAllowedFood(ingredient)) {
            ingredients.add(ingredient);
            System.out.println("✓ Added ingredient: " + ingredient);
        } else {
            throw new IllegalArgumentException(
                String.format("Ingredient '%s' not allowed in %s meal plan", ingredient, mealPlan.getMealType())
            );
        }
    }

    public void addIngredients(List<String> ingredientList) {
        for (String ingredient : ingredientList) {
            addIngredient(ingredient);
        }
    }

    /**
     * Validate if food is allowed in this meal plan
     */
    private boolean isAllowedFood(String food) {
        String[] allowed = mealPlan.getAllowedFoods();
        for (String allowedFood : allowed) {
            if (food.toLowerCase().contains(allowedFood.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if ingredient is restricted
     */
    public boolean isRestricted(String food) {
        String[] restricted = mealPlan.getRestrictedFoods();
        for (String restrictedFood : restricted) {
            if (food.toLowerCase().contains(restrictedFood.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setPreparationTime(double minutes) {
        this.preparationTime = minutes;
    }

    public double getPreparationTime() {
        return preparationTime;
    }

    public int getServings() {
        return servings;
    }

    public double getTotalCalories() {
        return mealPlan.getCaloriesPerServing() * servings;
    }

    /**
     * Generic method to validate and generate meal plan
     */
    public <M extends Meal<T>> void validateMealPlan(M meal) {
        System.out.println("\n--- Validating Meal Plan ---");
        System.out.println("Meal: " + meal.mealName);
        System.out.println("Type: " + meal.mealPlan.getMealType());
        System.out.println("Ingredients: " + meal.ingredients.size());
        
        boolean isValid = true;
        for (String ingredient : meal.ingredients) {
            if (meal.isRestricted(ingredient)) {
                System.out.println("✗ Restricted ingredient found: " + ingredient);
                isValid = false;
            }
        }
        
        if (isValid && !meal.ingredients.isEmpty()) {
            System.out.println("✓ Meal plan is valid and ready to prepare!");
        }
    }

    @Override
    public String toString() {
        return String.format(
            "Meal{ID='%s', Name='%s', Type='%s', Servings=%d, Calories=%.0f, PrepTime=%.1f min, Ingredients=%d}",
            mealId, mealName, mealPlan.getMealType(), servings, getTotalCalories(), preparationTime, ingredients.size()
        );
    }
}
