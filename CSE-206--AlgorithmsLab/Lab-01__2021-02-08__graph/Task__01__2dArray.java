import java.util.Scanner;
import java.util.Arrays;
public class Task__01__2dArray {
    public static void main(String[] args) {
        new Graph ();
    }
}
class Graph {
    Scanner input = new Scanner (System.in);
    int size;
    int matrix[][];
    Graph() {
        System.out.printf("Enter Size: ");
        this.size = input.nextInt();
        this.matrix = new int[size][size];
        graphInput();
        graphPrint();
    }
    void graphInput() {
        for (int r=0; r<size; r++) {
            for (int c=0; c<size; c++) {
                matrix[r][c] = input.nextInt();
            }
        }
    }
    void graphPrint() {
        System.out.println("AdjacencyMatrix: ");
        for (int r=0; r<size; r++) {
            for (int c=0; c<size; c++) {
                System.out.printf("%d", matrix[r][c]);
                if (c+1 == size) {
                    System.out.println();
                }
                else {
                    System.out.printf(" ");
                }
            }
        }
    }
}