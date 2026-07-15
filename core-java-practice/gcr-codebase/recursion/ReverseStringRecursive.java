public class ReverseStringRecursive {
    public static void main(String[] args) {
        String input = "hello";
        System.out.println(reverse(input));
    }

    private static String reverse(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    }
}
