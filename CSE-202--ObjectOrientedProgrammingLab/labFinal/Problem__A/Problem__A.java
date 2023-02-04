import java.util.Scanner;

abstract class GeometricObject {
    protected double dim1, dim2;
    public GeometricObject(double a, double b) {
        dim1 = a;
        dim2 = b;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Circle extends GeometricObject {
    public Circle(double a, double b) {
        super(a, b);
    }

    @Override
    public double getArea() {
        return dim1*dim2*dim2;
    }

    @Override
    public double getPerimeter() {
        return 2*dim1*dim2;
    }
}

class Rectangle extends GeometricObject {
    public Rectangle(double a, double b) {
        super(a, b);
    }

    @Override
    public double getArea() {
        return dim1 * dim2;
    }

    @Override
    public double getPerimeter() {
        return (2*(dim1 + dim2));
    }
}

public class Problem__A {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Circle's Radius: ");
        double radius = input.nextDouble();
        Circle circleObject = new Circle(3.1416, radius);
        System.out.println("Circle's Perimeter: " + circleObject.getPerimeter());
        double circleArea = circleObject.getArea();
        System.out.println("Circle's Area: " + circleArea);

        System.out.print("Rectangle's Length: ");
        double length = input.nextDouble();
        System.out.print("Rectangle's Width: ");
        double width = input.nextDouble();
        Rectangle rectangleObject = new Rectangle(length, width);
        System.out.println("Rectangle's Perimeter: " + rectangleObject.getPerimeter());
        double rectArea = rectangleObject.getArea();
        System.out.println("Rectangle's Area: " + rectArea);

        if (circleArea > rectArea) {
            System.out.println("Circle's area is Greater than Rectangle's area");
        } else if (circleArea < rectArea) {
            System.out.println("Rectangle's area is Greater than Circle's area");
        } else {
            System.out.println("Both Circle's and Rectangle's area are Equal");
        }
    }
}