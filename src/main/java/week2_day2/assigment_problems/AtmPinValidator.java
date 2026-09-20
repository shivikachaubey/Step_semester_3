package strings.assigment_problems;

public class AtmPinValidator {

    public void checkPinLength(String pin) {
        if (pin != null && pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        }
    }

    public static void main(String[] args) {
        AtmPinValidator validator = new AtmPinValidator();
        validator.checkPinLength("482");
        validator.checkPinLength("4820");
    }
}