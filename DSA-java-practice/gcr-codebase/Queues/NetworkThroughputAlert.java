import java.util.*;

public class NetworkThroughputAlert {

    public static int[] maxThroughputWindow(int[] readings, int k) {
        int n = readings.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && readings[deque.peekLast()] <= readings[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = readings[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of readings: ");
        int n = sc.nextInt();
        int[] readings = new int[n];
        System.out.println("Enter throughput readings:");
        for (int i = 0; i < n; i++) readings[i] = sc.nextInt();
        System.out.print("Enter window size (k): ");
        int k = sc.nextInt();

        int[] result = maxThroughputWindow(readings, k);

        System.out.println("Max throughput in each trailing " + k + "-second window:");
        for (int i = 0; i < result.length; i++) {
            System.out.println("Window [" + i + "-" + (i + k - 1) + "]: " + result[i]);
        }
        sc.close();
    }
}
