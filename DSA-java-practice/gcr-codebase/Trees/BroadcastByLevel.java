import java.util.*;

public class BroadcastByLevel {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static List<List<Integer>> broadcastByLevel(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
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

        List<List<Integer>> levels = broadcastByLevel(root);
        System.out.println("Level-order broadcast:");
        for (int i = 0; i < levels.size(); i++) {
            System.out.println("  Level " + i + ": " + levels.get(i));
        }
        sc.close();
    }
}
