import java.util.Scanner;

class HarshadNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = Math.abs(input.nextInt());

        int original = number;
        int sum = 0;
        while (original != 0) {
            sum += original % 10;
            original /= 10;
        }

        if (sum != 0 && number % sum == 0)
            System.out.println(number + " is a Harshad Number");
        else
            System.out.println(number + " is not a Harshad Number");
        input.close();
    }
}
