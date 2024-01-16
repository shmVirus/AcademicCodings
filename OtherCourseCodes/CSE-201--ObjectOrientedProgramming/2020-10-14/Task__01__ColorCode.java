import java.util.Scanner;
// ColorGame coded by @shmVirus__193002069
public class Task__01__ColorCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ColorCodeUsingString objectString = new ColorCodeUsingString();
        ColorCodeUsingNumber objectNumber = new ColorCodeUsingNumber();
        System.out.printf("Play ColorCodeGame with:\n1. Using String\n2. Using Number\n");
        System.out.print("Your Choice: ");
        byte userChoice = input.nextByte();
        System.out.println("RGB");
        if (userChoice==1) {
            String userString = input.nextLine();
            System.out.print("Combined Color: ");
            objectString.usingString(userString);
        }
        else if (userChoice==2) {
            byte userNumber = input.nextByte();
            System.out.print("Combined Color: ");
            objectNumber.usingNumber(userNumber);
        }
        input.close();
    }
}

class ColorCodeUsingString {
    void usingString (String userString) {
        switch (userString) {
            case "000":
                System.out.println("Black");
                break;
            case "001":
                System.out.println("Blue");
                break;
            case "010":
                System.out.println("Green");
                break;
            case "100":
                System.out.println("Red");
                break;
            case "110":
                System.out.println("Yellow");
                break;
            case "101":
                System.out.println("Magenta");
                break;
            case "011":
                System.out.println("Cayan");
                break;
            case "111":
                System.out.println("White");
        }
    }
}

class ColorCodeUsingNumber {
    void usingNumber (short userNumber) {
        switch (userNumber) {
            case 0:
                System.out.println("Black");
                break;
            case 1:
                System.out.println("Blue");
                break;
            case 10:
                System.out.println("Green");
                break;
            case 11:
                System.out.println("Cyan");
                break;
            case 100:
                System.out.println("Red");
                break;
            case 101:
                    System.out.println("Magenta");
                break;
            case 110:
                    System.out.println("Yellow");
                break;
            case 111:
                System.out.println("White");
                break;
        }
    }
}