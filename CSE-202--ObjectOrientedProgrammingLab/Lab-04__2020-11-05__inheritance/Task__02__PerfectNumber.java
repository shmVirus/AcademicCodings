import java.util.Scanner;

public class Task__02__PerfectNumber {
    public static void main(String[] args) {
        Perfect object = new Perfect();
        object.findPerfect();
    }
}

class Number {
    boolean isPerfect = false;
    void checkPerfect(int inputNumber) {
        int sum = 0;
        for (int i=1; i<inputNumber; i++) {
            if (inputNumber%i == 0) {
                sum += i;
            }
        }
        if (sum == inputNumber) {
            isPerfect = true;
        }
    }
}

class Perfect extends Number {
    void findPerfect() {
        Scanner input = new Scanner(System.in);
        System.out.print("Number: ");
        int inputNumber = input.nextInt();
        input.close();
        checkPerfect(inputNumber);
        if (isPerfect) {
            System.out.println(inputNumber + " is a Perfect Number");
        } else {
            System.out.println(inputNumber + " is not a Perfect Number");
        }
    }
}