import java.util.Scanner;

public class Task__01__AddMethods {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AdderMethods adderObject = new AdderMethods();
        System.out.print("1st Number for 1st Method: ");
        int a = input.nextInt();
        System.out.print("2nd Number for 1st Method: ");
        int b = input.nextInt();
        System.out.print("1st Number for 2nd Method: ");
        int x = input.nextInt();
        System.out.print("2nd Number for 2nd Method: ");
        int y = input.nextInt();
        System.out.print("3rd Number for 2nd Method: ");
        int z = input.nextInt();
        System.out.print("Size of Array for 3rd Method: ");
        int s = input.nextInt();
        int arr[] = new  int[s];
        for (int i=0; i<s; i++) {
            System.out.print( i+1 +"th Number for 3rd Method: ");
            arr[i] = input.nextInt();
        }
        input.close();
        System.out.println("Summation of 1st Method: " + adderObject.Summation(a,b));
        System.out.println("Summation of 2nd Method: " + adderObject.Summation(x,y,z));
        System.out.println("Summation of 3rd Method: " + adderObject.Summation(arr));
    }
}

class AdderMethods {
    int sum;
    int Summation (int x, int y) {
        sum = x+y;
        return sum;
    }
    int Summation (int x, int y, int z) {
        sum = x+y+z;
        return sum;
    }
    int Summation(int... obj) {
        sum=0;
        for (int x : obj) {
            sum += x;
        }
        return sum;
    }
}