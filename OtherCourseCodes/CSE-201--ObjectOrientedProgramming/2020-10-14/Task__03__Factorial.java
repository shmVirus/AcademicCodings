import java.util.Scanner;

public class Task__03__Factorial {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long result = 1, userInput;
		userInput = input.nextLong();
		input.close();
		for (int i=1; i<=userInput; i++) {
			result *= i;
		}
		System.out.println(result);
	}
}