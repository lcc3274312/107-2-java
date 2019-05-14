package thesday;

public class Vtri {
	private int height;
	private int type;

	public Vtri(int height, int type) {
		this.height = height;
		this.type = type;
	}

	public void draw() {
		switch (type) {
		case 1:
			for (int i = 1; i <= height; i++) {
				prchar("*", i);
				System.out.println();
			}
			break;
		case 2:
			for (int i = 1; i <= height; i++) {
				prchar(" ", height-i);
				prchar("*",i);
				System.out.println();
			}
			break;
		case 3:
			for (int i = 1; i <= height; i++) {
				prchar("*", height-i+1);
				System.out.println();
			}
			break;
		case 4:
			for (int i = 1; i <= height; i++) {
				prchar(" ",i-1);
				prchar("*", height-i+1);
				System.out.println();
			}
			break;
		}
	}

	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	void prchar(String c, int n) {
		for (int i = 1; i <= n; i++)
			System.out.printf(c);
	}
}
