import java.util.*;

public class MostFrequentErrorCode {

    public static int mostFrequentErrorCode(int[] codes) {
        Map<Integer, Integer> freq = new HashMap<>();
        int bestCode = codes[0], bestCount = 0;
        for (int code : codes) {
            int count = freq.merge(code, 1, Integer::sum);
            if (count > bestCount) {
                bestCount = count;
                bestCode = code;
            }
        }
        return bestCode;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of error codes: ");
        int n = sc.nextInt();
        int[] codes = new int[n];
        System.out.println("Enter error codes:");
        for (int i = 0; i < n; i++) {
            codes[i] = sc.nextInt();
        }

        System.out.println("Most frequent error code: " + mostFrequentErrorCode(codes));
        sc.close();
    }
}
