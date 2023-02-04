public class Task__Part1__Multiplication {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Multiplication ob1 = new Multiplication(5);
        ob1.diplay();
        Multiplication ob2 = new Multiplication(5, 5);
        ob2.diplay();
        Multiplication ob3 = new Multiplication(5, 5, 5);
        ob3.diplay();
        Multiplication ob4 = new Multiplication(arr);
        ob4.diplay();
    }
}

class Multiplication {
    int res;

    Multiplication (int x) {
        res = x;
    }
    Multiplication (int x, int y) {
        res = x*y;
    }
    Multiplication (int x, int y, int z) {
        res = x*y*z;
    }
    Multiplication(int... obj) {
        res = 1;
        for (int x : obj) {
            res *= x;
        }
    }
    void diplay() {
        System.out.println("Multiplication: " + res);
    }
}