import java.util.Scanner;

class PrimeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer (>1): ");
        int number = input.nextInt();

        if (number <= 1) {
            System.out.println("Numbers greater than 1 only can be prime.");
        } else {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.println(number + " is a Prime Number");
            else
                System.out.println(number + " is not a Prime Number");
        }
        input.close();
    }
}
