import java.util.*;

public class TopKHighestSpenders {

    static List<Integer> topKLargest(int[] transactions, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int amount : transactions) {
            if (minHeap.size() < k) {
                minHeap.offer(amount);
            } else if (amount > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(amount);
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();
        int[] transactions = new int[n];
        System.out.println("Enter transaction amounts:");
        for (int i = 0; i < n; i++) {
            transactions[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        List<Integer> topK = topKLargest(transactions, k);
        System.out.println("Top " + k + " highest spenders: " + topK);
        sc.close();
    }
}
