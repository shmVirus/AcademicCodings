import java.util.Scanner;

interface Figure {
    
    public double area();
}

class Rectangle implements Figure {
    double dim1, dim2;
    public Rectangle(double a, double b) {
        dim1 = a;
        dim2 = b;
    }
    public double area() {
        return dim1 * dim2;
    }
}

class Triangle implements Figure {
    double dim1, dim2;
    public Triangle(double a, double b) {
        dim1 = a;
        dim2 = b;
    }
    public double area() {
        return (dim1 * dim2) / 2;
    }
}

public class MidAssignmentTwo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Frist Rectangle's Length: ");
        double lengthOne = input.nextDouble();
        System.out.print("First Rectangle's Width: ");
        double widthOne = input.nextDouble();
        Rectangle rectangleOne = new Rectangle(lengthOne, widthOne);
        double rectangleOneArea = rectangleOne.area();
        System.out.println("First Rectangle's Area: " + rectangleOneArea);

        System.out.print("\nSecond Rectangle's Length: ");
        double lengthTwo = input.nextDouble();
        System.out.print("Second Rectangle's Width: ");
        double widthTwo = input.nextDouble();
        Rectangle rectangleTwo = new Rectangle(lengthTwo, widthTwo);
        double rectangleTwoArea = rectangleTwo.area();
        System.out.println("Second Rectangle's Area: " + rectangleTwoArea);

        System.out.print("\nFrist Triangle's Base: ");
        double baseOne = input.nextDouble();
        System.out.print("First Triangle's Height: ");
        double heightOne = input.nextDouble();
        Triangle triangleOne = new Triangle(baseOne, heightOne);
        double triangleOneArea = triangleOne.area();
        System.out.println("First Triangle's Area: " + triangleOneArea);

        System.out.print("\nSecond Triangle's Base: ");
        double baseTwo = input.nextDouble();
        System.out.print("Second Triangle's Height: ");
        double heightTwo = input.nextDouble();
        Triangle triangleTwo = new Triangle(baseOne, baseTwo);
        double triangleTwoArea = triangleTwo.area();
        System.out.println("Second Triangle's Area: " + triangleTwoArea);

        System.out.println("\n");

        if (rectangleOneArea > rectangleTwoArea) {
            System.out.println("First Rectangle is grater than Second Rectangle");
        } else if (rectangleOneArea < rectangleTwoArea) {
            System.out.println("First Rectangle is less than Second Rectangle");
        } else {
            System.out.println("Both Rectangles are Equal");
        }

        if (triangleOneArea > triangleTwoArea) {
            System.out.println("First Triangle is grater than Second Triangle");
        } else if (triangleOneArea < triangleTwoArea) {
            System.out.println("First Triangle is less than Second Triangle");
        } else {
            System.out.println("Both Triangles are Equal");
        }
    }
}