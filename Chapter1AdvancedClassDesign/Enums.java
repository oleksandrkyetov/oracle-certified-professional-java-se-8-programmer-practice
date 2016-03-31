public class Enums {

	public static void main(final String[] args) {
		for (Season season : Season.values()) {
			System.out.println(season.ordinal() + ": " + season.getAnotherString());
		}

		final Season season = Season.SPRING;
		switch (season) {
			case FALL:
				System.out.println("It is fall already :( ...");
				break;
			case SPRING:
				System.out.println("Yay!!! Spring is coming :) ...");
				break;
			default:
				System.out.println("What is going on ?!?!?");
		}
	}

}

enum Season {

	SUMMER("summer"), FALL("fall") {
		@Override
		public String getAnotherString() {
			return "autumn";
		}
	}, WINTER("winter"), SPRING("spring");

	private final String string;

	/**
	 * Enum constructor is called only once we try to access enum field first time in the program
	 */
	private Season(final String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}

	public String getAnotherString() {
		return getString();
	};

}
