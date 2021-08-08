package practice.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableImpl {

	public static void main(String[] args) {
		List<Laptop> lapList = new ArrayList<Laptop>();
		lapList.add(new Laptop("Dell", 8, 1000));
		lapList.add(new Laptop("Apple", 16, 1500));
		lapList.add(new Laptop("Acer", 12, 1000));
		Collections.sort(lapList);
		System.out.println(lapList);
		
		//using comparator we can sort list
		Comparator<Laptop> comparator = new ComparatorImpl();
		Collections.sort(lapList, comparator);
		System.out.println(lapList);
		System.out.println(5+6+"s");
		
		String s1 = "abc";
        String s2 = "def";
        String s3 = s2;   /* Line 7 */
        s2 = "ghi";
        System.out.println(s1 + s2 + s3);
	}

}
