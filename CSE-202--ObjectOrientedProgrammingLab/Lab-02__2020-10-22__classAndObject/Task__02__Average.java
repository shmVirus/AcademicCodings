import java.util.Scanner;

public class Task__02__Average {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        Number object = new Number();
        int numOne, numTwo, numThree;
        numOne = input.nextInt();
        numTwo = input.nextInt();
        numThree = input.nextInt();
        input.close();
        System.out.printf("Average: %.2f\n", object.numAvg((float)numOne, (float)numTwo, (float)numThree));
    }
}
class Number {
    float numAvg(float one, float two, float three) {
        return (one+two+three)/3;
    }
}