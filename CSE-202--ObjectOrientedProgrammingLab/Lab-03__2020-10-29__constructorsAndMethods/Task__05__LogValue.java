import java.util.Scanner;
import java.lang.Math;

public class Task__05__LogValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LogValue finderObject = new LogValue();
        System.out.print("X = ");
        int X = input.nextInt();
        input.close();
        finderObject.calculator((float)X);
    }
}

class LogValue {
    void calculator(float x) {
        System.out.printf("log %d = %.3f\n", (int)x, Math.log10(x));
    }
}