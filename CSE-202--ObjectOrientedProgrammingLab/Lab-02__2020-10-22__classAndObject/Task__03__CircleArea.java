import java.util.Scanner;

public class Task__03__CircleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Circle object = new Circle();
        System.out.print("Radius: ");
        double radius = input.nextDouble();
        input.close();
        System.out.printf("Area: %.2f\n", object.calculator(radius));
    }
}
class Circle {
    double calculator(double temp) {
        double area = (temp*temp)*3.1415;
        return area;
    }
}