import java.util.*;

public class QuickSortFlightPrices {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tickets: ");
        int N = sc.nextInt();
        int[] prices = new int[N];
        System.out.println("Enter ticket prices:");
        for (int i = 0; i < N; i++) prices[i] = sc.nextInt();
        quickSort(prices, 0, N - 1);
        System.out.println("Sorted ticket prices: " + Arrays.toString(prices));
    }
}
