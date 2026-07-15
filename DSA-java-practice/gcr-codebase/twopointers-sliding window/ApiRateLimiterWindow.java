import java.util.*;

public class ApiRateLimiterWindow {

    public static int longestSubarrayWithAtMostNDistinct(int[] keyIds, int n) {
        Map<Integer, Integer> freq = new HashMap<>();
        int start = 0, maxLen = 0;
        for (int end = 0; end < keyIds.length; end++) {
            freq.merge(keyIds[end], 1, Integer::sum);
            while (freq.size() > n) {
                int leftKey = keyIds[start];
                freq.put(leftKey, freq.get(leftKey) - 1);
                if (freq.get(leftKey) == 0) freq.remove(leftKey);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of requests: ");
        int n = sc.nextInt();
        int[] keyIds = new int[n];
        System.out.println("Enter API key IDs:");
        for (int i = 0; i < n; i++) keyIds[i] = sc.nextInt();
        System.out.print("Enter max distinct keys allowed (N): ");
        int N = sc.nextInt();

        int maxLen = longestSubarrayWithAtMostNDistinct(keyIds, N);
        System.out.println("Longest contiguous subarray with at most " + N + " distinct keys: " + maxLen);
    }
}
