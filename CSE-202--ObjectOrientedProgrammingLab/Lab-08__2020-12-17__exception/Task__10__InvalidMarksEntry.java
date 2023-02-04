import java.util.Scanner;

public class Task__10__InvalidMarksEntry {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int studentMarks;
        while (true) {
            System.out.print("Your Marks: ");
            studentMarks = input.nextInt();
            try {
                if (studentMarks > 100 || studentMarks < 0) {
                    throw new InvalidMarksEntry("Your marks should be in between 0 to 100.");
                } else {
                    System.out.print("Your Grade: ");
                    switch (studentMarks / 10) {
                        case 10:
                            System.out.println("A+");
                            break;
                        case 9:
                            System.out.println("A+");
                            break;
                        case 8:
                            System.out.println("A+");
                            break;
                        case 7:
                            if (studentMarks >= 75) System.out.println("A");
                            else System.out.println("A-");
                            break;
                        case 6:
                            if (studentMarks >= 65) System.out.println("B+");
                            else System.out.println("B");
                            break;
                        case 5:
                            if (studentMarks >= 55) System.out.println("B-");
                            else System.out.println("C+");
                            break;
                        case 4:
                            if (studentMarks >= 45) System.out.println("C");
                            else System.out.println("D");
                            break;
                        default:
                            System.out.println("F");
                    }
                }
                break;
            } catch (Exception exception) {
                System.out.println("Exception Message: " + exception.getMessage());
                System.out.println("Try again with valid marks.");
            }
        }
        input.close();
    }
}

class InvalidMarksEntry extends Exception {
    InvalidMarksEntry(String error) {
        super(error);
    }
}