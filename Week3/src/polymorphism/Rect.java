package polymorphism;

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

	
	@Override
	public String toString() {
		return "Rect [width=" + width + ", height=" + height + "]";
	}

	public void draw() {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
