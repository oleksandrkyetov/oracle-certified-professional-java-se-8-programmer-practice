import java.util.function.Predicate;

public class FunctionalInterfacesAndLambdas {

	public static void main(final String... args) {
		/*
		 * Long lambda used
		 * Non conditional printing method is used
		 */
		toStringablePrint(
			new Instance("instance1"),
			(ToStringable toStringable) -> {
				return "[" + toStringable.toString() + "] " + toStringable.getString();
			}
		);

		/*
		 * Short lambda used
		 * Predicate returns true
		 */
		toStringablePrint(
			new Instance("instance2"),
			toStringable -> "[" + toStringable.toString() + "] " + toStringable.getString(),
			toStringable -> toStringable.getString().contains("instance")
		);

		/*
		 * Mixed lambda used
		 * Predicate returns false
		 */
		toStringablePrint(
			new Instance("3"),
			(toStringable) -> "[" + toStringable.toString() + "] " + toStringable.getString(),
			toStringable -> {
				return toStringable.getString().contains("instance");
			}
		);
	}

	/**
	 * Print ToStringable with a condition
	 */
	public static void toStringablePrint(final Instance instance, final ToStringer<ToStringable> toStringer, final Predicate<ToStringable> predicate) {
		if (predicate.test(instance)) {
			System.out.println("Printed with ToStringer: " + toStringer.toStringableToString(instance));
		} else {
			System.out.println("[ERROR] Not printed with ToStringer: " + toStringer.toStringableToString(instance));
		}
	}

	/**
	 * Print ToStringable
	 */
	public static void toStringablePrint(final Instance instance, final ToStringer<ToStringable> toStringer) {
		// Method delegation used
		toStringablePrint(
			instance,
			toStringer,
			toStringable -> true
		);

		//System.out.println("Printed with ToStringer: " + toStringer.toStringableToString(instance));
	}

}

interface ToStringable {

	String getString();

}

class Instance implements ToStringable {

	private final String string;

	Instance(final String string) {
		this.string = string;
	}

	@Override
	public String getString() {
		return string;
	}

}

@FunctionalInterface
interface ToStringer<ToStringable> {

	String toStringableToString(final ToStringable toStringable);

}

@FunctionalInterface
interface Bouncable {

	void bounce();

}

@FunctionalInterface
interface DefaultBouncable extends Bouncable {

	default String getName() {
		return "Bouncable";
	};

	static void doBounce(final Bouncable... bouncables) {
		for (Bouncable bouncable : bouncables) {
			bouncable.bounce();
		}
	};

}
