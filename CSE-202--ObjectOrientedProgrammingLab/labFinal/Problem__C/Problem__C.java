import java.util.Scanner;
import ArithmeticPack.*;

public class Problem__C {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        Summation sum = new Summation();
        Subtraction sub = new Subtraction();
        Multiplication mul = new Multiplication();
        Quotient quo = new Quotient();
        Remainder rem = new Remainder();

        int numOne, numTwo;
        System.out.print("First Number: ");
        numOne = input.nextInt();
        System.out.print("Second Number: ");
        numTwo = input.nextInt();
        input.close();
        sum.summation(numOne, numTwo);
        sub.subtraction(numOne, numTwo);
        mul.multiplication(numOne, numTwo);
        quo.quotient(numOne, numTwo);
        rem.remainder(numOne, numTwo);
    }
}