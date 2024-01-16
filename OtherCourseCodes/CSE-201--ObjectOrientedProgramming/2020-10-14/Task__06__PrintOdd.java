import java.util.Scanner;

public class Task__06__PrintOdd {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		short userInput = input.nextShort();
		input.close();
		for (int i=1; i<=userInput; i=i+2) {
            System.out.println(i);
        }
	}
}