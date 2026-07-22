import java.util.*;

public class LongestCommunicationPath {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int diameter;

    static int heightAndUpdateDiameter(Node node) {
        if (node == null) return -1;
        int leftHeight = heightAndUpdateDiameter(node.left);
        int rightHeight = heightAndUpdateDiameter(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight + 2);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static int longestCommunicationPath(Node root) {
        diameter = 0;
        heightAndUpdateDiameter(root);
        return diameter;
    }

    static Node buildTree(Scanner sc) {
        System.out.print("Enter employee ID (-1 for empty): ");
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
        System.out.println("Build the org tree:");
        Node root = buildTree(sc);

        int d = longestCommunicationPath(root);
        System.out.println("Longest communication path (edges): " + d);
        sc.close();
    }
}
