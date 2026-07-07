import java.util.*;

public class SelectionSortMovieRatings {

    public static void selectionSort(int[] ratings) {
        int n = ratings.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (ratings[j] < ratings[minIdx]) minIdx = j;
            }
            int temp = ratings[i];
            ratings[i] = ratings[minIdx];
            ratings[minIdx] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N: ");
        int n = sc.nextInt();
        int[] ratings = new int[n];
        for (int i = 0; i < n; i++) ratings[i] = sc.nextInt();

        selectionSort(ratings);
        System.out.println(Arrays.toString(ratings));
    }
}
