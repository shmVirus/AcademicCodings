import java.util.Scanner;

public class Task__01__ArithmeticException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b, c;
        System.out.println("Divisible and Divisor must be Integer.");
        System.out.print("Divisible: ");
        a = input.nextInt();
        while (true) {
            System.out.print("Divisor: ");
            b = input.nextInt();
            try {
                c = a / b;
                System.out.println("Quotient: " + c);
                break;
            } catch (ArithmeticException exception) {
                System.out.println("Exception Message: " + exception.getMessage());
                System.out.println("Give Divisible again.");
            }
        }
        input.close();
    }
}