import java.util.Scanner;

public class Task__03__nCr_nPr {
    public static void main(String[] args) {
        ParmutationCombination object = new ParmutationCombination();
        object.calculator();
        
    }
}

class Factorial {
    int findFactorial(int inputNumber) {
        int fact = 1;
        for (int i=1; i<=inputNumber; i++) {
            fact *= i;
        }
        return fact;
    }
}

class ParmutationCombination extends Factorial {
    void calculator() {
        Scanner input = new Scanner(System.in);
        System.out.print("n: ");
        int n = input.nextInt();
        System.out.print("r: ");
        int r = input.nextInt();
        input.close();
        int nFact = findFactorial(n);
        int rFact = findFactorial(r);
        int difFact = findFactorial(n-r);
        System.out.println("Permutation: "+ (nFact/difFact));
        System.out.println("Combination: "+ (nFact/(rFact*difFact)));
    }
}