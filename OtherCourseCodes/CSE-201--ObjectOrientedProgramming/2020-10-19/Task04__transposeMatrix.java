import java.util.Scanner;

public class Task04__transposeMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        short matrixSize;
        matrixSize = input.nextShort();
        short[][] userMatrix = new short[matrixSize][matrixSize];
        short[][] transposeMatrix = new short[matrixSize][matrixSize];
        for (int i=0; i<matrixSize; i++) {
            for (int j=0; j<matrixSize; j++) {
                userMatrix[i][j] = input.nextShort();
            }
        }
        input.close();
        for (int i=0; i<matrixSize; i++) {
            for (int j=0; j<matrixSize; j++) {
                transposeMatrix[j][i] = userMatrix[i][j];
            }
        }
        for (int i=0; i<matrixSize; i++) {
            for (int j=0; j<matrixSize; j++) {
                System.out.printf("%d",transposeMatrix[i][j]);
                if (j+1!=matrixSize) System.out.print(" ");
                else System.out.println();
            }
        }
	}
}