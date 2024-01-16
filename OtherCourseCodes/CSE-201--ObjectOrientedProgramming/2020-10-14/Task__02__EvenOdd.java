import java.util.Scanner;

public class Task__02__EvenOdd {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		short userInput = input.nextShort();
		input.close();
		if (userInput%2 == 0) {
			if (userInput == 0) System.out.println("Neutral");
			else System.out.println("Even");
		}
		else System.out.println("Odd");
	}
}