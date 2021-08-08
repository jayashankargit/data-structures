package practice;
public class ThreadDemoInterface {

	public static void main(String[] args) throws Exception{
		
		Thread t1 = new Thread(()->{
			for(int i=0;i<5;i++) {
				System.out.println("hi");
				try{Thread.sleep(500);}catch(Exception e) {};
			}
		}, "Hi Thread");
		Thread t2 = new Thread(()->{
			for(int i=0;i<5;i++) {
				System.out.println("hello");
				try{Thread.sleep(500);}catch(Exception e) {};
			}
		}, "Hello Thread") ;
		t1.start();
		try{Thread.sleep(10);}catch(Exception e) {};
		t2.start();
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		System.out.println("is t1 alive:"+t1.isAlive());
		t1.join();
		t2.join();
		
		System.out.println("is t1 alive:"+t1.isAlive());
		System.out.println("bye");

	}

}
