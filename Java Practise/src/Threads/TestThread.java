package Threads;

public class TestThread implements Runnable{

	public TestThread(String string) {
		Thread t;
		
	}

	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			TestThread t1=new TestThread(String.valueOf(i));
			t1.
		}
		
	}
	
	@Override
	public void run() {
		System.out.println("Running the thread..");
	}
}
