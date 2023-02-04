import java.util.Scanner;

public class Task__04__Black5 {
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
                if (b != 5) {
                    c = a / b;
                    System.out.println("Quotient: " + c);
                } else {
                    throw new Black5("Divisor Can't be 5 or 0.");
                }
                break;
            } catch (Exception exception) {
                System.out.println("Exception Message: " + exception.getMessage());
                System.out.println("Give Divisible again.");
            }
        }
        input.close();
    }
}

class Black5 extends Exception {
    Black5(String error) {
        super(error);
    }
}