import java.util.*;

public class StarBrightnessSearch {

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int searchRotated(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (target > arr[mid] && target <= arr[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    public static int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) left = mid + 1;
            else right = mid;
        }
        return arr[left];
    }

    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }

    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Star Brightness Catalog ===");
        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();
        int[] stars = new int[n];
        System.out.println("Enter sorted brightness values:");
        for (int i = 0; i < n; i++) stars[i] = sc.nextInt();

        System.out.print("Enter target to search: ");
        int target = sc.nextInt();
        int idx = binarySearch(stars, target);
        System.out.println("Standard binary search index: " + (idx != -1 ? idx : "not found"));

        int first = findFirst(stars, target);
        int last = findLast(stars, target);
        System.out.println("First occurrence: " + (first != -1 ? first : -1));
        System.out.println("Last occurrence: " + (last != -1 ? last : -1));

        System.out.println("\n=== Rotated Catalog (telescope glitch) ===");
        System.out.print("Enter rotated brightness values: ");
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) rotated[i] = sc.nextInt();

        System.out.print("Enter target in rotated catalog: ");
        int rotTarget = sc.nextInt();
        int rotIdx = searchRotated(rotated, rotTarget);
        System.out.println("Found at index: " + (rotIdx != -1 ? rotIdx : "not found"));

        int minVal = findMin(rotated);
        System.out.println("Minimum brightness value: " + minVal);
    }
}
