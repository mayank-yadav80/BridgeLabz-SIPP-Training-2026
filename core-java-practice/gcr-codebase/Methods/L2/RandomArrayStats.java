public class RandomArrayStats {
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = 1000 + (int) (Math.random() * 9000);
        }
        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        for (int number : numbers) {
            sum += number;
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }
        return new double[]{sum / numbers.length, min, max};
    }

    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);
        System.out.print("Generated 4-digit random values: ");
        for (int number : randomNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        double[] stats = findAverageMinMax(randomNumbers);
        System.out.printf("Average: %.2f%n", stats[0]);
        System.out.printf("Minimum: %.0f%n", stats[1]);
        System.out.printf("Maximum: %.0f%n", stats[2]);
    }
}
