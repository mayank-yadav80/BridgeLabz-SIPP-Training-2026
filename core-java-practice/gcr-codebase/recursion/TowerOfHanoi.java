public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3;
        solveHanoi(n, 'A', 'C', 'B');
    }

    private static void solveHanoi(int disks, char source, char destination, char auxiliary) {
        if (disks == 0) {
            return;
        }
        solveHanoi(disks - 1, source, auxiliary, destination);
        System.out.println("Move disk " + disks + " from " + source + " to " + destination);
        solveHanoi(disks - 1, auxiliary, destination, source);
    }
}
