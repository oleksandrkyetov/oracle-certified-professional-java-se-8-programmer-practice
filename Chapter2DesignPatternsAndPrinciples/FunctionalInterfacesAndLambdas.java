public class FunctionalInterfacesAndLambdas {

	public static void main(final String... args) {

	}

}

class Instance {

	public 

}

@FunctionalInterface
interface Check {

	void test(final Instance instance);

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
