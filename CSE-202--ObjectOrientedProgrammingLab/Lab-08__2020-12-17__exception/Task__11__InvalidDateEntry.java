import java.util.Scanner;

public class Task__11__InvalidDateEntry {

    static void validate(int date, int month, int year) throws InvalidDateEntry {
        if (year < 0) {
            throw new InvalidDateEntry("Invalid Year; bro, it's AD era.");
        }
        if (month < 1 || month > 12) {
            throw new InvalidDateEntry("Invalid Month.");
        }
        if (date >= 1 && date <= 31) {
            if (month == 4 || month == 6 || month == 9 || month == 11 && date == 31) {
                throw new InvalidDateEntry("Invalid Date; this month has 30th as last date.");
            } else if (month == 2 && date >= 29) {
                boolean isLeap = false;
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    isLeap = true;
                }
                if (!isLeap && date == 29) {
                    throw new InvalidDateEntry(
                            "Invalid Date; it's not a Leap year, so this month has 28th as last date.");
                } else {
                    throw new InvalidDateEntry("Invalid Date; this month has 29th as last date.");
                }
            }
        } else {
            throw new InvalidDateEntry("Invalid Date.");
        }
        System.out.println("Your date is Correct!");
        System.out.println("Your Date: " + date + "-" + month + "-" + year);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int date, month, year;
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
                System.out.println("Try again with valid date.");
            }
        }
        input.close();
    }
}

class InvalidDateEntry extends Exception {
    InvalidDateEntry(String error) {
        super(error);
    }
}