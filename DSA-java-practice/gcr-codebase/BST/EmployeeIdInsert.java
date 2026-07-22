import java.util.*;

public class EmployeeIdInsert {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node insert(Node node, int id) {
        if (node == null) {
            return new Node(id);
        }
        if (id < node.val) {
            node.left = insert(node.left, id);
        } else if (id > node.val) {
            node.right = insert(node.right, id);
        }
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

        System.out.print("Enter number of existing employees: ");
        int n = sc.nextInt();
        System.out.println("Enter employee IDs:");
        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        System.out.print("Enter new employee ID to insert: ");
        int newId = sc.nextInt();
        root = insert(root, newId);

        List<Integer> sorted = new ArrayList<>();
        inorder(root, sorted);
        System.out.println("Directory after insertion: " + sorted);
        sc.close();
    }
}
