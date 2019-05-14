package revised;

public class Vtri extends Shape {
	private int type;
	final int UpLeft = 1;
	final int UpRight = 2;
	final int DownLeft = 3;
	final int DownRight = 4;

	public Vtri(int height, int type, boolean filled,String c) {
		super(height, filled,c);
		this.type = type;
	}
	public Vtri(int height, int type, boolean filled) {
		super(height, filled);
		this.type = type;
	}

	public void upLeft() {
		if (filled) {
			for (int i = 1; i <= height; i++) {
				prchar(c, i);
				System.out.println();
			}
		} else {
			for (int i = 1; i <= height; i++) {
				if (i == 1 || i == height) {
					prchar(c, i);
				} else {
					System.out.print(c);
					prchar(" ", i - 2);
					System.out.print(c);
				}
				System.out.println();
			}
		}
	}

	public void upRight() {
		for (int i = 1; i <= height; i++) {
			prchar(" ", height - i);
			prchar("*", i);
			System.out.println();
		}
	}

	public void downLeft() {
		for (int i = 1; i <= height; i++) {
			prchar("*", height - i + 1);
			System.out.println();
		}

	}

	public void downRight() {
		for (int i = 1; i <= height; i++) {
			prchar(" ", i - 1);
			prchar("*", height - i + 1);
			System.out.println();
		}
	}

	public void draw() {
		switch (type) {
		case UpLeft:
			upLeft();
			break;
		case UpRight:
			upRight();
			break;
		case DownLeft:
			downLeft();
			break;
		case DownRight:
			downRight();
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

	@Override
	public String toString() {
		return String.format("Height = %d; type = %s; filled = %s; char = %s",height,type,filled,c);
	}

}
