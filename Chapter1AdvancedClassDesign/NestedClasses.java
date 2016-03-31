public class NestedClasses {

	private String privateString = "NestedClasses.privateString";

	public void doIt() {
		String localString = "localString";

		/**
		 * Local inner class
		 * Do not have access specifier
		 * Can access members of enclosing class
		 * Can not have static members
		 * Can access local variables if those are effectively final (may not be marked final, but do not change after initialized)
		 * Object of this class type can be returned from method and used as any other type or variable
		 */
		class LocalInnerClass {
			private String privateString = "LocalInnerClass.privateString";

			public void doIt() {
				System.out.println(LocalInnerClass.this.privateString + " " + NestedClasses.this.privateString + " " + localString);
			}
		}

		// Call method of member inner class
		new MemberInnerClass().doIt();

		// Call method of local inner class
		new LocalInnerClass().doIt();

		/**
		 * Anonymous inner class (implements interface and overrides it methods "inline")
		 * Can not extend class and imlement interface at the same time
		 * Can be define right where we need it, even as a parameter to the method
		 */
		new PrivateInterface() {
			private String privateString = "anonymous.privateString";

			@Override
			public void doIt() {
				System.out.println(this.privateString + " " + NestedClasses.this.privateString + " " + localString);
			}
		// Call method of anonymous inner class
		}.doIt();
	}

	public static void main(final String[] args) {
		/*
		 * Weird way to create member inner class
		 * Notice reference type notation, however we could just use inner class name as a reference without any problem
		 */
		final NestedClasses.MemberInnerClass memberInnerClass = new NestedClasses().new MemberInnerClass();
		memberInnerClass.doIt();

		// Call member inner class from instance of NestedClasses
		final NestedClasses nestedClasses = new NestedClasses();
		nestedClasses.doIt();

		// Call static nested class without creating an instalnce of outer class
		final NestedClasses.StaticNestedClass staticNestedClass = new StaticNestedClass();
		staticNestedClass.doIt();
	}

	/**
	 * We can have private member inner interface without any problems, but it will be accessible only inside the class it is declared
	 * On the other hand interface methods still need to be public and implemented in the concrete child class
	 */
	private interface PrivateInterface {

		void doIt();

	}

	/**
	 * Member inner class
	 * Can have any access modifier
	 * Can not have static members
	 */
	private class MemberInnerClass implements PrivateInterface {
		private String privateString = "MemberInnerClass.privateString";

		@Override
		public void doIt() {
			/*
			 * Access private instance variable of parent from inner class with weird syntax <OuterClassName>.this.<fieldName>
			 * Take into account that there is no level restriction of how many outer classes you can access from inner class using this approach
			 */
			System.out.println(MemberInnerClass.this.privateString + " " + NestedClasses.this.privateString);
		}
	}

	/**
	 * Creates namespace together with outer class, for example variable type should be specified like <OuterClassName>.<StaticNestedClassName>
	 * Do not require instance of outer class to be used
	 * Outer class can refer to methods and fields of nested class (even private)
	 * Can be imported either with normal import or with static import
	 * Can have static members
	 */
	public static class StaticNestedClass {
		private String privateString = "StaticNestedClass.privateString";

		public void doIt() {
			System.out.println(StaticNestedClass.this.privateString);
		}

	}

}
