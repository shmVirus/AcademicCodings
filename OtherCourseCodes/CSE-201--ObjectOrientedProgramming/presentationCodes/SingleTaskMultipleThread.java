public class SingleTaskMultipleThread {
    public static void main(String[] args) {
        SingleTask threadOne = new SingleTask("first");
        SingleTask threadTwo = new SingleTask("second");
        SingleTask threadThree = new SingleTask("third");
        Thread t1 = new Thread(threadOne);
        Thread t2 = new Thread(threadTwo);
        Thread t3 = new Thread(threadThree);
        t1.start();
        t2.start();
        t3.start();
    }
}
class SingleTask implements Runnable {
    String threadName;
    SingleTask(String name) {
        this.threadName = name;
    }
    public void run(){
        System.out.println("Hi, I am only task running by " + threadName + " Thread");
    }
}