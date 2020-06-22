package practice;

class Box<T>{
	private T t;
	public void set(T t) {
		this.t = t;
	}
	public T get() {
		return t;
	}
}
public class Generics {

	public static void main(String[] args) {
		Box<Integer> box = new Box<Integer>();
		box.set(5);
		System.out.println(box.get());
		Box<String> boxString = new Box<String>();
		boxString.set("good");
		System.out.println(boxString.get());
	}

}
