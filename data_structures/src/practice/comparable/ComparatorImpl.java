package practice.comparable;

import java.util.Comparator;

public class ComparatorImpl implements Comparator<Laptop>{

	@Override
	public int compare(Laptop o1, Laptop o2) {
		return Comparator.comparing(Laptop::getPrice).thenComparing(Laptop::getBrand)
				.compare(o1, o2);
	}

}
