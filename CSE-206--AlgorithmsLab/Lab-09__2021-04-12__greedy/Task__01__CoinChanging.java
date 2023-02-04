import java.util.Scanner;

public class Task__01__CoinChanging {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int notes[] = { 10, 5, 2, 1 };
        System.out.print("Amount: ");
        double amount = input.nextDouble();
        int totalNotes = 0;
        input.close();
        int i = 0;
        while (amount > 0) {
            int note = (int) amount / notes[i];
            amount -= note * notes[i];
            totalNotes += note;
            i++;
        }
        System.out.println("Total Notes: " + totalNotes);
    }
}