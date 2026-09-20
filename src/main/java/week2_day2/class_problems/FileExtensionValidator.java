package strings.class_problems;

public class FileExtensionValidator {

    public String validateFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "Rejected — invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(lastDotIndex + 1);
        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        FileExtensionValidator validator = new FileExtensionValidator();
        System.out.println(validator.validateFileExtension("Assignment1.PDF"));
        System.out.println(validator.validateFileExtension("notes.txt"));
    }
}