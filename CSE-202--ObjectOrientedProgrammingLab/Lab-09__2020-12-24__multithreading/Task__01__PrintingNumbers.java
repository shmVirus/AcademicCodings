import java.util.Scanner;

class firstThread extends Thread {
    String threadName;
    int temp;
    firstThread(String name, int number) {
        this.threadName = name;;
        this.temp = number;
    }
    public void run() {
        try {
            for (int i=1; i<=temp/2; i++) {
                System.out.println(threadName + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException exception) {
            System.out.println(threadName + "Interrupted.");
        }
        System.out.println(threadName + " exiting.");
    }
}

class secondThread extends Thread {
    String threadName;
    int temp;
    secondThread(String name, int number) {
        this.threadName = name;;
        this.temp = number;
    }
    public void run() {
        try {
            for (int i=(temp/2+1); i<=temp; i++) {
                System.out.println(threadName + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException exception) {
            System.out.println(threadName + "Interrupted.");
        }
        System.out.println(threadName + " exiting.");
    }
}

public class Task__01__PrintingNumbers {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number: ");
        int number = input.nextInt();
        input.close();
        firstThread first = new firstThread("First", number);
        secondThread second = new secondThread("Second", number);
        first.start();
        second.start();
        try {
            Thread.sleep(((number*1000)/2)+2000);
        } catch (InterruptedException exception) {
            System.out.println("Main thread Interrupted.");
        } finally {
            System.out.println("Main thread exiting.");
        }
    }
}