import java.util.Scanner;

public class Task__Part2__SimpleInheritance {
    public static void main(String[] args) {
        Rect rectObject = new Rect();
        Square squareObject = new Square();
        squareObject.squareArea();
        rectObject.rectArea();
    }
}

class Box {
    int area;
    int calulateArea(int x, int y) {
        area = x * y;
        return area;
    }
}

class Rect extends Box {
    void rectArea() {
        Scanner input = new Scanner(System.in);
        System.out.print("Rectangale Length: ");
        int userLength = input.nextInt();
        System.out.print("Rectangale Width: ");
        int userWidth = input.nextInt();
        System.out.println("Rectangular Area: " + calulateArea(userLength, userWidth));
        input.close();
    }
}
class Square extends Box {
    void squareArea() {
        Scanner input = new Scanner(System.in);
        System.out.print("Square Length: ");
        int userLength = input.nextInt();
        System.out.println("Square Area: " + calulateArea(userLength, userLength));
    }
}