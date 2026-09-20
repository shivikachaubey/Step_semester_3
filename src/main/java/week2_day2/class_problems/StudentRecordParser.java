package strings.class_problems;

public class StudentRecordParser {

    public void parseStudentRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] parts = csvLine.split(",");
        if (parts.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = parts[0].trim();
        String rollNo = parts[1].trim();
        String dept = parts[2].trim();

        if (name.isEmpty() || rollNo.isEmpty() || dept.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
    }

    public static void main(String[] args) {
        StudentRecordParser parser = new StudentRecordParser();
        parser.parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parser.parseStudentRecord("Ananya Verma,CSE");
    }
}