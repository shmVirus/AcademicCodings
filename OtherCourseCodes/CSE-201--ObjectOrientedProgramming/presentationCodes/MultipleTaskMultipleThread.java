public class MultipleTaskMultipleThread {
    public static void main(String[] args) {
        SummationThread threadOne = new SummationThread(5, 5);
        MultiplicationThread threadTwo = new MultiplicationThread(5, 5);
        threadOne.start();
        threadTwo.start();
    }
}
class SummationThread extends Thread {
    int sum;
    SummationThread(int numOne, int numTwo) {
        this.sum = numOne + numTwo;
    }
    public void run(){

        System.out.println("Summation: " + sum + " done by first thread");  
    }
}
class MultiplicationThread extends Thread {
    int mul;
    MultiplicationThread(int numOne, int numTwo) {
        this.mul = numOne * numTwo;
    }
    public void run(){
        System.out.println("Multiplication: " + mul + " done by second thread");  
    }
}