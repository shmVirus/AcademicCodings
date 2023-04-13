import java.util.Scanner;

public class Task__01__LeapYear {
    public static void main(String[] args) {
        Leap object = new Leap();
        object.findLeap();
    }
}

class Year {
    boolean isLeap = false;
    void checkLeap(short inputYear) {
        if (inputYear % 4 == 0 && inputYear % 100 != 0 || inputYear % 400 == 0) {
            isLeap = true;
        }
    }
}

class Leap extends Year {
    void findLeap() {
        Scanner input = new Scanner(System.in);
        System.out.print("Year: ");
        short inputYear = input.nextShort();
        input.close();
        checkLeap(inputYear);
        if (isLeap) {
            System.out.println(inputYear + " is a Leap Year");
        } else {
            System.out.println(inputYear + " is not a Leap Year");
        }
    }
}