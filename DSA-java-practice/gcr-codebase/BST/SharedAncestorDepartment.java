import java.util.*;

public class SharedAncestorDepartment {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node lowestCommonAncestor(Node root, int p, int q) {
        Node current = root;
        while (current != null) {
            if (p < current.val && q < current.val) {
                current = current.left;
            } else if (p > current.val && q > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
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

        System.out.print("Enter number of departments: ");
        int n = sc.nextInt();
        System.out.println("Enter department codes:");
        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        System.out.print("Enter first department code: ");
        int p = sc.nextInt();
        System.out.print("Enter second department code: ");
        int q = sc.nextInt();

        Node lca = lowestCommonAncestor(root, p, q);
        if (lca != null) {
            System.out.println("Lowest common ancestor of " + p + " and " + q + " is: " + lca.val);
        } else {
            System.out.println("LCA not found");
        }
        sc.close();
    }
}
