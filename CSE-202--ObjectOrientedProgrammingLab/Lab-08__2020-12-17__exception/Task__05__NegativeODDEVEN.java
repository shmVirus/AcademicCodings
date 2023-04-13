import java.util.Scanner;

public class Task__05__NegativeODDEVEN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a;
        while (true) {
            System.out.print("User Number: ");
            a = input.nextInt();
            try {
                if ( a >= 0) {
                    if (a%2 == 0) System.out.println(a + " is an Even Number");
                    else System.out.println(a + " is an Odd Number");
                } else {
                    throw new NegativeODDEVEN("User Number can't be less than 0.");
                }
                break;
            } catch (Exception exception) {
                System.out.println("Exception Message: " + exception.getMessage());
                System.out.println("Give User Number again.");
            }
        }
        input.close();
    }
}

class NegativeODDEVEN extends Exception {
    NegativeODDEVEN(String error) {
        super(error);
    }
}