package practice;

class Q{
	int num;
	public void put(int num) {
		System.out.println("set : "+ num);
		this.num = num;
	}
	public void get() {
		System.out.println("get : "+ num);
	}
}
class Consumer implements Runnable{
	Q q;
	Consumer(Q q){
		this.q = q;
		Thread t = new Thread(()->{
			for(int i=0;i<10;i++) {
				q.put(i);
			}
		});
	}
	public void run() {
		
	}
}
public class WaitThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
