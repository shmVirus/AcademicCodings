import java.lang.*;

class Task__02__ThreadDefaultPriority extends Thread {
	public void run() {
		System.out.println("Inside run method");
	}
	public static void main(String[] args) {
		Task__02__ThreadDefaultPriority t1 = new Task__02__ThreadDefaultPriority();
		Task__02__ThreadDefaultPriority t2 = new Task__02__ThreadDefaultPriority();
		Task__02__ThreadDefaultPriority t3 = new Task__02__ThreadDefaultPriority();
		System.out.println("t1 thread priority : " + t1.getPriority());
		System.out.println("t2 thread priority : " + t2.getPriority());
		System.out.println("t3 thread priority : " + t3.getPriority());
		System.out.println("Main thread priority : " + Thread.currentThread().getPriority());
	}
}