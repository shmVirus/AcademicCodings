import java.io.*;
import java.util.*;

public class Task__02__2dMatrixFile {
    int size;
    int matrix[][];

    Task__02__2dMatrixFile() {
        fileRead();
        fileWrite();
    }

    void fileRead() {
        try {
            Scanner input = new Scanner(new File("inputMatrix.txt"));
            size = input.nextInt();
            matrix = new int[size][size];
            for (int r=0; r<size; r++) {
                for (int c=0; c<size; c++) {
                    matrix[r][c] = input.nextInt();
                }
            }
            input.close();
        } catch (IOException inputException) {
        } finally {
            System.out.println("File Read done Successfully!");
        }
    }

    void fileWrite() {
        try {
            FileWriter output = new FileWriter("outputMatrix.txt");
            for (int r=0; r<size; r++) {
                for (int c=0; c<size; c++) {
                    output.write(Integer.toString(matrix[r][c]));
                    if (c+1 == size) output.write("\n");
                    else output.write(" ");
                }
            }
            output.close();
        } catch (IOException outputException) {
        } finally {
            System.out.println("File Write done Successfully!");
        }
    }

    public static void main(String[] args) {
        new Task__02__2dMatrixFile();
    }
}