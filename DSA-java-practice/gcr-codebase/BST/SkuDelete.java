import java.util.*;

public class SkuDelete {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node delete(Node node, int sku) {
        if (node == null) return null;
        if (sku < node.val) {
            node.left = delete(node.left, sku);
        } else if (sku > node.val) {
            node.right = delete(node.right, sku);
        } else {
            if (node.left == null && node.right == null) return null;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node successor = node.right;
            while (successor.left != null) successor = successor.left;
            node.val = successor.val;
            node.right = delete(node.right, successor.val);
        }
        return node;
    }

    static Node insert(Node node, int id) {
        if (node == null) return new Node(id);
        if (id < node.val) node.left = insert(node.left, id);
        else if (id > node.val) node.right = insert(node.right, id);
        return node;
    }

    static void inorder(Node node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;

        System.out.print("Enter number of SKUs: ");
        int n = sc.nextInt();
        System.out.println("Enter SKU values:");
        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        List<Integer> before = new ArrayList<>();
        inorder(root, before);
        System.out.println("Catalog before deletion: " + before);

        System.out.print("Enter SKU to delete: ");
        int sku = sc.nextInt();
        root = delete(root, sku);

        List<Integer> after = new ArrayList<>();
        inorder(root, after);
        System.out.println("Catalog after deletion:  " + after);
        sc.close();
    }
}
