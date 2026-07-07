import java.util.*;

public class SportsMeetSorting {

    public static int bubbleSortWithFlag(int[] arr) {
        int n = arr.length;
        int swaps = 0;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return swaps;
    }

    public static int insertionSort(int[] arr) {
        int n = arr.length;
        int swaps = 0;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                swaps++;
            }
            arr[j + 1] = key;
        }
        return swaps;
    }

    public static int[] topK(int[] scores, int k) {
        int n = scores.length;
        int[] sorted = Arrays.copyOf(scores, n);
        bubbleSortWithFlag(sorted);
        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = sorted[n - 1 - i];
        }
        return top;
    }

    public static void tracePassByPass(int[] arr) {
        System.out.println("Initial: " + Arrays.toString(arr));
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(arr));
        }
        System.out.println("Sorted: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] scores = new int[50];
        for (int i = 0; i < 50; i++) {
            scores[i] = rand.nextInt(101);
        }

        int[] bubbleArr = Arrays.copyOf(scores, 50);
        int bubbleSwaps = bubbleSortWithFlag(bubbleArr);
        System.out.println("Bubble Sort swaps: " + bubbleSwaps);

        int[] insertionArr = Arrays.copyOf(scores, 50);
        int insertionSwaps = insertionSort(insertionArr);
        System.out.println("Insertion Sort swaps: " + insertionSwaps);

        int[] top3 = topK(scores, 3);
        System.out.println("Top 3 medalists: " + Arrays.toString(top3));

        System.out.println("\n--- Pass-by-pass trace on [64, 25, 12, 22, 11] ---");
        tracePassByPass(new int[]{64, 25, 12, 22, 11});

        int[] alreadySorted = {1, 2, 3, 4, 5};
        System.out.println("\nBest case (already sorted): " + Arrays.toString(alreadySorted));
        int bestSwaps = bubbleSortWithFlag(alreadySorted);
        System.out.println("Bubble Sort swaps (best case): " + bestSwaps + " (flag detected sorted)");
    }
}
