import java.util.Scanner;

class NaturalNumberSumForCompare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();

        if (n >= 0) {
            int formulaSum = n * (n + 1) / 2;
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }

            System.out.println("Formula sum: " + formulaSum);
            System.out.println("For loop sum: " + loopSum);
            System.out.println("Results match: " + (formulaSum == loopSum));
        } else {
            System.out.println("The number " + n + " is not a natural number");
        }
        input.close();
    }
}
