import java.util.*;

public class PairSumFraudDetection {

    public static int[] findPairSum(int[] transactions, int target) {
        int left = 0, right = transactions.length - 1;
        while (left < right) {
            int sum = transactions[left] + transactions[right];
            if (sum == target) return new int[]{transactions[left], transactions[right]};
            else if (sum < target) left++;
            else right--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();
        int[] transactions = new int[n];
        System.out.println("Enter sorted transaction amounts:");
        for (int i = 0; i < n; i++) transactions[i] = sc.nextInt();
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        int[] result = findPairSum(transactions, target);
        if (result[0] == -1) System.out.println("No pair found.");
        else System.out.println("Pair found: " + result[0] + " + " + result[1] + " = " + target);
    }
}
