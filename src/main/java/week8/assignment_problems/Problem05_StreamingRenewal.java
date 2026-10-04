package week8.assignment_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class StreamingPlan {
    protected String subscriberName;
    protected LocalDate startDate;

    public StreamingPlan(String subscriberName, LocalDate startDate) {
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public abstract LocalDate calculateRenewalDate();
    public String getSubscriberName() {
        return subscriberName;
    }
}

class BasicPlan extends StreamingPlan {
    public BasicPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends StreamingPlan {
    public StandardPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends StreamingPlan {
    public PremiumPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class Problem05_StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();
        List<StreamingPlan> subscribers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate startDate = LocalDate.parse(dateStr);

            if (type.equals("BASIC")) {
                subscribers.add(new BasicPlan(name, startDate));
            } else if (type.equals("STANDARD")) {
                subscribers.add(new StandardPlan(name, startDate));
            } else if (type.equals("PREMIUM")) {
                subscribers.add(new PremiumPlan(name, startDate));
            }
        }

        for (StreamingPlan plan : subscribers) {
            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.println(plan.getSubscriberName() + ": " + renewalDate);
        }
        sc.close();
    }
}