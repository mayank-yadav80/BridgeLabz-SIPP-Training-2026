import java.util.Scanner;

public class SpringSeason {
    public static boolean isSpringSeason(int month, int day) {
        if (month == 3 && day >= 20 && day <= 31) {
            return true;
        }
        if (month > 3 && month < 6) {
            return true;
        }
        return month == 6 && day >= 1 && day <= 20;
    }

    public static void main(String[] args) {
        int month;
        int day;
        if (args.length >= 2) {
            month = Integer.parseInt(args[0]);
            day = Integer.parseInt(args[1]);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter month (1-12): ");
            month = scanner.nextInt();
            System.out.print("Enter day (1-31): ");
            day = scanner.nextInt();
            scanner.close();
        }
        boolean spring = isSpringSeason(month, day);
        System.out.println(spring ? "Its a Spring Season" : "Not a Spring Season");
    }
}
