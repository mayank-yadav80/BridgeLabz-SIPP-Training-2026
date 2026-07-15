import java.util.*;

public class StockSpan {

    public static int[] loadSpan(int[] load) {
        int n = load.length;
        int[] span = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && load[stack.peek()] <= load[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of readings: ");
        int n = sc.nextInt();
        int[] load = new int[n];
        System.out.println("Enter load readings:");
        for (int i = 0; i < n; i++) load[i] = sc.nextInt();

        int[] result = loadSpan(load);
        System.out.println("Load span for each reading:");
        for (int i = 0; i < n; i++) {
            System.out.println("Reading " + (i + 1) + ": " + load[i] + " -> span: " + result[i]);
        }
        sc.close();
    }
}
