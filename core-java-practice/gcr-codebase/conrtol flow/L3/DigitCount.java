import java.util.Scanner;

class DigitCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = Math.abs(input.nextInt());

        if (number == 0) {
            System.out.println("Number of digits: 1");
        } else {
            int count = 0;
            while (number != 0) {
                number /= 10;
                count++;
            }
            System.out.println("Number of digits: " + count);
        }
        input.close();
    }
}
