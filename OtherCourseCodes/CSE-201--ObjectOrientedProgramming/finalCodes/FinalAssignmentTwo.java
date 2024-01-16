import java.util.Scanner;
public class FinalAssignmentTwo extends Exception {
    FinalAssignmentTwo(String error) {
        super(error);
    }

    static void validate(int date, int month, int year) throws FinalAssignmentTwo {
        if (year < 0) throw new FinalAssignmentTwo("Invalid Year; bro, it's AD era.");
        if (month < 1 || month > 12) throw new FinalAssignmentTwo("Invalid Month.");
        if (date < 1 || date > 31) throw new FinalAssignmentTwo("Invalid Date.");
        else {
            if (month == 4 || month == 6 || month == 9 || month == 11 && date == 31) {
                throw new FinalAssignmentTwo("Invalid Date; this Month has 30th as last Date.");
            } else if (month == 2 && date >= 29) {
                boolean isLeap = false;
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) isLeap = true;
                if (!isLeap && date >= 29) {
                    throw new FinalAssignmentTwo(
                    "Invalid Date; it's not a Leap Year, so this Month has 28th as last Date.");
                } else {
                    throw new FinalAssignmentTwo(
                    "Invalid Date; this Month has 29th as last Date.");
                }
            }
        }
        System.out.println("Your Date is Correct!");
        System.out.println("Your Date: " + date + "-" + month + "-" + year);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int date, month, year;
        System.out.println("\nThis program can Validate any Date from AD era.");
        System.out.println("But, all of the inputs should be in Numberic format.");
        System.out.println("For Example; 1st December, 2021 -> 1-12-2020 or 01-12-2020.");
        while (true) {
            System.out.print("Date: ");
            date = input.nextInt();
            System.out.print("Month: ");
            month = input.nextInt();
            System.out.print("Year: ");
            year = input.nextInt();
            try {
                validate(date, month, year);
                break;
            } catch (Exception exception) {
                System.out.println("Exception Message: " + exception.getMessage());
                System.out.println("Try again with valid Date.");
            }
        }
        input.close();
    }
}