import java.util.*;

public class SortedLeaderboard {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val);
        return root;
    }

    static void inorder(Node node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    static List<Integer> getSortedLeaderboard(Node root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        Node root = null;
        System.out.println("Enter player scores:");
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            root = insert(root, score);
        }

        List<Integer> sorted = getSortedLeaderboard(root);
        System.out.println("Leaderboard (ascending): " + sorted);
        sc.close();
    }
}
