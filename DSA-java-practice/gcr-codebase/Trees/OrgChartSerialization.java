import java.util.*;

public class OrgChartSerialization {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static List<Integer> iterativePreorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    static Node buildTree(Scanner sc) {
        System.out.print("Enter manager ID (-1 for empty): ");
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

        List<Integer> serialized = iterativePreorder(root);
        System.out.println("Preorder serialization: " + serialized);
        sc.close();
    }
}
