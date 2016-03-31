public class AccessModifiers {

	public static void main(String[] args) {
		System.out.println(new SiblingAccessModifiers().protectedAccess);
		System.out.println(new SiblingAccessModifiers().defaultAccess);
		System.out.println(new SiblingAccessModifiers().publicAccess);

		System.out.println(new ChildAccessModifiers().protectedAccess);
		System.out.println(new ChildAccessModifiers().defaultAccess);
		System.out.println(new ChildAccessModifiers().publicAccess);
	}

}

class SiblingAccessModifiers {

	private String privateAccess = "SiblingAccessModifiers.private"; // No access
	protected String protectedAccess = "SiblingAccessModifiers.protected";
	String defaultAccess = "SiblingAccessModifiers.default";
	public String publicAccess = "SiblingAccessModifiers.public";

}

class ChildAccessModifiers extends AccessModifiers {

	private String privateAccess = "ChildAccessModifiers.private"; // No access
	protected String protectedAccess = "ChildAccessModifiers.protected";
	String defaultAccess = "ChildAccessModifiers.default";
	public String publicAccess = "ChildAccessModifiers.public";

}
