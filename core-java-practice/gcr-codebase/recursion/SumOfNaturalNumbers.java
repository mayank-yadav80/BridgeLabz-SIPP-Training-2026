public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(sumUpTo(n));
    }

    private static int sumUpTo(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sumUpTo(n - 1);
    }
}
