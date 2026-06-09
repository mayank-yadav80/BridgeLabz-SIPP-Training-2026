import java.util.Scanner;

class YoungestAndTallestFriends {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Amar's age: ");
        int amarAge = input.nextInt();
        System.out.print("Enter Amar's height in cm: ");
        int amarHeight = input.nextInt();

        System.out.print("Enter Akbar's age: ");
        int akbarAge = input.nextInt();
        System.out.print("Enter Akbar's height in cm: ");
        int akbarHeight = input.nextInt();

        System.out.print("Enter Anthony's age: ");
        int anthonyAge = input.nextInt();
        System.out.print("Enter Anthony's height in cm: ");
        int anthonyHeight = input.nextInt();

        int youngestAge = amarAge;
        String youngestName = "Amar";
        if (akbarAge < youngestAge) {
            youngestAge = akbarAge;
            youngestName = "Akbar";
        }
        if (anthonyAge < youngestAge) {
            youngestAge = anthonyAge;
            youngestName = "Anthony";
        }

        int tallestHeight = amarHeight;
        String tallestName = "Amar";
        if (akbarHeight > tallestHeight) {
            tallestHeight = akbarHeight;
            tallestName = "Akbar";
        }
        if (anthonyHeight > tallestHeight) {
            tallestHeight = anthonyHeight;
            tallestName = "Anthony";
        }

        System.out.println("Youngest friend: " + youngestName + " (age " + youngestAge + ")");
        System.out.println("Tallest friend: " + tallestName + " (height " + tallestHeight + " cm)");
        input.close();
    }
}
