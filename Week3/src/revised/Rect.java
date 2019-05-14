package revised;

public class Rect extends Shape {

	private int width;

	public Rect(int h, int w, boolean filled,String c) {
		super(h, filled,c);
		width = w;
	}
	public Rect(int h, int w, boolean filled) {
		super(h, filled);
		width = w;
	}

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
		return String.format("Height = %d; width = %d; filled = %s; char = %s",height,width,filled,c);
	}

	public void draw() {
		if (filled) {
			for (int i = 1; i <= height; i++) {
				for (int j = 1; j <= width; j++)
					System.out.print(c);
				System.out.println();
			}
		} else {
			for (int i = 1; i <= height; i++) {
				for (int j = 1; j <= width; j++)
				if(i==1||i==height||j==1||j==width)	
					System.out.print(c);
				else
					System.out.print(" ");
				System.out.println();
			}
		}
	}
}
