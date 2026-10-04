package week8.class_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract LocalDate calculateDueDate(LocalDate currentDate);
    public String getTitle() {
        return title;
    }
}

class BookItem extends LibraryItem {
    public BookItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class Problem02_LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();
        sc.nextLine();

        List<LibraryItem> items = new ArrayList<>();
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int spaceIdx = line.indexOf(' ');
            String type = line.substring(0, spaceIdx);
            String rawTitle = line.substring(spaceIdx + 1).trim();
            String title = rawTitle.replace("\"", "");

            if (type.equals("BOOK")) {
                items.add(new BookItem(title));
            } else if (type.equals("DVD")) {
                items.add(new DVDItem(title));
            } else if (type.equals("MAGAZINE")) {
                items.add(new MagazineItem(title));
            }
        }

        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate(currentDate);
            System.out.println(item.getTitle() + ": " + dueDate);
        }
        sc.close();
    }
}