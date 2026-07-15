import java.util.Scanner;

class SpringSeason {
    public static void main(String[] args) {
        int month;
        int day;

        if (args.length >= 2) {
            month = Integer.parseInt(args[0]);
            day = Integer.parseInt(args[1]);
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter month (1-12): ");
            month = input.nextInt();
            System.out.print("Enter day: ");
            day = input.nextInt();
            input.close();
        }

        boolean isSpring = false;
        if (month == 3 && day >= 20 && day <= 31) {
            isSpring = true;
        } else if (month == 4 || month == 5) {
            isSpring = true;
        } else if (month == 6 && day <= 20 && day >= 1) {
            isSpring = true;
        }

        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
