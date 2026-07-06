import java.util.*;

/**
 * Personalized Meal Plan Generator
 * Demonstrates use of wildcards and generic methods
 */
public class MealPlanGenerator {
    private List<Meal<? extends MealPlan>> mealPlans; // Wildcard for any MealPlan type
    private String userName;

    public MealPlanGenerator(String userName) {
        this.userName = userName;
        this.mealPlans = new ArrayList<>();
    }

    /**
     * Add a meal of any type using generic method
     */
    public <T extends MealPlan> void addMeal(Meal<T> meal) {
        mealPlans.add(meal);
        System.out.println("✓ Added meal: " + meal.getMealName());
    }

    /**
     * Add multiple meals using wildcard
     */
    public void addMeals(List<? extends Meal<?>> meals) {
        for (Meal<?> meal : meals) {
            mealPlans.add((Meal<? extends MealPlan>) meal);
        }
    }

    /**
     * Display all meal plans using wildcard
     */
    public void displayMealPlans() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("PERSONALIZED MEAL PLAN FOR: " + userName + " | Total Meals: " + mealPlans.size());
        System.out.println("=".repeat(100));

        if (mealPlans.isEmpty()) {
            System.out.println("No meal plans created yet!");
            return;
        }

        for (Meal<? extends MealPlan> meal : mealPlans) {
            System.out.println("• " + meal);
        }
        System.out.println("=".repeat(100));
    }

    /**
     * Display meals by type using wildcard
     */
    public void displayMealsByType(String mealType) {
        System.out.println("\n" + "─".repeat(100));
        System.out.println("Meals of Type: " + mealType);
        System.out.println("─".repeat(100));

        boolean found = false;
        for (Meal<? extends MealPlan> meal : mealPlans) {
            if (meal.getMealPlan().getMealType().equals(mealType)) {
                System.out.println("• " + meal);
                System.out.println("  Benefit: " + meal.getMealPlan().getHealthBenefit());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No meals found for type: " + mealType);
        }
    }

    /**
     * Calculate total daily calories
     */
    public double calculateTotalDailyCalories() {
        return mealPlans.stream()
                .mapToDouble(Meal::getTotalCalories)
                .sum();
    }

    /**
     * Calculate average preparation time
     */
    public double getAveragePreparationTime() {
        if (mealPlans.isEmpty()) return 0;
        return mealPlans.stream()
                .mapToDouble(Meal::getPreparationTime)
                .average()
                .orElse(0);
    }

    /**
     * Get nutrition summary
     */
    public void displayNutritionSummary() {
        System.out.println("\n" + "─".repeat(100));
        System.out.println("Nutrition Summary for " + userName);
        System.out.println("─".repeat(100));
        System.out.println("Total Meals: " + mealPlans.size());
        System.out.println("Total Daily Calories: " + String.format("%.0f", calculateTotalDailyCalories()));
        System.out.println("Average Preparation Time: " + String.format("%.1f minutes", getAveragePreparationTime()));
        System.out.println("─".repeat(100));
    }

    public int getMealCount() {
        return mealPlans.size();
    }

    public String getUserName() {
        return userName;
    }
}
