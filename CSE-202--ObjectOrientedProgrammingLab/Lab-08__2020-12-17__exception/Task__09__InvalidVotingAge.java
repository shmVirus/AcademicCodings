import java.util.Scanner;

public class Task__09__InvalidVotingAge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a;
        while (true) {
            System.out.print("Your Age: ");
            a = input.nextInt();
            try {
                if ( a >= 18) {
                    System.out.println("Since " + a + " is your age,\nTherefore, you can give Vote.");
                } else if (a<1){
                    throw new InvalidVotingAge("You need to born first.");
                }
                else {
                    throw new InvalidVotingAge("You must be 18+ to give Vote.");
                }
                break;
            } catch (Exception exception) {
                System.out.println("Exception Message: " + exception.getMessage());
                System.out.println("Try again when you grew up.");
            }
        }
        input.close();
    }
}

class InvalidVotingAge extends Exception {
    InvalidVotingAge(String error) {
        super(error);
    }
}