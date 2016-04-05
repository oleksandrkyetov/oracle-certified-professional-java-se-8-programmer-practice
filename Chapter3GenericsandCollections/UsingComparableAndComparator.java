import java.util.*;

public class UsingComparableAndComparator {

	public static void main(final String[] args) {
		final CanBeCompared one = new CanBeCompared(1, 20);
		final CanBeCompared two = new CanBeCompared(2, 10);

		// Natural ordering
		int oneTwoCompareResult = one.compareTo(two);
		System.out.println("Natural ordering comparator: " + (oneTwoCompareResult == 0 ? "even" : (oneTwoCompareResult > 0 ? "one > two" : "two > one")));

		// Custom comparator
		final Comparator<CanBeCompared> anotherValueComparator = Comparator.comparing(c -> c.getAnotherValue());
		List<CanBeCompared> comparables = Arrays.asList(new CanBeCompared(5, 20), new CanBeCompared(5, 10));

		Collections.sort(comparables, anotherValueComparator);
		System.out.println(comparables);
	}

}

class CanBeCompared implements Comparable<CanBeCompared> {

	private final int value;
	private final int anotherValue;

	public CanBeCompared(int value, int anotherValue) {
		this.value = value;
		this.anotherValue = anotherValue;
	}

	public int getValue() {
		return value;
	}

	public int getAnotherValue() {
		return anotherValue;
	}

	@Override
	public String toString() {
		return "[" + value + "," + anotherValue + "]";
	}

	@Override
	public int compareTo(final CanBeCompared canBeCompared) {
		return this.getValue() - canBeCompared.getValue();
	}

}
