import java.util.*;

public class SensorReadingsSort {

    static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDownMax(arr, i, n);
        }
        for (int end = n - 1; end > 0; end--) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            siftDownMax(arr, 0, end);
        }
    }

    static void siftDownMax(int[] arr, int i, int size) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && arr[left] > arr[largest]) largest = left;
        if (right < size && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            siftDownMax(arr, largest, size);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of sensor readings: ");
        int n = sc.nextInt();
        int[] readings = new int[n];
        System.out.println("Enter readings:");
        for (int i = 0; i < n; i++) {
            readings[i] = sc.nextInt();
        }

        System.out.println("Before sort: " + Arrays.toString(readings));
        heapSort(readings);
        System.out.println("After sort:  " + Arrays.toString(readings));
        sc.close();
    }
}
