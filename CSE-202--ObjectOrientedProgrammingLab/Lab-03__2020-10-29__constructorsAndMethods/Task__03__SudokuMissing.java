import java.util.Scanner;

public class Task__03__SudokuMissing {
    public static void main(String[] args) {
        Sudoku sudokuObject = new Sudoku();
        System.out.printf("Missing Number: %d\n", sudokuObject.missingNumber());
    }
}
class Sudoku {
    byte missingNumber() {
        Scanner input = new Scanner (System.in);
        byte sum=0;
        for (byte i=0; i<8; i++) {
            System.out.printf("Number %d: ", i+1);
            byte sudokuNumber = input.nextByte();
            sum += sudokuNumber;
        }
        input.close();
        int ans = 45 - sum;
        return (byte)ans;
    }
}