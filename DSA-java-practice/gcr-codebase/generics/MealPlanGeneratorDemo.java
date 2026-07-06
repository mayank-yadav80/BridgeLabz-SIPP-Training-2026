/**
 * Personalized Meal Plan Generator - Demo
 * Demonstrates Generic Methods, Type Parameters, and Bounded Type Parameters
 */
public class MealPlanGeneratorDemo {
    public static void main(String[] args) {
        System.out.println("\n" + "█".repeat(100));
        System.out.println("PERSONALIZED MEAL PLAN GENERATOR");
        System.out.println("█".repeat(100));

        // Create meal plan generators for different users
        MealPlanGenerator vegetarianPlanner = new MealPlanGenerator("Vegetarian User - Priya");
        MealPlanGenerator veganPlanner = new MealPlanGenerator("Vegan User - Amit");
        MealPlanGenerator ketoPlanner = new MealPlanGenerator("Keto Enthusiast - Rajesh");
        MealPlanGenerator fitnessPlan = new MealPlanGenerator("Fitness Enthusiast - Sarah");

        // Create Vegetarian Meals
        System.out.println("\n--- Creating Vegetarian Meals ---");
        Meal<VegetarianMeal> vegMeal1 = new Meal<>("V001", "Vegetable Curry with Rice", new VegetarianMeal(), 1);
        vegMeal1.addIngredients(java.util.Arrays.asList("Vegetables", "Rice", "Dairy"));
        vegMeal1.setPreparationTime(30);
        vegMeal1.setInstructions("Cook vegetables and mix with rice");

        Meal<VegetarianMeal> vegMeal2 = new Meal<>("V002", "Paneer Tikka", new VegetarianMeal(), 2);
        vegMeal2.addIngredients(java.util.Arrays.asList("Dairy", "Vegetables", "Nuts"));
        vegMeal2.setPreparationTime(20);
        vegMeal2.setInstructions("Marinate and grill paneer with vegetables");

        vegetarianPlanner.addMeal(vegMeal1);
        vegetarianPlanner.addMeal(vegMeal2);

        // Create Vegan Meals
        System.out.println("\n--- Creating Vegan Meals ---");
        Meal<VeganMeal> veganMeal1 = new Meal<>("VG001", "Tofu Stir Fry", new VeganMeal(), 1);
        veganMeal1.addIngredients(java.util.Arrays.asList("Tofu", "Vegetables", "Seeds"));
        veganMeal1.setPreparationTime(25);
        veganMeal1.setInstructions("Stir fry tofu with vegetables and seeds");

        Meal<VeganMeal> veganMeal2 = new Meal<>("VG002", "Chickpea Salad", new VeganMeal(), 2);
        veganMeal2.addIngredients(java.util.Arrays.asList("Legumes", "Vegetables", "Nuts", "Seeds"));
        veganMeal2.setPreparationTime(15);
        veganMeal2.setInstructions("Mix chickpeas with fresh vegetables and dress with oil");

        veganPlanner.addMeal(veganMeal1);
        veganPlanner.addMeal(veganMeal2);

        // Create Keto Meals
        System.out.println("\n--- Creating Keto Meals ---");
        Meal<KetoMeal> ketoMeal1 = new Meal<>("K001", "Grilled Salmon with Avocado", new KetoMeal(), 1);
        ketoMeal1.addIngredients(java.util.Arrays.asList("Fish", "Avocado", "Olive Oil", "Low-carb Vegetables"));
        ketoMeal1.setPreparationTime(35);
        ketoMeal1.setInstructions("Grill salmon and serve with avocado and olive oil");

        Meal<KetoMeal> ketoMeal2 = new Meal<>("K002", "Butter Cheese Eggs", new KetoMeal(), 1);
        ketoMeal2.addIngredients(java.util.Arrays.asList("Eggs", "Cheese", "Butter"));
        ketoMeal2.setPreparationTime(10);
        ketoMeal2.setInstructions("Scramble eggs in butter and top with cheese");

        ketoPlanner.addMeal(ketoMeal1);
        ketoPlanner.addMeal(ketoMeal2);

        // Create High-Protein Meals for Fitness
        System.out.println("\n--- Creating High-Protein Meals ---");
        Meal<HighProteinMeal> proteinMeal1 = new Meal<>("HP001", "Grilled Chicken Breast with Lentils", new HighProteinMeal(), 1);
        proteinMeal1.addIngredients(java.util.Arrays.asList("Chicken", "Legumes", "Whole Grains"));
        proteinMeal1.setPreparationTime(40);
        proteinMeal1.setInstructions("Grill chicken and serve with cooked lentils");

        Meal<HighProteinMeal> proteinMeal2 = new Meal<>("HP002", "Greek Yogurt with Nuts", new HighProteinMeal(), 1);
        proteinMeal2.addIngredients(java.util.Arrays.asList("Greek Yogurt", "Nuts", "Whole Grains"));
        proteinMeal2.setPreparationTime(5);
        proteinMeal2.setInstructions("Mix Greek yogurt with nuts and granola");

        Meal<HighProteinMeal> proteinMeal3 = new Meal<>("HP003", "Lean Beef with Beans", new HighProteinMeal(), 1);
        proteinMeal3.addIngredients(java.util.Arrays.asList("Lean Beef", "Legumes", "Vegetables"));
        proteinMeal3.setPreparationTime(45);
        proteinMeal3.setInstructions("Cook lean beef and serve with beans");

        fitnessPlan.addMeal(proteinMeal1);
        fitnessPlan.addMeal(proteinMeal2);
        fitnessPlan.addMeal(proteinMeal3);

        // Display all meal plans
        vegetarianPlanner.displayMealPlans();
        veganPlanner.displayMealPlans();
        ketoPlanner.displayMealPlans();
        fitnessPlan.displayMealPlans();

        // Display meals by type
        System.out.println("\n--- Displaying Meals by Type ---");
        fitnessPlan.displayMealsByType("High-Protein");
        ketoPlanner.displayMealsByType("Keto");

        // Display nutrition summaries
        System.out.println("\n--- Nutrition Summaries ---");
        vegetarianPlanner.displayNutritionSummary();
        veganPlanner.displayNutritionSummary();
        ketoPlanner.displayNutritionSummary();
        fitnessPlan.displayNutritionSummary();

        // Validate meal plans
        System.out.println("\n--- Validating Meal Plans ---");
        vegMeal1.validateMealPlan(vegMeal1);
        ketoMeal1.validateMealPlan(ketoMeal1);
        proteinMeal1.validateMealPlan(proteinMeal1);

        // Test restricted foods
        System.out.println("\n--- Testing Restricted Foods ---");
        System.out.println("Is 'Meat' restricted in Vegan meal? " + veganMeal1.isRestricted("Meat"));
        System.out.println("Is 'Bread' restricted in Keto meal? " + ketoMeal1.isRestricted("Bread"));
        System.out.println("Is 'Fish' restricted in High-Protein meal? " + proteinMeal1.isRestricted("Fish"));

        System.out.println("\n" + "█".repeat(100));
        System.out.println("Generics Benefits Demonstrated:");
        System.out.println("✓ Generic Methods: addMeal() method");
        System.out.println("✓ Type Parameters: <T extends MealPlan>");
        System.out.println("✓ Bounded Type Parameters: Ensures only valid meal plans");
        System.out.println("✓ Wildcards: List<? extends MealPlan> for flexible collections");
        System.out.println("✓ Type Safety: No ClassCastException");
        System.out.println("█".repeat(100) + "\n");
    }
}
