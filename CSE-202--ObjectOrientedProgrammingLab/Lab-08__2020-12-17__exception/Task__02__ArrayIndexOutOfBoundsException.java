import java.util.Scanner;

public class Task__02__ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Array Size: ");
        int arraySize = input.nextInt();
        int array[] = new int[arraySize];
        while (true) {
            System.out.print("Number of Elements: ");
            int elementNumber = input.nextInt();
            try {
                for (int i = 0; i < elementNumber; i++) {
                    array[i] = input.nextInt();
                }
                break;
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Exception Message: " + exception.getMessage());
                System.out.println("Number of Element can't be Greater than Array Size.");
            }
        }
        input.close();
    }
}