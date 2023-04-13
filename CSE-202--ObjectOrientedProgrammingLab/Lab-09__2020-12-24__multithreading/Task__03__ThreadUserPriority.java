import java.lang.*;

class Task__03__ThreadUserPriority extends Thread {
	public void run() {
		System.out.println("Inside run method");
	}
	public static void main(String[] args) {
		Task__03__ThreadUserPriority t1 = new Task__03__ThreadUserPriority();
		Task__03__ThreadUserPriority t2 = new Task__03__ThreadUserPriority();
		Task__03__ThreadUserPriority t3 = new Task__03__ThreadUserPriority();
		t1.setPriority(2);
		t2.setPriority(5);
		t3.setPriority(8);
		System.out.println("t1 thread priority : " + t1.getPriority());
		System.out.println("t2 thread priority : " + t2.getPriority());
		System.out.println("t3 thread priority : " + t3.getPriority()); 
	}
}
