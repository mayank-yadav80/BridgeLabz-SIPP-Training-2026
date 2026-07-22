import java.util.*;

public class CategoryTreeDepth {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int height(Node node) {
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    static boolean isTooDeep(Node root, int threshold) {
        return height(root) > threshold;
    }

    static Node buildTree(Scanner sc) {
        System.out.print("Enter category ID (-1 for empty): ");
        int val = sc.nextInt();
        if (val == -1) return null;

        Node node = new Node(val);
        System.out.println("Enter left subtree for " + val + ":");
        node.left = buildTree(sc);
        System.out.println("Enter right subtree for " + val + ":");
        node.right = buildTree(sc);
        return node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Build the category tree:");
        Node root = buildTree(sc);

        int h = height(root);
        System.out.print("Enter depth threshold: ");
        int threshold = sc.nextInt();

        System.out.println("Tree height: " + h);
        if (isTooDeep(root, threshold)) {
            System.out.println("ALERT: Tree exceeds threshold of " + threshold + "!");
        } else {
            System.out.println("OK: Tree depth is within the threshold.");
        }
        sc.close();
    }
}
