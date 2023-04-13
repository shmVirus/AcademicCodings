import java.util.Scanner;

class FactorialThread implements Runnable {
    int number;
    Thread thread;

    FactorialThread(int n) {
        number = n;
        thread = new Thread(number);
        System.out.println("New thread: " + thread);
        thread.start();
    }

    public void run() {
        int fact=1;
        try {
            for (int j=1; j<=number; j++) {
                fact *= j;
            }
            System.out.println("Factorial: " + fact + " of " + number + "using " + number + "th Thread.");

        } catch (InterruptedException exception) {
            System.out.println(number + "Interrupted.");
        }
        System.out.println(number + " exiting.");
    }
}

public class Task__02__Factorial {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number: ");
        int number = input.nextInt();
        for (int i=1; i<=number; i++) {
            new FactorialThread(i);
        }
        try {
            Thread.sleep(7000);
        } catch (InterruptedException exception) {
            System.out.println("Main thread Interrupted.");
        } finally {
            System.out.println("Main thread exiting.");
        }
        input.close();
    }
}