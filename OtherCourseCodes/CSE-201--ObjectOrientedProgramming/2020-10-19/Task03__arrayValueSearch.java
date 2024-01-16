import java.util.Scanner;

public class Task03__arrayValueSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        short arraySize, searchValue;
        arraySize = input.nextShort();
        short[] arrayStorage = new short[arraySize];
        for (int i=0; i<arraySize; i++) {
            arrayStorage[i] = input.nextShort();
        }
        searchValue = input.nextShort();
        input.close();
        for (int i=0; i<arraySize; i++) {
            if (arrayStorage[i] == searchValue) {
                System.out.printf("%d Found at %d Position\n", searchValue, i+1);
                break;
            }
        }
	}
}