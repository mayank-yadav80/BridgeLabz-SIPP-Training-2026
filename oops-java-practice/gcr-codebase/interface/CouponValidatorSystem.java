public class CouponValidatorSystem {
    public static void main(String[] args) {
        String[] coupons = {"SAVE20", "DISCOUNT5", "X1", "WELCOME100"};
        ShoppingCart cart = new ShoppingCart();

        for (String coupon : coupons) {
            boolean isValid = cart.validateCoupon(coupon);
            System.out.println(coupon + " is " + (isValid ? "valid" : "invalid"));
        }
    }
}

interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 5 && code.length() <= 10;
    }
}

class ShoppingCart implements CouponValidator {
    @Override
    public boolean validateCoupon(String code) {
        if (code == null || !CouponValidator.isLengthValid(code)) {
            return false;
        }
        return code.matches("[A-Z0-9]+") && (code.startsWith("SAVE") || code.startsWith("WELCOME") || code.contains("DISCOUNT"));
    }
}
