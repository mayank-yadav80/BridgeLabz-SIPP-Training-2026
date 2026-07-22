import java.util.*;

public class SafeFolderDeletion {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static void deleteFolderTree(Node node) {
        if (node == null) return;
        deleteFolderTree(node.left);
        deleteFolderTree(node.right);
        deleteNode(node);
    }

    static void deleteNode(Node node) {
        System.out.println("Deleted folder: " + node.val);
    }

    static Node buildTree(Scanner sc) {
        System.out.print("Enter folder ID (-1 for empty): ");
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
        System.out.println("Build the folder tree:");
        Node root = buildTree(sc);

        System.out.println("Deleting folder tree in safe postorder:");
        deleteFolderTree(root);
        sc.close();
    }
}
