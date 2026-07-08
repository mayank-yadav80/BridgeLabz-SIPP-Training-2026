import java.util.*;

public class RotationPointFinder {

    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter rotated sorted array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int idx = findRotationPoint(arr);
        System.out.println("Rotation point index: " + idx);
        System.out.println("Smallest element (rotation point): " + arr[idx]);
    }
}
