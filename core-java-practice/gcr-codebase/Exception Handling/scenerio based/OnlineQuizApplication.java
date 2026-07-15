public class OnlineQuizApplication {
    public static void main(String[] args) {
        String[] answers = {"A", "B", "C", "D"};
        String[] submitted = {"A", "B", null, "D", "A", "B"};

        for (int i = 0; i < submitted.length; i++) {
            try {
                if (answers[i].equals(submitted[i])) {
                    System.out.println("Answer " + i + " is correct");
                } else {
                    System.out.println("Answer " + i + " is incorrect");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("No answer stored for index " + i + ". Skipping.");
            } catch (NullPointerException e) {
                System.out.println("Submitted answer at index " + i + " is missing. Continuing.");
            }
        }
    }
}
