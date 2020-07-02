package uebung_6_1;

public class Rectangle {

	private double width;
	private double height;

	/**
	 * Constructor
	 * 
	 * @param lenght
	 * @param width
	 */
	public Rectangle(double witdh, double height) {
		this.width = witdh;
		this.height = height;
	}

	/**
	 * Calculates the scope of the rectangle
	 * 
	 * @return scope of this rectangle
	 */
	public double calculateScope() {
		return 2 * this.width + 2 * this.height;
	}

	/**
	 * Calculates the area of this rectangle
	 * 
	 * @return area of this rectangle
	 */
	protected double calculateArea() {
		return this.width * this.height;
	}

	protected double getWidth() {
		return this.width;
	}

	protected void setWidth(double width) {
		this.width = width;
	}

	protected double getHeight() {
		return height;
	}

	protected void setHeight(double height) {
		this.height = height;
	}
}
