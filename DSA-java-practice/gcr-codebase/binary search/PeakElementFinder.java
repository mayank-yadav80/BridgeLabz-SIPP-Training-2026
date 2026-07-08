import java.util.*;

public class PeakElementFinder {

    public static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean leftCheck = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightCheck = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]);
            if (leftCheck && rightCheck) return mid;
            if (mid > 0 && arr[mid] < arr[mid - 1]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int idx = findPeak(arr);
        System.out.println("Peak element: " + arr[idx] + " at index " + idx);
    }
}
