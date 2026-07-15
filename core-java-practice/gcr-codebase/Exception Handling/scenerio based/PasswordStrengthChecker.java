public class PasswordStrengthChecker {
    public static void main(String[] args) {
        checkPassword(null);
        checkPassword("");
        checkPassword("Short1@");
        checkPassword("weakpassword1");
        checkPassword("Strong#1");
        checkPassword("ValidPass@");
        checkPassword("ValidPass1");
        checkPassword("ValidPass1@");
    }

    public static void checkPassword(String password) {
        try {
            if (password == null) {
                throw new IllegalArgumentException("Password cannot be null");
            }
            if (password.isEmpty()) {
                throw new IllegalArgumentException("Password cannot be empty");
            }
            if (password.length() < 8) {
                throw new IllegalArgumentException("Password must be at least 8 characters long");
            }
            if (!Character.isUpperCase(password.charAt(0))) {
                throw new IllegalArgumentException("Password must start with an uppercase letter");
            }
            if (!Character.isDigit(password.charAt(password.length() - 1))) {
                throw new IllegalArgumentException("Password must end with a digit");
            }
            if (!password.matches(".*[@#$%&*].*")) {
                throw new IllegalArgumentException("Password must contain at least one special character (@, #, $, %, &, *)");
            }
            System.out.println("Password is strong: " + password);
        } catch (IllegalArgumentException e) {
            System.out.println("Password validation error: " + e.getMessage());
        }
    }
}
