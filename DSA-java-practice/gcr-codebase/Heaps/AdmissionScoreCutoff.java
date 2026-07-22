import java.util.*;

public class AdmissionScoreCutoff {

    static int findKthLargest(int[] scores, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int score : scores) {
            if (minHeap.size() < k) {
                minHeap.offer(score);
            } else if (score > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(score);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of applicants: ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        System.out.println("Enter applicant scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.print("Enter k (for k-th largest): ");
        int k = sc.nextInt();

        System.out.println("Cutoff score (k-th largest): " + findKthLargest(scores, k));
        sc.close();
    }
}
