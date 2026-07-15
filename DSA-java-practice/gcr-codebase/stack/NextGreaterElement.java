import java.util.*;

public class NextGreaterElement {

    public static int[] nextBusierDay(int[] visitors) {
        int n = visitors.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && visitors[i] > visitors[stack.peek()]) {
                answer[stack.pop()] = visitors[i];
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] visitors = new int[n];
        System.out.println("Enter visitor counts:");
        for (int i = 0; i < n; i++) visitors[i] = sc.nextInt();

        int[] result = nextBusierDay(visitors);
        System.out.println("Next greater visitor count for each day:");
        for (int i = 0; i < n; i++) {
            System.out.println("Day " + (i + 1) + ": " + visitors[i] + " -> " + (result[i] == -1 ? "none" : result[i]));
        }
        sc.close();
    }
}
