public class ToStingEqualsHashCode {

	public final String string;
	public final int integer;

	public ToStingEqualsHashCode(final String string, final int integer) {
		this.string = string;
		this.integer = integer;
	}

	/**
	 * String representation of the object
	 */
	@Override
	public String toString() {
		return "[" + string + " " + integer + "]";
	}

	/**
	 * Uses  object fields
	 */
	@Override
	public boolean equals(final Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ToStingEqualsHashCode)) {
			return false;
		}

		final ToStingEqualsHashCode toStingEqualsHashCode = (ToStingEqualsHashCode) object;

		return this.string.equals(toStingEqualsHashCode.string) 
				&& this.integer == toStingEqualsHashCode.integer;
	}

	/**
	 * Uses subset of object fields used in equals
	 */
	@Override
	public int hashCode() {
		return 7 * integer;
	}

	public static void main(final String... args) {
		final ToStingEqualsHashCode toStingEqualsHashCodeOne = new ToStingEqualsHashCode("one", 1);
		final ToStingEqualsHashCode toStingEqualsHashCodeOneEqualFirst = new ToStingEqualsHashCode("one", 1);
		final ToStingEqualsHashCode toStingEqualsHashCodeOneEqualSecond = new ToStingEqualsHashCode("one", 1);

		System.out.println("Reflexive: " + toStingEqualsHashCodeOne.equals(toStingEqualsHashCodeOne));
		System.out.println("Symmetric: " + (toStingEqualsHashCodeOne.equals(toStingEqualsHashCodeOneEqualFirst)
				&& toStingEqualsHashCodeOneEqualFirst.equals(toStingEqualsHashCodeOne)));
		System.out.println("Transitive: " + (toStingEqualsHashCodeOne.equals(toStingEqualsHashCodeOneEqualFirst)
				&& toStingEqualsHashCodeOneEqualFirst.equals(toStingEqualsHashCodeOneEqualSecond)
				&& toStingEqualsHashCodeOne.equals(toStingEqualsHashCodeOneEqualSecond)));
		System.out.println("Consistent: " + toStingEqualsHashCodeOne.equals(toStingEqualsHashCodeOneEqualFirst));
		System.out.println(".equals(null) return false: " + toStingEqualsHashCodeOne.equals(null));
	}

}
