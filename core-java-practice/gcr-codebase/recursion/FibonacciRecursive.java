public class FibonacciRecursive {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
