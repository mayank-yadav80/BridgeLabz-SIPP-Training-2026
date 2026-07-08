import java.util.*;

public class EmployeeAttendanceRanking {

    public static int[] topKEmployees(int[] employeeIds, int[] attendance, int k) {
        int n = employeeIds.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, (a, b) -> {
            if (attendance[b] != attendance[a]) return attendance[b] - attendance[a];
            return employeeIds[a] - employeeIds[b];
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = employeeIds[indices[i]];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        int[] ids = new int[n];
        int[] attendance = new int[n];
        System.out.println("Enter employee IDs:");
        for (int i = 0; i < n; i++) ids[i] = sc.nextInt();
        System.out.println("Enter attendance percentages:");
        for (int i = 0; i < n; i++) attendance[i] = sc.nextInt();
        System.out.print("Enter K: ");
        int k = sc.nextInt();

        int[] top = topKEmployees(ids, attendance, k);
        System.out.println("Top " + k + " employees: " + Arrays.toString(top));
    }
}
