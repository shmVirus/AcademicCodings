import java.util.Scanner; 

public class Task__06__CircleSquare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Circle objectCircle = new Circle();
        Square objectSquare = new Square();
        double length = input.nextDouble();
        input.close();
        System.out.printf("Free Space: %.2f\n", objectSquare.squareArea(length)-objectCircle.circleArea(length));
    }
}

class Circle {
    double circleArea(double temp) {
        return (temp/2)*(temp/2)*3.1415;
    }
}

class Square {
    double squareArea(double temp) {
        return temp*temp;
    }
}