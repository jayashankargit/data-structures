package practice;

class Counter{
	int count;
	public synchronized void increment() {
		count++;
	}
}
public class SynchronisedThread {

	public static void main(String[] args) throws Exception{
		Counter c = new Counter();
		Thread t1 = new Thread(() -> {
			for(int i=1;i<=1000;i++) {
				c.increment();
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i=1;i<=1000;i++) {
				c.increment();
			}
		});
		t1.start();
		Thread.sleep(10);
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("count value: "+c.count);

	}

}
