package strings.class_problems;

public class TransactionReferenceHandler {

    public String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] DATE: ")
                 .append(day).append("/").append(month).append("/").append(year)
                 .append(" | SEQ: ").append(seq);

        return formatted.toString();
    }

    public static void main(String[] args) {
        TransactionReferenceHandler handler = new TransactionReferenceHandler();
        
        String norm1 = handler.normalizeReference(" hdf03022600042 ");
        System.out.println(handler.validateAndFormat(norm1));

        String norm2 = handler.normalizeReference("12F03022600042");
        System.out.println(handler.validateAndFormat(norm2));
    }
}