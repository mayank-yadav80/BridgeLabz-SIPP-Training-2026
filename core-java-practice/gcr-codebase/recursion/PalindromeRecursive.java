public class PalindromeRecursive {
    public static void main(String[] args) {
        String input = "madam";
        System.out.println(isPalindrome(input) ? "Palindrome" : "Not Palindrome");
    }

    private static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        return checkPalindrome(s, 0, s.length() - 1);
    }

    private static boolean checkPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return checkPalindrome(s, left + 1, right - 1);
    }
}
