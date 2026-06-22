public class SmartLibrarySystem {
    private static final String[] books = {"Java", "Python", null, "C++"};

    public static void main(String[] args) {
        printBookLength(0);
        printBookLength(2);
        printBookLength(5);
    }

    public static void printBookLength(int index) {
        try {
            int length = getBookLength(index);
            System.out.println("Book length: " + length);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid book index: " + index);
        } catch (NullPointerException e) {
            System.out.println("Book entry at index " + index + " is not available");
        }
    }

    public static int getBookLength(int index) {
        String book = books[index];
        return book.length();
    }
}
