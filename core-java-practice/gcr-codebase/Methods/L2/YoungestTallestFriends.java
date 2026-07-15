import java.util.Scanner;

public class YoungestTallestFriends {
    public static int findYoungestIndex(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    public static int findTallestIndex(double[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[names.length];
        double[] heights = new double[names.length];

        for (int i = 0; i < names.length; i++) {
            System.out.printf("Enter age of %s: ", names[i]);
            ages[i] = scanner.nextInt();
            System.out.printf("Enter height of %s in meters: ", names[i]);
            heights[i] = scanner.nextDouble();
        }

        int youngestIndex = findYoungestIndex(ages);
        int tallestIndex = findTallestIndex(heights);
        System.out.printf("Youngest friend: %s (age %d)%n", names[youngestIndex], ages[youngestIndex]);
        System.out.printf("Tallest friend: %s (height %.2f m)%n", names[tallestIndex], heights[tallestIndex]);
        scanner.close();
    }
}
