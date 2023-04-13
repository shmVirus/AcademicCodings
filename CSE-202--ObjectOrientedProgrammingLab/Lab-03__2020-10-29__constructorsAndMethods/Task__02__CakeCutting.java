import java.util.Scanner;

public class Task__02__CakeCutting {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        Cutter cutterObject = new Cutter();
        System.out.printf("Pieces: ");
        int cakePieces = input.nextShort();
        input.close();
        System.out.printf("Cutting Number: %d\n", cutterObject.cuttingNumber(cakePieces));
    } 
}
class Cutter{
    int cuttingNumber(int temp) {
        if (temp==1) return 0;
        if (temp%2==0) return temp/2;
        else return (temp/2)+1;
    }
}