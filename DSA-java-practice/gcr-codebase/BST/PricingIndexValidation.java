import java.util.*;

public class PricingIndexValidation {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(Node node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    static Node insert(Node node, int id) {
        if (node == null) return new Node(id);
        if (id < node.val) node.left = insert(node.left, id);
        else if (id > node.val) node.right = insert(node.right, id);
        return node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        System.out.println(isValidBST(root) ? "Valid BST" : "Invalid BST — corruption detected");

        System.out.println("\n--- Manual tree input for corruption test ---");
        System.out.print("Enter root value: ");
        int rv = sc.nextInt();
        Node manual = new Node(rv);
        System.out.print("Enter left child of root (-1 for none): ");
        int lv = sc.nextInt();
        if (lv != -1) manual.left = new Node(lv);
        System.out.print("Enter right child of root (-1 for none): ");
        int rrv = sc.nextInt();
        if (rrv != -1) manual.right = new Node(rrv);

        System.out.println(isValidBST(manual) ? "Valid BST" : "Invalid BST — corruption detected");
        sc.close();
    }
}
