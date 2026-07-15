import java.util.Scanner;

class AbundantNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer (>0): ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Enter a positive integer.");
        } else {
            int sum = 0;
            for (int i = 1; i < number; i++) {
                if (number % i == 0) sum += i;
            }
            if (sum > number)
                System.out.println(number + " is an Abundant Number");
            else
                System.out.println(number + " is not an Abundant Number");
        }
        input.close();
    }
}
