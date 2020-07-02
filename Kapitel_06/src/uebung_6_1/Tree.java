package uebung_6_1;

public class Tree {
	private int age;
	private int height;

	public Tree(int age, int height) {
		this.age = age;
		this.height = height;
	}

	protected int getAge() {
		return age;
	}

	protected void setAge(int age) {
		this.age = age;
	}

	protected int getHeight() {
		return height;
	}

	protected void setHeight(int height) {
		this.height = height;
	}

	// Method to harvest this tree
	public void harvest() {
		System.out.println("Sie haben nichts geerntet");
	}
}
