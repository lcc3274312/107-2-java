package inheritance;

public class Rect extends Shape {

	private int width;

	public Rect(int h, int w) {
		super(h);
		width = w;
	}

	public Rect() {
		super();
		
	}

	public void setWidth(int w) {
		width = w;
	}

	public int getWidth() {
		return width;
	}

	public void draw() {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
