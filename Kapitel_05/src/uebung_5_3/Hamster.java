package uebung_5_3;

public class Hamster extends FieldObject {

	private String name;
	private int x;
	private int y;
	private int cornAmount = 0;

	public Hamster(char symbol, String name, int x, int y) {
		super(symbol);
		this.x = x;
		this.y = y;
		this.name = name;
	}

	// setter
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCornAmount(int cornAmount) {
		this.cornAmount = cornAmount;
	}

	// getter
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public String getName() {
		return this.name;
	}

	public int getCornAmount() {
		return this.cornAmount;
	}

	// operations

	public void left() {
		switch (this.getSymbol()) {
		case '<':
			this.setSymbol('v');
			break;
		case 'v':
			this.setSymbol('>');
			break;
		case '>':
			this.setSymbol('^');
			break;
		case '^':
			this.setSymbol('<');
			break;
		}
	}

	public void right() {
		switch (this.getSymbol()) {
		case '<':
			this.setSymbol('^');
			break;
		case 'v':
			this.setSymbol('<');
			break;
		case '>':
			this.setSymbol('v');
			break;
		case '^':
			this.setSymbol('>');
			break;
		}
	}

	public FieldObject[][] goForward(FieldObject[][] field) {
		int newX = 0;
		int newY = 0;

		// move the position of the coordinates
		if (this.getSymbol() == '>') {
			newX = this.getX();
			newY = this.getY() + 1;
		}
		else if (this.getSymbol() == 'v') {
			newX = this.getX() + 1;
			newY = this.getY();
		}
		else if (this.getSymbol() == '<') {
			newX = this.getX();
			newY = this.getY() - 1;
		}
		else if (this.getSymbol() == '^') {
			newX = this.getX() - 1;
			newY = this.getY();
		}

		if (field[newX][newY] instanceof Wall) {
			System.out.println("Achtung Wand");
		}
		else {
			if (field[newX][newY] instanceof Corn) {
				System.out.println("Fresse Korn");
				this.cornAmount++;
			}

			field[this.getX()][this.getY()] = new EmptyField(' ');
			field[newX][newY] = this;
			this.x = newX;
			this.y = newY;
		}

		return field;
	}
}
