public class PowerRecursive {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 5;
        System.out.println(power(base, exponent));
    }

    private static long power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
}
