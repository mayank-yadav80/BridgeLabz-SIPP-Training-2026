import java.util.*;

public class MinCoverageWindowLogStream {

    public static String minWindowSubstring(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) need.merge(c, 1, Integer::sum);
        Map<Character, Integer> window = new HashMap<>();
        int required = need.size(), formed = 0;
        int start = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            window.merge(c, 1, Integer::sum);
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue())
                formed++;
            while (formed == required) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                char leftChar = s.charAt(start);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar))
                    formed--;
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the log string: ");
        String s = sc.nextLine();
        System.out.print("Enter the error code characters: ");
        String t = sc.nextLine();

        String result = minWindowSubstring(s, t);
        if (result.isEmpty()) System.out.println("No minimum window found.");
        else System.out.println("Minimum window substring: \"" + result + "\"");
    }
}
