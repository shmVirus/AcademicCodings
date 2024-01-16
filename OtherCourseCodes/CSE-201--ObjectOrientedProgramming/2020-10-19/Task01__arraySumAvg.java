import java.util.Scanner;

public class Task01__arraySumAvg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        short arraySize; float sum=0;
        arraySize = input.nextShort();
        float[] arrayStorage = new float[arraySize];
        for (int i=0; i<arraySize; i++) {
            arrayStorage[i] = input.nextFloat();
            sum += arrayStorage[i];
        }
        input.close();
        System.out.printf("Summation = %.2f\nAverage = %.2f\n", sum, sum/arraySize);
	}
}