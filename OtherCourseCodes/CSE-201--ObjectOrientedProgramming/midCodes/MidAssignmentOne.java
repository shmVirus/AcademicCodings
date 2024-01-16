import java.util.Scanner;

abstract class Figure {
    protected double dim1, dim2;
    public Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }
    public abstract double area();
    public abstract int compareTo(Figure X);
}

class Rectangle extends Figure {
    public Rectangle(double a, double b) {
        super(a, b);
    }

    @Override
    public double area() {
        return dim1 * dim2;
    }

    @Override
    public int compareTo(Figure X) {
        if ((this.dim1 * this.dim2) > (X.dim1 * X.dim2)) {
            return 1;
        } else if ((this.dim1 * this.dim2) < (X.dim1 * X.dim2)) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Triangle extends Figure {
    public Triangle(double a, double b) {
        super(a, b);
    }

    @Override
    public double area() {
        return (dim1 * dim2) / 2;
    }

    @Override
    public int compareTo(Figure X) {
        if (((this.dim1 * this.dim2) / 2) > ((X.dim1 * X.dim2) / 2)) {
            return 1;
        } else if (((this.dim1 * this.dim2) / 2) < ((X.dim1 * X.dim2) / 2)) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class MidAssignmentOne {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Frist Rectangle's Length: ");
        double lengthOne = input.nextDouble();
        System.out.print("First Rectangle's Width: ");
        double widthOne = input.nextDouble();
        Rectangle rectangleOne = new Rectangle(lengthOne, widthOne);
        System.out.println("First Rectangle's Area: " + rectangleOne.area());

        System.out.print("\nSecond Rectangle's Length: ");
        double lengthTwo = input.nextDouble();
        System.out.print("Second Rectangle's Width: ");
        double widthTwo = input.nextDouble();
        Rectangle rectangleTwo = new Rectangle(lengthTwo, widthTwo);
        System.out.println("Second Rectangle's Area: " + rectangleTwo.area());

        System.out.print("\nFrist Triangle's Base: ");
        double baseOne = input.nextDouble();
        System.out.print("First Triangle's Height: ");
        double heightOne = input.nextDouble();
        Triangle triangleOne = new Triangle(baseOne, heightOne);
        System.out.println("First Triangle's Area: " + triangleOne.area());

        System.out.print("\nSecond Triangle's Base: ");
        double baseTwo = input.nextDouble();
        System.out.print("Second Triangle's Height: ");
        double heightTwo = input.nextDouble();
        Triangle triangleTwo = new Triangle(baseOne, baseTwo);
        System.out.println("Second Triangle's Area: " + triangleTwo.area());

        System.out.println("\n");

        int rectangleCompare = rectangleOne.compareTo(rectangleTwo);
        if (rectangleCompare > 0) {
            System.out.println("First Rectangle is grater than Second Rectangle");
        } else if (rectangleCompare < 0) {
            System.out.println("First Rectangle is less than Second Rectangle");
        } else {
            System.out.println("Both Rectangles are Equal");
        }

        int triangleCompare = triangleOne.compareTo(triangleTwo);
        if (triangleCompare > 0) {
            System.out.println("First Triangle is grater than Second Triangle");
        } else if (triangleCompare < 0) {
            System.out.println("First Triangle is less than Second Triangle");
        } else {
            System.out.println("Both Triangles are Equal");
        }
    }
}