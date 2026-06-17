import java.util.ArrayList;
import java.util.List;

public class SubsetGenerator {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(numbers);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    private static List<List<Integer>> generateSubsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        buildSubsets(arr, 0, new ArrayList<>(), result);
        return result;
    }

    private static void buildSubsets(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Exclude current element
        buildSubsets(arr, index + 1, current, result);
        // Include current element
        current.add(arr[index]);
        buildSubsets(arr, index + 1, current, result);
        current.remove(current.size() - 1);
    }
}
