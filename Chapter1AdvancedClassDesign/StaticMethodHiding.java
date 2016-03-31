public class StaticMethodHiding {

	public static void main(final String... args) {
		final StaticMethodHiding staticMethodHiding = new ChildStaticMethodHiding();
		// StaticMethodHiding method will be called, because reference type is StaticMethodHiding
		staticMethodHiding.doIt();
		// ChildStaticMethodHiding will be called, because of polymorphism, overriding and real object type
		staticMethodHiding.overridenDoIt();

		final ChildStaticMethodHiding childStaticMethodHiding = new ChildStaticMethodHiding();
		// ChildStaticMethodHiding method will be called, because reference type is ChildStaticMethodHiding
		childStaticMethodHiding.doIt();
		// ChildStaticMethodHiding will be called, because of polymorphism, overriding and real object type
		childStaticMethodHiding.overridenDoIt();
	}

	/**
	 * Should be static as child method is static
	 * Static could be removed if static is removed from child method
	 */
	public static void doIt() {
		System.out.println("StaticMethodHiding.doIt()");
	}

	public void overridenDoIt() {
		System.out.println("StaticMethodHiding.overrienDoIt()");
	}

}

class ChildStaticMethodHiding extends StaticMethodHiding {

	/**
	 * Should be static as parent method is static
	 * Static could be removed if static is removed from parent method
	 */
	public static void doIt() {
		System.out.println("ChildStaticMethodHiding.doIt()");
	}

	@Override
	public void overridenDoIt() {
		System.out.println("ChildStaticMethodHiding.overrienDoIt()");
	}

}
