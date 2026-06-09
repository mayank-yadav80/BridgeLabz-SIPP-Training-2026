import java.util.Scanner;

class PowerFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a base number: ");
        int number = input.nextInt();
        System.out.print("Enter a positive exponent: ");
        int power = input.nextInt();

        if (power < 0) {
            System.out.println("Please enter a non-negative exponent.");
        } else {
            long result = 1;
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            System.out.println(number + " ^ " + power + " = " + result);
        }
        input.close();
    }
}
