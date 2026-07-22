import java.util.*;

public class NightlyBatchHeapify {

    static void buildHeap(int[] priorities) {
        int n = priorities.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(priorities, i, n);
        }
    }

    static void siftDown(int[] arr, int i, int size) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && arr[left] < arr[smallest]) smallest = left;
        if (right < size && arr[right] < arr[smallest]) smallest = right;
        if (smallest != i) {
            int tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;
            siftDown(arr, smallest, size);
        }
    }

    static boolean isMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n / 2 - 1; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && arr[i] > arr[left]) return false;
            if (right < n && arr[i] > arr[right]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of shipments: ");
        int n = sc.nextInt();
        int[] priorities = new int[n];
        System.out.println("Enter shipment priorities:");
        for (int i = 0; i < n; i++) {
            priorities[i] = sc.nextInt();
        }

        System.out.println("Before heapify: " + Arrays.toString(priorities));
        buildHeap(priorities);
        System.out.println("After heapify:  " + Arrays.toString(priorities));
        System.out.println("Valid min-heap: " + isMinHeap(priorities));
        sc.close();
    }
}
