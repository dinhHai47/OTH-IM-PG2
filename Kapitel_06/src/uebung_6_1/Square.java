package uebung_6_1;

public class Square extends Rectangle {

	/**
	 * Constructor
	 * 
	 * @param length
	 */
	public Square(double length) {
		// Just calling the super-class constructor because every square is a rectangle,
		// where width and height is identical
		super(length, length);
	}

}
