package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorImpl {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(208,305,506,602,308);
		Collections.sort(list, (o1, o2) -> {
			return o1%10>o2%10 ? 1:-1;
		});
		System.out.println(list);
		int[] arr = {208,305,506,602,308};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
