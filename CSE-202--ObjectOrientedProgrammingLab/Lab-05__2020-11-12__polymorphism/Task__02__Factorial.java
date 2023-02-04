import java.util.Scanner;

public class Task__02__Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Factorial factorialObject = new Factorial();
        System.out.print("X: ");
        int x = input.nextInt();
        input.close();
        System.out.println("Factorial: " + factorialObject.factorial(x));
    }
}

class Recursion {
    int factorial(int temp) {
        if (temp == 0) return 1;
        return temp*factorial(temp-1);
    }
}
class Factorial extends Recursion {
    @Override
    int factorial(int temp) {
        int fact = 1;
        for (int i=1; i<=temp; i++) {
            fact *= i;
        }
        return fact;
    }
}