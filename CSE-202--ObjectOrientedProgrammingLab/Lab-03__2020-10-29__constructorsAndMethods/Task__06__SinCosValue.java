import java.util.Scanner;
import java.lang.Math;

public class Task__06__SinCosValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TrigonValue trigonObject = new TrigonValue();
        System.out.print("X = ");
        int X = input.nextInt();
        input.close();
        trigonObject.cosValue(X);
        trigonObject.sinValue(X);
    }
}
class TrigonValue {
    void sinValue(int temp) {
        double x = Math.toRadians(temp);
        System.out.printf("Sin %d = %.3f\n", temp, Math.sin(x));
    }
    void cosValue(int temp) {
        double x = Math.toRadians(temp);
        System.out.printf("Cos %d = %.3f\n", temp, Math.cos(x));
    }
}