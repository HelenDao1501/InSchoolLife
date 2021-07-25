package j1.s.P0061;

import java.util.Scanner;

public class Manage {
    Scanner sc = new Scanner(System.in);

    public double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }

    public Triangle inputTriangle() {
        while (true) {
            System.out.print("Please input side A of Triangle: ");
            double a = checkInputDouble();
            System.out.print("Please input side B of Triangle: ");
            double b = checkInputDouble();
            System.out.print("Please input side C of Triangle: ");
            double c = checkInputDouble();
            if (a + b > c && b + c > a && a + c > b) { //BĐT tam giác
                return new Triangle(a, b, c);
            } else {
                System.out.println("Re-input");
            }
        }

    }

    public Rectangle inputRectangle() {
        System.out.print("Please input side width of Rectangle: ");
        double width = checkInputDouble();
        System.out.print("Please input length of Rectangle: ");
        double length = checkInputDouble();
        return new Rectangle(width, length);
    }

    public Circle inputCircle() {
        System.out.print("Please input radius of Circle: ");
        double radius = checkInputDouble();
        return new Circle(radius);
    }

    public void display(Triangle triangle, Rectangle rectangle, Circle circle) {
        System.out.println("-----Rectangle----- ");
        rectangle.printResult();
        System.out.println("-----Circle----- ");
        circle.printResult();
        System.out.println("-----Triangle----- ");
        triangle.printResult();
    }
}
