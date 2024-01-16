import java.util.Scanner;

public class Task02_arrayLargest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        short arraySize;
        arraySize = input.nextShort();
        float[] arrayStorage = new float[arraySize];
        float largest=arrayStorage[0], largestIndex=0;
        for (int i=0; i<arraySize; i++) {
            arrayStorage[i] = input.nextFloat();
        }
        input.close();
        for (int i=0; i<arraySize; i++) {
            if (arrayStorage[i] > largest) {
                largest = arrayStorage[i];
                largestIndex = i;
            }
        }
        largestIndex++;
        System.out.printf("%.2f is the Largest Number at %.0f Position.\n", largest, largestIndex);
	}
}