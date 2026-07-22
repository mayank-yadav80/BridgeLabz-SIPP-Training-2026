import java.util.*;

public class RollingRevenueWindow {

    public static int subarraySumEqualsK(int[] revenueChanges, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int runningSum = 0, answer = 0;
        for (int change : revenueChanges) {
            runningSum += change;
            answer += prefixCount.getOrDefault(runningSum - k, 0);
            prefixCount.merge(runningSum, 1, Integer::sum);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] revenueChanges = new int[n];
        System.out.println("Enter daily net revenue changes:");
        for (int i = 0; i < n; i++) {
            revenueChanges[i] = sc.nextInt();
        }

        System.out.print("Enter target sum k: ");
        int k = sc.nextInt();

        System.out.println("Revenue-neutral subarrays (sum = " + k + "): " + subarraySumEqualsK(revenueChanges, k));
        sc.close();
    }
}
