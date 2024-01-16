class MyThread implements Runnable {
    String threadName;
    Thread thread;
    MyThread(String name) {
        threadName = name;
        thread = new Thread(this, threadName);
        System.out.println("New thread: " + thread);
        thread.start();
    }
    public void run() {
        try {
            for (int i=5; i>0; i--) {
                System.out.println(threadName + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException exception) {
            System.out.println(threadName + "Interrupted.");
        }
        System.out.println(threadName + " exiting.");
    }
}
class MultiThreading {
    public static void main(String args[]) {
        new MyThread("One");
        new MyThread("Two");
        new MyThread("Three");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            System.out.println("Main thread Interrupted.");
        }
        finally {
            System.out.println("Main thread exiting.");
        }
    }
}