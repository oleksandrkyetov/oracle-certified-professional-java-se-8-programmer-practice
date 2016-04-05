import java.io.*;
import java.util.*;

public class GenericBounds {

	public static void main(final String[] args) {
		final List<? super IOException> exceptions = new ArrayList<>();

		// Exception does not work, because technically Java cannot be sure what we put in the list, but it is certain that it is IOException or it subclass
		//exceptions.add(new Exception()); // Compile error

		// For the rest everything is okay
		exceptions.add(new IOException());
		exceptions.add(new FileNotFoundException());

		printUpperBound(exceptions);

		final List<? super Two> twos = new ArrayList<>();
		twos.add(new Two());
		printLowerBound(twos);
	}

	/**
	 * Upper-bound example
	 * Accept list of anything ...
	 */
	public static void printUpperBound(final List<?> elements) {
		// Some lambdas
		elements.forEach(System.out::println);
	}

	/**
	 * Lower-bound example
	 */
	public static void printLowerBound(final List<? super Two> elements) {
		elements.add(new Two());

		// It is not okay to add One as we have no idea is there any One in the list, but we will get Two's as those are specified in super ...
		//elements.add(new One()); // Compile error

		// Some lambdas
		elements.forEach(System.out::println);
	}
}

class One {

	@Override
	public String toString() {
		return "one";
	}

}

class Two extends One {

	@Override
	public String toString() {
		return "two";
	}

}
