package week9.class_problems;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

abstract class Plot {
    private String owner;
    private String shapeName;

    public Plot(String owner, String shapeName) {
        this.owner = owner;
        this.shapeName = shapeName;
    }

    public String getOwner() { return owner; }
    public String getShapeName() { return shapeName; }

    public abstract double calculateArea();
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            if (shape.equalsIgnoreCase("CIRCLE")) {
                double r = sc.nextDouble();
                plots.add(new CirclePlot(owner, r));
            } else if (shape.equalsIgnoreCase("RECTANGLE")) {
                double l = sc.nextDouble();
                double w = sc.nextDouble();
                plots.add(new RectanglePlot(owner, l, w));
            } else if (shape.equalsIgnoreCase("TRIANGLE")) {
                double b = sc.nextDouble();
                double h = sc.nextDouble();
                plots.add(new TrianglePlot(owner, b, h));
            }
        }

        double totalArea = 0;
        for (Plot p : plots) {
            double area = p.calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f%n", p.getOwner(), p.getShapeName(), area);
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
        sc.close();
    }
}