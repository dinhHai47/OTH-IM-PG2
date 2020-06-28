package uebung_12_1.base;

public class MyItem {
	private int id;
	private String name;
	
	public MyItem(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", ID" + id;
	}

}
