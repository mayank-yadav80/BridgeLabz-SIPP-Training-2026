import java.util.Scanner;

class SmallestCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int number1 = input.nextInt();
        System.out.print("Enter second number: ");
        int number2 = input.nextInt();
        System.out.print("Enter third number: ");
        int number3 = input.nextInt();

        boolean isSmallest = number1 < number2 && number1 < number3;
        System.out.println("Is the first number the smallest? " + isSmallest);
        input.close();
    }
}
