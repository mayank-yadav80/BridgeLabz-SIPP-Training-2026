import java.util.Scanner;

class GreatestFactorFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer greater than 1: ");
        int number = input.nextInt();

        if (number <= 1) {
            System.out.println("Please enter an integer greater than 1.");
        } else {
            int greatestFactor = 1;
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break;
                }
            }
            System.out.println("Greatest factor beside itself: " + greatestFactor);
        }
        input.close();
    }
}
