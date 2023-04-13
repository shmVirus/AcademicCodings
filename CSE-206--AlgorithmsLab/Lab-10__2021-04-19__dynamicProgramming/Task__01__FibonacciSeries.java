import java.util.Scanner;

class Task__01__FibonacciSeries {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Size: ");
        int size = input.nextInt();
        long F[] = new long[size];
        F[0] = 0;
        F[1] = 1;
        System.out.print(F[0] + " "+ F[1] + " ");
        for (int i=2; i<size; i++) {
            F[i] = F[i-1]+F[i-2];
            System.out.print(F[i]);
            if (i+1 == size) System.out.println();
            else System.out.print(" ");
        }
        input.close();
    }
}