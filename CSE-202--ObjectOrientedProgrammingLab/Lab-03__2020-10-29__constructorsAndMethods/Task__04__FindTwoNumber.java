import java.util.Scanner;

public class Task__04__FindTwoNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        NumFinder objectFinder = new NumFinder();
        System.out.print("Summation: ");
        int sum = input.nextInt();
        System.out.print("Difference: ");
        int dif = input.nextInt();
        input.close();
        int X = objectFinder.numTwo(sum, dif);
        System.out.printf("X: %d\n", X);
        System.out.printf("Y: %d\n", sum-X);
    }
}
class NumFinder {
    int numTwo (int tempSum, int tempDif) {
        int X = (tempSum+tempDif)/2;
        return X;
    }
}