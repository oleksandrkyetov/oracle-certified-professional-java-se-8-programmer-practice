public class Interfaces {

	public static void main(final String[] args) {
		final Bouncable bouncable = new Ball();

		Bouncable.performBounce(bouncable);
		bouncable.bounce();
		System.out.println(bouncable.getName());
	}

}

interface Bouncable {

	void bounce();

	static void performBounce(final Bouncable bouncable) {
		bouncable.bounce();
	}

	default String getName() {
		return "Bouncable";
	}

}

class Ball implements Bouncable {

	public void bounce() {
		System.out.println("Ball bounces ...");
	}

}
