import java.util.*;

public class DuplicateSessionToken {

    public static boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();
        for (String token : tokens) {
            if (!seen.add(token)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tokens: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] tokens = new String[n];
        System.out.println("Enter session tokens:");
        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextLine();
        }

        System.out.println(hasDuplicateToken(tokens) ? "Duplicate detected!" : "All tokens unique.");
        sc.close();
    }
}
