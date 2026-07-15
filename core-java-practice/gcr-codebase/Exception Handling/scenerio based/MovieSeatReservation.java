public class MovieSeatReservation {
    private static final int[] seats = {101, 102, 103, 104, 105};

    public static void main(String[] args) {
        int requestedIndex = 8;
        int seat = getSeat(requestedIndex);
        if (seat == -1) {
            System.out.println("Seat request failed for index " + requestedIndex);
        } else {
            System.out.println("Seat number: " + seat);
        }
    }

    public static int getSeat(int index) {
        try {
            return seats[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat position: " + index);
            return -1;
        }
    }
}
