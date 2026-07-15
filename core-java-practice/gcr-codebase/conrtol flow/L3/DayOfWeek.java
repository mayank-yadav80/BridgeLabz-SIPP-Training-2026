import java.util.Scanner;

class DayOfWeek {
    // Sakamoto's algorithm: returns 0=Sunday..6=Saturday
    static int dayOfWeek(int y, int m, int d) {
        int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (m < 3) y -= 1;
        return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
    }

    public static void main(String[] args) {
        int m, d, y;
        if (args.length >= 3) {
            m = Integer.parseInt(args[0]);
            d = Integer.parseInt(args[1]);
            y = Integer.parseInt(args[2]);
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter month (1-12): ");
            m = input.nextInt();
            System.out.print("Enter day: ");
            d = input.nextInt();
            System.out.print("Enter year: ");
            y = input.nextInt();
            input.close();
        }

        int dow = dayOfWeek(y, m, d);
        System.out.println(dow);
    }
}
